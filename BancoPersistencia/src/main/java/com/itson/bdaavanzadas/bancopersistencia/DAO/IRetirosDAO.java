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

    /**
     * Método para crear el retiro
     *
     * @param id_cuenta cuenta a la cual se le generara
     * @param monto monto a retirar
     * @return retiro creado
     * @throws PersistenciaException en caso de no poder generarlo
     */
    public Retiro crearRetiro(Long id_cuenta, float monto) throws PersistenciaException;

    /**
     * Método para encontrar retiro
     *
     * @param id_retiro id del retiro
     * @return retiro
     * @throws PersistenciaException en caso de no encontrar el retiro
     */
    public Retiro obtenerRetiroPorID(Long id_retiro) throws PersistenciaException;

    /**
     * Método para llevar a cabo un retiro
     *
     * @param folio folio del retiro
     * @param contrasenia contraseña del retiro
     * @throws PersistenciaException
     */
    public void realizarRetiro(Long folio, String contrasenia, Timestamp fecha_realizar) throws PersistenciaException;

    /**
     * Método para obtener un cliente, solo su nombre y apellido
     *
     * @param folioRetiro folio del retiro
     * @return
     * @throws PersistenciaException
     */
    public Cliente obtenerClientePorFolioRetiro(Long folioRetiro) throws PersistenciaException;

    /**
     * Este método nos ayuda a obtener un retiro mediante el folio de este mismo
     *
     * @param folio folio del retiro.
     * @return retiro.
     * @throws PersistenciaException
     */
    public Retiro obtenerRetiroPorFolio(Long folio) throws PersistenciaException;
}
