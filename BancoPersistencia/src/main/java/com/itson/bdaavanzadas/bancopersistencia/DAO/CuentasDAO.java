/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.DTO.CuentaActualizadaDTO;
import com.itson.bdaavanzadas.bancopersistencia.DTO.CuentaNuevaDTO;
import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Cuenta;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class CuentasDAO implements ICuentasDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(CuentasDAO.class.getName());

    public CuentasDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public Cuenta crearCuenta(CuentaNuevaDTO cuentaNueva, Cliente cliente, float monto) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO cuentas (saldo, fecha_apertura, estado, id_cliente) VALUES (?,?,?,?)";
        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {
            comando.setFloat(1, cuentaNueva.getSaldo());
            comando.setString(2, cuentaNueva.getFecha_apertura().toString());
            comando.setByte(3, cuentaNueva.getEstado());
            comando.setLong(4, cuentaNueva.getId_cliente());

            logger.log(Level.INFO, "Se agregaron {1} cuentas");
            comando.executeUpdate();

            ResultSet idsGenerados = comando.getGeneratedKeys();
            idsGenerados.next();
            Cuenta cuenta = new Cuenta(idsGenerados.getLong(1), cuentaNueva.getSaldo(), cuentaNueva.getFecha_apertura(), cuentaNueva.getEstado(), cuentaNueva.getId_cliente());
            return cuenta;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo crear la cuenta", ex);
            throw new PersistenciaException("No se pudo crear la cuenta", ex);
        }
    }

    @Override
    public List<Cuenta> consultar() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void desactivarCuenta(int num_cuenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cuenta actualizarCliente(CuentaActualizadaDTO cuentaActualizada) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
