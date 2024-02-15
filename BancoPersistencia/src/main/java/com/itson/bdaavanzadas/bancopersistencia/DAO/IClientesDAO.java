package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.DTO.ClienteActualizadoDTO;
import com.itson.bdaavanzadas.bancopersistencia.DTO.ClienteNuevoDTO;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.util.List;
import org.itson.bdavanzadas.bancodominio.Cliente;

/**
 *
 * @author Hector Espinoza Y Enrique Rodriguez
 */
public interface IClientesDAO {
    
    Cliente agregarCliente (ClienteNuevoDTO clienteNuevo) throws PersistenciaException;
    
    List <Cliente> consultar() throws PersistenciaException;

    public void eliminarCliente(Long id);
    
    public Cliente actualizarCliente (ClienteActualizadoDTO clienteActualizado) throws PersistenciaException;

    
}
