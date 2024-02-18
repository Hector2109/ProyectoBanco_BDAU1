package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enrique Rodriguez
 */
public class TransferenciasDAO implements ITransferenciasDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(CuentasDAO.class.getName());

    public TransferenciasDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    /**
     * Este método funciona como una transferencia, se conecta
     *
     * @param saldo
     * @param cuenta_destino
     * @param cuenta_receptora
     */
    @Override
    public void transferir(float saldo, Long cuenta_destino, Long cuenta_receptora) throws PersistenciaException {
        if (cuenta_destino == cuenta_receptora) {
            throw new PersistenciaException("No es posible transferir a tu misma cuenta");
        }
        String sentenciaSQL = "CALL realizar_transferencia(?, ?, ?);";
        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement
            (sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {
            comando.setFloat(1, saldo);
            comando.setLong(2, cuenta_destino);
            comando.setLong(3, cuenta_receptora);
            comando.executeUpdate();
            logger.log(Level.INFO, "Se realizó la transferencia");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo transferir", ex);
            if (ex.getSQLState().equals("45000")) {
                throw new PersistenciaException("No es posible transferir");
            }
        }
    }

}
