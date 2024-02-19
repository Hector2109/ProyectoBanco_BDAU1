/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.util.List;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Transaccion;

/**
 *
 * @author Enrique Rodriguez
 */
public interface ITransaccionDAO {
    List<Transaccion> consultar(Cliente cliente) throws PersistenciaException;
}