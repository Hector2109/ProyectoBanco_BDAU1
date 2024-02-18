package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import org.itson.bdavanzadas.bancodominio.Retiro;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public interface IRetirosDAO {
    
    public Retiro crearRetiro (Long id_cuenta, float monto) throws PersistenciaException;
    
     public Retiro obtenerRetiroPorID(Long id_retiro) throws PersistenciaException;
}
