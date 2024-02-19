package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio.Cliente;
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
     *
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
     *
     * @param id_retiro id del retiro
     * @return retiro
     * @throws PersistenciaException en caso de no encontrar el retiro
     */
    @Override
    public Retiro obtenerRetiroPorID(Long id_retiro) throws PersistenciaException {
        Retiro retiro = null;
        String sentenciaSQL = "SELECT folio, contrasenia, estado, id_transaccion "
                + "FROM retiros "
                + "WHERE id_transaccion = ?";

        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, id_retiro);

            try (ResultSet resultados = comando.executeQuery()) {
                if (resultados.next()) {
                    retiro = new Retiro();
                    retiro.setFolio(resultados.getLong("folio"));
                    retiro.setContrasenia(resultados.getString("contrasenia"));
                    retiro.setEstado(resultados.getByte("estado"));
                    retiro.setId_transaccion(resultados.getLong("id_transaccion"));

                    logger.log(Level.SEVERE, "Se encontró el retiro de forma exitosa");
                } else {
                    logger.log(Level.SEVERE, "No se encontró el retiro con folio: " + id_retiro);
                    throw new PersistenciaException("Error: Retiro no encontrado");
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo encontrar el retiro", ex);
            throw new PersistenciaException("Error al intentar encontrar retiro", ex);
        }
        return retiro;
    }

    /**
     * Método para llevar a cabo un retiro
     *
     * @param folio folio del retiro
     * @param contrasenia contraseña del retiro
     * @return
     * @throws PersistenciaException
     */
    @Override
    public void obtenerRetiro(Long folio, String contrasenia, Timestamp fecha_realizar) throws PersistenciaException {
        String sentenciaSQL = "CALL realizar_retiro(?, ?, ?)";

        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, folio);
            comando.setString(2, contrasenia);
            comando.setTimestamp(3, fecha_realizar);

            comando.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al intentar encontrar retiro", ex);
        }
    }

    
    /**
     * Método para obtener un cliente, solo su nombre y apellido
     * @param folioRetiro folio del retiro
     * @return
     * @throws PersistenciaException 
     */
    public Cliente obtenerClientePorFolioRetiro(Long folioRetiro) throws PersistenciaException {
        Cliente cliente = null;
        String sentenciaSQL = "SELECT c.nombre, c.apellido_paterno "
                + "FROM retiros r "
                + "INNER JOIN transacciones t ON r.id_transaccion = t.id_transaccion "
                + "INNER JOIN cuentas ct ON t.num_cuenta = ct.num_cuenta "
                + "INNER JOIN clientes c ON ct.id_cliente = c.id_cliente "
                + "WHERE r.folio = ?";

        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, folioRetiro);

            try (ResultSet resultados = comando.executeQuery()) {
                if (resultados.next()) {
                    cliente = new Cliente();
                    cliente.setNombre(resultados.getString("nombre"));
                    cliente.setApellido_pa(resultados.getString("apellido_paterno"));
                }
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener cliente por folio de retiro", ex);
        }
        return cliente;
    }
}
