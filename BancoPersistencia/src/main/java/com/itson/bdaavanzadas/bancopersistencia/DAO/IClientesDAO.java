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
    
    /**
     * Método que contiene la sentencia SQL para agregar el cliente a la base de
     * datos
     *
     * @param clienteNuevo cliente nuevo
     * @return cliente que se agrego
     * @throws PersistenciaException en caso de un error al agregar al cliente
     */
    Cliente agregarCliente (ClienteNuevoDTO clienteNuevo) throws PersistenciaException;
    
    /**
     * Regresa una lista de los clientes del banco con ayuda de una sentencia SQL
     *
     * @return lizsta de clientes
     * @throws PersistenciaException
     */
    List <Cliente> consultar() throws PersistenciaException;
    
    /**
     * Contiene la sentencia SQL apra lograr eliminar un cliente de la base de
     * datos
     *
     * @param id id del cliente
     */
    public void eliminarCliente(Long id);
    
    /**
     * Contiene la sentencia SQL para actualizar un cliente de la base de datos
     *
     * @param clienteActualizado cliente actualizado.
     * @return Cliente
     * @throws PersistenciaException En caso de algún error
     */
    public Cliente actualizarCliente (ClienteActualizadoDTO clienteActualizado) throws PersistenciaException;
    
    /**
     * Método para iniciar sesión en el banco
     *
     * @param cliente
     * @return
     * @throws PersistenciaException
     */
    public Cliente iniciarSesion (Cliente cliente) throws PersistenciaException;
    
    /**
     * Método para obtener cliente por medio de su correo
     *
     * @param correo correo del cliente
     * @return
     * @throws PersistenciaException
     */
    public Cliente obtenerClienteCorreo(String correo) throws PersistenciaException;
    
}
