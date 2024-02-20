/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Transaccion;

/**
 *
 * @author Enrique Rodriguez
 */
public class TransaccionDAO implements ITransaccionDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(CuentasDAO.class.getName());

    /**
     * Constructor que establece la conexión con la base de datos.
     * @param conexion 
     */
    public TransaccionDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }
    
    /**
     * Método que consulta todas las transacciones, de todas las cuentas de 
     * un cliente en especifico.
     * 
     * @param cliente cliente
     * @return Lista de transacciones.
     * @throws PersistenciaException 
     */
    @Override
    public List<Transaccion> consultar(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = """
                              SELECT r.id_transaccion, t.fecha, t.saldo_transaccion, c.num_cuenta, 'retiro' AS tipo_transaccion
                              FROM retiros r
                              INNER JOIN transacciones t ON r.id_transaccion = t.id_transaccion
                              INNER JOIN cuentas c ON t.num_cuenta = c.num_cuenta
                              INNER JOIN clientes cl ON c.id_cliente = cl.id_cliente
                              WHERE cl.id_cliente = ?
                              UNION
                              SELECT tr.id_transaccion, t.fecha, t.saldo_transaccion, c.num_cuenta, 'transferencia' AS tipo_transaccion
                              FROM transferencia tr
                              INNER JOIN transacciones t ON tr.id_transaccion = t.id_transaccion
                              INNER JOIN cuentas c ON t.num_cuenta = c.num_cuenta
                              INNER JOIN clientes cl ON c.id_cliente = cl.id_cliente
                              WHERE cl.id_cliente = ? AND t.id_transaccion NOT IN (SELECT id_transaccion FROM retiros)
                              ORDER BY fecha DESC;
                              """;
        List<Transaccion> transferencias = new LinkedList<>();
        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
            comando.setLong(1, cliente.getId_cliente());
            comando.setLong(2, cliente.getId_cliente());
            try (ResultSet resultados = comando.executeQuery()) {
                while (resultados.next()) {
                    Long id_transaccion = resultados.getLong("id_transaccion");
                    float saldo_transaccion = resultados.getFloat("saldo_transaccion");
                    Date fecha = resultados.getDate("fecha");
                    String tipo_transaccion = resultados.getString("tipo_transaccion");
                    Long num_cuenta = resultados.getLong("num_cuenta");
                    
                    Transaccion transaccion = new Transaccion(id_transaccion, saldo_transaccion, fecha, tipo_transaccion, num_cuenta);
                    transferencias.add(transaccion);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "ERROR", ex);
            throw new PersistenciaException("falló la creacion de la tabla", ex);
        }
        return transferencias;
    }

}
