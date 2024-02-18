package com.itson.bdaavanzadas.bancopersistencia.DAO;
import static com.itson.bdaavanzadas.bancopersistencia.DAO.CuentasDAO.logger;
import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio.Transferencia;

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
     * @param saldo
     * @param cuenta_destino
     * @param cuenta_receptora 
     */
    @Override
    public void transferir(float saldo, Long cuenta_destino, Long cuenta_receptora) {
        String sentenciaSQL = "CALL realizar_transferencia(?, ?, ?);";
        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {
             comando.setFloat(1, saldo);
             comando.setLong(2, cuenta_destino);
             comando.setLong(3, cuenta_receptora);
             comando.executeUpdate();
             logger.log(Level.INFO, "Se realizó la transferencia");
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo transferir", ex);
        }
    }

}
