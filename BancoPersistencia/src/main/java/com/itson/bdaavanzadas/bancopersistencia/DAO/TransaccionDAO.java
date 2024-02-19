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

    public TransaccionDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public List<Transaccion> consultar(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = """
                              SELECT r.id_transaccion, t.fecha, t.saldo_transaccion, 'retiro' AS tipo_transaccion
                              FROM retiros r
                              INNER JOIN transacciones t ON r.id_transaccion = t.id_transaccion
                              INNER JOIN cuentas c ON t.num_cuenta = c.num_cuenta
                              WHERE c.num_cuenta = ?
                              UNION
                              SELECT tr.id_transaccion, t.fecha, t.saldo_transaccion, 'transferencia' AS tipo_transaccion
                              FROM transferencia tr
                              INNER JOIN transacciones t ON tr.id_transaccion = t.id_transaccion
                              INNER JOIN cuentas c ON t.num_cuenta = c.num_cuenta
                              WHERE c.num_cuenta = ? AND t.id_transaccion NOT IN (SELECT id_transaccion FROM retiros)
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
                    
                    Transaccion transaccion = new Transaccion(id_transaccion, saldo_transaccion, fecha, tipo_transaccion);
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
