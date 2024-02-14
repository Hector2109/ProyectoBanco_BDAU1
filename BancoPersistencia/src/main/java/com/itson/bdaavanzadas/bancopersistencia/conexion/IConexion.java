package com.itson.bdaavanzadas.bancopersistencia.conexion;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public interface IConexion {
    
    Connection obtenerConection () throws SQLException;
}
