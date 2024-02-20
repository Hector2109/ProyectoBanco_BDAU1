package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.DTO.ClienteActualizadoDTO;
import com.itson.bdaavanzadas.bancopersistencia.DTO.ClienteNuevoDTO;
import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.bancodominio.Cliente;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class ClientesDAO implements IClientesDAO {

    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(ClientesDAO.class.getName());

    public ClientesDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }

    /**
     * Método que contiene la sentencia SQL para agregar el cliente a la base de
     * datos
     *
     * @param clienteNuevo cliente nuevo
     * @return cliente que se agrego
     * @throws PersistenciaException en caso de un error al agregar al cliente
     */
    @Override
    public Cliente agregarCliente(ClienteNuevoDTO clienteNuevo) throws PersistenciaException {
        String sentenciaSQL = """
            INSERT INTO clientes(nombre,apellido_paterno,apellido_materno,fecha_nacimiento,calle,colonia,
                              cp,num_casa,contrasenia, correo)
            VALUES (?,?,?,?,?,?,?,?,?,?);
                             """;

        if (obtenerClienteCorreo(clienteNuevo.getCorreo()) == null) {

            try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

                comando.setString(1, clienteNuevo.getNombre());
                comando.setString(2, clienteNuevo.getApellido_pa());
                comando.setString(3, clienteNuevo.getApellido_ma());
                comando.setString(4, clienteNuevo.getFecha_nacimiento().toString());
                comando.setString(5, clienteNuevo.getCalle());
                comando.setString(6, clienteNuevo.getColonia());
                comando.setString(7, clienteNuevo.getCp());
                comando.setString(8, clienteNuevo.getNumero_casa());
                comando.setString(9, clienteNuevo.getContrasenia());
                comando.setString(10, clienteNuevo.getCorreo());

                int numeroRegistrosInsertados = comando.executeUpdate();
                logger.log(Level.INFO, "Se agregaron {0} clientes", numeroRegistrosInsertados);
                ResultSet idsGenerados = comando.getGeneratedKeys();
                idsGenerados.next();
                Cliente cliente = new Cliente(idsGenerados.getLong(1), clienteNuevo.getNombre(), clienteNuevo.getApellido_pa(),
                        clienteNuevo.getApellido_ma(), clienteNuevo.getCalle(), clienteNuevo.getColonia(),
                        clienteNuevo.getNumero_casa(), clienteNuevo.getCp(), clienteNuevo.getContrasenia(), clienteNuevo.getCorreo());
                return cliente;
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "No se pudo guardar el cliente", ex);
                throw new PersistenciaException("No se pudo guardar el cliente", ex);
            }
        } else {
            throw new PersistenciaException("Este correo ya esta registrado");
        }
    }

    /**
     * Regresa una lista de los clientes del banco con ayuda de una sentencia SQL
     *
     * @return lizsta de clientes
     * @throws PersistenciaException
     */
    @Override
    public List<Cliente> consultar() throws PersistenciaException {
        String sentenciaSQL = """
            SELECT 
                c.id_cliente AS "ID", 
                CASE 
                    WHEN c.apellido_materno IS NOT NULL THEN CONCAT(c.nombre, ' ', c.apellido_paterno, ' ', c.apellido_materno) 
                    ELSE CONCAT(c.nombre, ' ', c.apellido_paterno) 
                END AS "Nombre Completo", 
                c.colonia AS Colonia, 
                c.calle AS Calle, 
                c.num_casa AS "Número de casa", 
                c.cp AS "Código postal", 
                FLOOR(DATEDIFF(CURDATE(), fecha_nacimiento) / 365) AS Edad,
                              c.correo AS Correo
            FROM clientes AS c;;
        """;
        List<Cliente> clientes = new LinkedList<>();
        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL); ResultSet resultados = comando.executeQuery();) {
            while (resultados.next()) {
                Long id = resultados.getLong("ID");
                String nombreCompleto = resultados.getString("Nombre Completo");
                String colonia = resultados.getString("Colonia");
                String calle = resultados.getString("Calle");
                String numeroCasa = resultados.getString("Número de casa");
                String cp = resultados.getString("Código postal");
                int edad = resultados.getInt("Edad");
                String correo = resultados.getString("Correo");
                // Crear el objeto Cliente con todos los parámetros y agregarlo a la lista
                Cliente cliente = new Cliente(id, nombreCompleto, calle, colonia, numeroCasa, cp, correo);
                clientes.add(cliente);
            }
            logger.log(Level.INFO, "Se consultario {0}", clientes.size());
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudieron consultar los Clientes", ex);
            throw new PersistenciaException("No se pudo consultar los Clientes", ex);
        }
        return clientes;
    }

    /**
     * Contiene la sentencia SQL apra lograr eliminar un cliente de la base de
     * datos
     *
     * @param id id del cliente
     */
    @Override
    public void eliminarCliente(Long id) {
        String sentenciaSQL = "DELETE FROM Clientes WHERE id = ?";

        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setLong(1, id);

            int numeroRegistrosEliminados = comando.executeUpdate();

            if (numeroRegistrosEliminados > 0) {
                logger.log(Level.INFO, "Se eliminó el Cliente con ID {0}", id);
            } else {
                logger.log(Level.INFO, "No se encontró el Cliente con ID {0} para eliminar", id);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo eliminar el Cliente", ex);
            try {
                throw new PersistenciaException("No se pudo eliminar el Cliente", ex);
            } catch (PersistenciaException ex1) {
                Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, "No se pudo eliminar el Cliente", ex1);
            }
        }
    }

    /**
     * Contiene la sentencia SQL para actualizar un cliente de la base de datos
     *
     * @param clienteActualizado cliente actualizado.
     * @return Cliente
     * @throws PersistenciaException En caso de algún error
     */
    @Override
    public Cliente actualizarCliente(ClienteActualizadoDTO clienteActualizado) throws PersistenciaException {
        String sentenciaSQL = """
            UPDATE clientes SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, 
                      fecha_nacimiento = ?, calle = ?,  colonia = ?, cp = ?, num_casa = ?, contrasenia = ?
                      WHERE correo = ?""";

        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS)) {

            comando.setString(1, clienteActualizado.getNombre());
            comando.setString(2, clienteActualizado.getApellido_pa());
            comando.setString(3, clienteActualizado.getApellido_ma());
            comando.setString(4, clienteActualizado.getFecha_nacimiento().toString());
            comando.setString(5, clienteActualizado.getCalle());
            comando.setString(6, clienteActualizado.getColonia());
            comando.setString(7, clienteActualizado.getCp());
            comando.setString(8, clienteActualizado.getNumero_casa());
            comando.setString(9, clienteActualizado.getContrasenia());
            comando.setString(10, clienteActualizado.getCorreo());

            int numeroRegistrosInsertados = comando.executeUpdate();

            logger.log(Level.INFO, "Se actualizo al cliente {0}", numeroRegistrosInsertados);

            return new Cliente(clienteActualizado.getId(), clienteActualizado.getNombre(), clienteActualizado.getApellido_pa(),
                    clienteActualizado.getApellido_ma(), clienteActualizado.getFecha_nacimiento(), clienteActualizado.getCalle(),
                    clienteActualizado.getColonia(), clienteActualizado.getCp(), clienteActualizado.getNumero_casa(), clienteActualizado.getContrasenia());

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo actualizar el cliente", ex);
            throw new PersistenciaException("No se pudo actualizar el cliente", ex);
        }
    }

    /**
     * Método para iniciar sesión en el banco
     *
     * @param cliente
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Cliente iniciarSesion(Cliente cliente) throws PersistenciaException {
        String sentenciaSQL = """
        SELECT id_cliente, nombre, apellido_paterno, apellido_materno, 
            fecha_nacimiento, calle, colonia, cp, num_casa, correo, contrasenia
        FROM clientes
        WHERE correo = ? AND contrasenia = ?""";
        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setString(1, cliente.getCorreo());
            comando.setString(2, cliente.getContrasenia());

            try (ResultSet resultados = comando.executeQuery()) {
                if (resultados.next()) {
                    Long id_cliente = resultados.getLong("id_cliente");
                    String nombre = resultados.getString("nombre");
                    String apellido_pa = resultados.getString("apellido_paterno");
                    String apellido_ma = resultados.getString("apellido_materno");
                    Date fecha_nacimiento = resultados.getDate("fecha_nacimiento");
                    String calle = resultados.getString("calle"); // Arreglado: era apellido_materno
                    String colonia = resultados.getString("colonia");
                    String cp = resultados.getString("cp");
                    String num_casa = resultados.getString("num_casa");
                    String correo = resultados.getString("correo");
                    String contrasenia = resultados.getString("contrasenia");
                    cliente = new Cliente(id_cliente, nombre, apellido_pa, apellido_ma, fecha_nacimiento, calle, colonia, num_casa, cp, correo, contrasenia);

                    logger.log(Level.INFO, "Se inició sesión de forma exitosa");
                } else {
                    logger.log(Level.SEVERE, "Correo o contraseña incorrectos");
                    throw new PersistenciaException("Correo o contraseña incorrectos");
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "No se pudo iniciar sesión", ex);
            throw new PersistenciaException("Error al iniciar sesión, verifique sus datos", ex);
        }
        return cliente;
    }

    /**
     * Método para obtener cliente por medio de su correo
     *
     * @param correo correo del cliente
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Cliente obtenerClienteCorreo(String correo) throws PersistenciaException {
        String sentenciaSQL = """
                              SELECT correo FROM clientes
                              WHERE correo = ?;
                              """;
        try (Connection conexion = this.conexionBD.obtenerConection(); PreparedStatement comando = conexion.prepareStatement(sentenciaSQL)) {

            comando.setString(1, correo);
            Cliente cliente = new Cliente();

            try (ResultSet resultados = comando.executeQuery()) {
                if (resultados.next()) {

                    String correoObtenido = resultados.getString("correo");
                    cliente = new Cliente(correoObtenido);
                    return cliente;

                }
            }

        } catch (SQLException ex) {

        }
        return null;
    }

}
