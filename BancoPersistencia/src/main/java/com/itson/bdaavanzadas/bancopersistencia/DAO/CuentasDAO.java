/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.conexion.IConexion;
import java.util.logging.Logger;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class CuentasDAO {
    
    final IConexion conexionBD;
    static final Logger logger = Logger.getLogger(CuentasDAO.class.getName());
    
    public CuentasDAO(IConexion conexion) {
        this.conexionBD = conexion;
    }
}
