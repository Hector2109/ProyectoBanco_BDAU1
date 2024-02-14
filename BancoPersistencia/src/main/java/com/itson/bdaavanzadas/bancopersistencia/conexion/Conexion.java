package com.itson.bdaavanzadas.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class Conexion implements IConexion{
    final String cadenaConexion; //base de datos a la cual se realizará la conexión
    final String usuario; //Usuario de acceso para la BD
    final String contrasenia; //contraseña para acceder a la BD
    static final Logger logger = Logger.getLogger(Conexion.class.getName());

    /**
     * Constructor el cual recibe la BD a la que se quiere conectar,
     * el usuario y contraseña
     * @param cadenaConexion
     * @param usuario
     * @param contrasenia 
     */
    public Conexion(String cadenaConexion, String usuario, String contrasenia) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    /**
     * Regresa una conexión si esta se estableció
     * @return conexion
     * @throws SQLException en caso de no esablecer una conexión 
     */
    @Override
    public Connection obtenerConection() throws SQLException {
        Connection conexion = DriverManager.getConnection(cadenaConexion,
                        usuario,
                        contrasenia);
        logger.log(Level.INFO, "Conexión establecida {0}", cadenaConexion);
        return conexion;
    }
}
