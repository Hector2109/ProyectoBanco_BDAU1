package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.sql.Timestamp;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Retiro;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public interface IRetirosDAO {
    
    public Retiro crearRetiro (Long id_cuenta, float monto) throws PersistenciaException;
    
     public Retiro obtenerRetiroPorID(Long id_retiro) throws PersistenciaException;
     
     public void realizarRetiro (Long folio, String contrasenia, Timestamp fecha_realizar) throws PersistenciaException;
     
      public Cliente obtenerClientePorFolioRetiro(Long folioRetiro) throws PersistenciaException;
      
      public Retiro obtenerRetiroPorFolio(Long folio) throws PersistenciaException;
}
