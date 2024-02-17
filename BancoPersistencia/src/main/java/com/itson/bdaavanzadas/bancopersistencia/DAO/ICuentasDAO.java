/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.DTO.CuentaActualizadaDTO;
import com.itson.bdaavanzadas.bancopersistencia.DTO.CuentaNuevaDTO;
import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import java.util.List;
import org.itson.bdavanzadas.bancodominio.Cliente;
import org.itson.bdavanzadas.bancodominio.Cuenta;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public interface ICuentasDAO {

    public Cuenta crearCuenta (CuentaNuevaDTO cuentaNueva,Cliente cliente, float monto) throws PersistenciaException;

    List<Cuenta> consultar() throws PersistenciaException;

    public void desactivarCuenta(int num_cuenta);

    public Cuenta actualizarCliente(CuentaActualizadaDTO cuentaActualizada) throws PersistenciaException;
}
