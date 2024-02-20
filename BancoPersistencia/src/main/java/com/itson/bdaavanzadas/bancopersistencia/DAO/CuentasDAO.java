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
import java.util.LinkedList;
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

    /**
     * Crea una cuenta nueva a un cliente
     *
     * @param cuentaNueva cuenta nueva
     * @param cliente cliente
     * @param monto monto
     * @return cuenta que se agrego
     * @throws PersistenciaException
     */
    @Override
    public Cuenta crearCuenta(CuentaNuevaDTO cuentaNueva, Cliente cliente, float monto) throws PersistenciaException {
        String sentenciaSQL = "INSERT INTO cuentas (saldo, fecha_apertura, estado, id_cliente) VALUES (?,?,?,?)";
        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {
            comando.setFloat(1, cuentaNueva.getSaldo());
            java.sql.Date fechaApertura = new java.sql.Date(cuentaNueva.getFecha_apertura().getTime());
            comando.setDate(2, fechaApertura);
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

    /**
     * Regresa la lista de cuentas de un cliente
     *
     * @return Lista de cuentas
     * @throws PersistenciaException En caso de algúne error
     */
    @Override
    public List<Cuenta> consultar(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = "SELECT cuentas.num_cuenta, cuentas.saldo, cuentas.estado FROM cuentas INNER JOIN "
                + "clientes on clientes.id_cliente = cuentas.id_cliente where cuentas.id_cliente = ?";
        List<Cuenta> cuentas = new LinkedList<>();
        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
            comando.setLong(1, cliente.getId_cliente());
            try (ResultSet resultados = comando.executeQuery()) {
                while (resultados.next()) {
                    Long num_cuenta = resultados.getLong("cuentas.num_cuenta");
                    float saldo = resultados.getFloat("cuentas.saldo");
                    byte estado = resultados.getByte("cuentas.estado");
                    Cuenta cuenta = new Cuenta(num_cuenta, saldo, estado);
                    cuentas.add(cuenta);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo iniciar sesión", ex);
            throw new PersistenciaException("Error al iniciar sesión, verifique sus datos", ex);
        }
        return cuentas;
    }
    
    @Override
    public void actualizarMonto(Long num_cuenta, float monto) {
        String sentenciaSQL = """
                              UPDATE cuentas
                              SET saldo = saldo + ?
                              WHERE num_cuenta = ?
                              """;
         try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {
             comando.setFloat(1, monto);
             comando.setLong(2, num_cuenta);
         } catch (SQLException ex) {
            Logger.getLogger(CuentasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene el nombre del cliente de una cuenta
     *
     * @param cuenta cuenta
     * @return nombre del cliente
     * @throws PersistenciaException en caso de error
     */
    @Override
    public String obtenerNombreCuenta(Cuenta cuenta) throws PersistenciaException {
        String sentenciaSQL = """
        SELECT concat(cl.nombre, " ", cl.apellido_paterno) AS nombre_completo, cu.estado  FROM cuentas AS cu INNER JOIN 
                clientes AS cl ON cl.id_cliente = cu.id_cliente
                WHERE cu.num_cuenta = ?;  """;

        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, cuenta.getNum_cuenta());
            try (ResultSet resultados = comando.executeQuery()) {
                if (resultados.next()) {

                    String nombre = resultados.getString("nombre_completo");
                    Byte estado = resultados.getByte("cu.estado");

                    logger.log(Level.INFO, "Se encontró la cuenta de forma exitosa");

                    if (estado == 0) {
                        throw new PersistenciaException("Esta cuenta se enceuntra desactivada");
                    } else {
                        return nombre;
                    }
                } else {
                    logger.log(Level.SEVERE, "Cuenta no existente");
                    throw new PersistenciaException("Cuenta no existente");
                }

            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo ENCONTRAR LA CUENTA", ex);
            throw new PersistenciaException("Error: No se puede encontrar la cuenta", ex);
        }

    }

    /**
     * Método el cual desactiva o activa la cuenta de un usuario cambiando su
     * estado
     * @param cuenta cuenta que se desactiavara o activara
     * @throws PersistenciaException
     */
    @Override
    public void activacionCuenta(Cuenta cuenta) throws PersistenciaException {
        String sentenciaSQL = """
                             UPDATE cuentas SET estado = ?
                             WHERE num_cuenta = ?
                             """;

        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            if (cuenta.getEstado() == 1) {
                comando.setByte(1, (byte) 0);
            } else {
                comando.setByte(1, (byte) 1);
            }
            comando.setLong(2, cuenta.getNum_cuenta());

            comando.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CuentasDAO.class.getName()).log(Level.SEVERE, "Error al cambiar el estado de la cuenta", ex);
            throw new PersistenciaException("Error: No se pudo cambiar el estado de la cuenta", ex);
        }
    }
}
