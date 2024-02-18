package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio.Retiro;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class RetirosDAO implements IRetirosDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(CuentasDAO.class.getName());

    public RetirosDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    /**
     * Método para crear el retiro
     * @param id_cuenta cuenta a la cual se le generara
     * @param monto monto a retirar
     * @return retiro creado
     * @throws PersistenciaException en caso de no poder generarlo
     */
    @Override
    public Retiro crearRetiro(Long id_cuenta, float monto) throws PersistenciaException {
        String sentenciaSQL = "{CALL crear_retiro(?, ?, ?)}";
        try (Connection conexion = this.conexionBD.obtenerConection(); CallableStatement comando = conexion.prepareCall(sentenciaSQL)) {

            comando.setLong(1, id_cuenta);
            comando.setFloat(2, monto);
            comando.registerOutParameter(3, Types.BIGINT);

            comando.executeUpdate();

            Long id_retiro = comando.getLong(3);

            logger.log(Level.INFO, "Se creó el retiro de forma exiosa");

            Retiro retiro = obtenerRetiroPorID(id_retiro);
            return retiro;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo generar el retiro", ex);
            throw new PersistenciaException("Error al crear el retiro", ex);
        }
    }

    /**
     * Método para encontrar retiro
     * @param id_retiro id del retiro
     * @return retiro 
     * @throws PersistenciaException en caso de no encontrar el retiro
     */
    @Override
    public Retiro obtenerRetiroPorID(Long id_retiro) throws PersistenciaException {
        Retiro retiro = null;
        String sentenciaSQL = "SELECT folio, contrasenia, estado, id_transaccion, saldo_transaccion, fecha, num_cuenta FROM retiros WHERE id_transaccion = ?";

        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, id_retiro);

            try (ResultSet resultados = comando.executeQuery()) {
                if (resultados.next()) {

                    retiro = new Retiro();
                    retiro.setFolio(resultados.getLong("folio"));
                    retiro.setContrasenia(resultados.getString("contrasenia"));
                    retiro.setEstado(resultados.getByte("estado"));
                    retiro.setId_transaccion(resultados.getLong("id_transaccion"));
                    retiro.setSaldo_transaccion(resultados.getFloat("saldo_transaccion"));
                    retiro.setFecha(resultados.getTimestamp("fecha"));
                    retiro.setNum_cuenta(resultados.getLong("num_cuenta"));

                    logger.log(Level.SEVERE, "Se encontro el retiro de forma exitosa");

                } else {
                    logger.log(Level.SEVERE, "No se encontro el retiro");
                    throw new PersistenciaException("Error: Retiro no encontrado");
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo encontrar el retiro", ex);
            throw new PersistenciaException("Error al intenter encontrar retiro", ex);
        }
        return retiro;
    }
}
