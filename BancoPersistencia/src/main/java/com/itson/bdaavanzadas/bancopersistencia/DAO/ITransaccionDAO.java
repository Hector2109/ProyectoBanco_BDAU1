package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.util.List;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Transaccion;

/**
 *
 * @author Enrique Rodriguez y Hector Espinoza
 */
public interface ITransaccionDAO {

    /**
     * Método que consulta todas las transacciones, de todas las cuentas de un
     * cliente en especifico.
     *
     * @param cliente cliente
     * @return Lista de transacciones.
     * @throws PersistenciaException
     */
    List<Transaccion> consultar(Cliente cliente) throws PersistenciaException;
}
