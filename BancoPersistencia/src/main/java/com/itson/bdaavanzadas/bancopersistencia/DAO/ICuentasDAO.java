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
    
    /**
     * Crea una cuenta nueva a un cliente
     *
     * @param cuentaNueva cuenta nueva
     * @param cliente cliente
     * @param monto monto
     * @return cuenta que se agrego
     * @throws PersistenciaException
     */
    public Cuenta crearCuenta (CuentaNuevaDTO cuentaNueva,Cliente cliente, float monto) throws PersistenciaException;
    
    /**
     * Regresa la lista de cuentas de un cliente
     *
     * @param cliente
     * @return Lista de cuentas
     * @throws PersistenciaException En caso de algúne error
     */
    List<Cuenta> consultar(Cliente cliente) throws PersistenciaException;
    
    /**
     * Método que actualiza el saldo de una cuenta usando el numero de la misma y
     * y un monto definido en sus párametros.
     * 
     * @param num_cuenta número de cuenta.
     * @param monto monto a agregar.
     */
    public void actualizarMonto(Long num_cuenta, float monto);
    
    /**
     * Obtiene el nombre del cliente de una cuenta
     *
     * @param cuenta cuenta
     * @return nombre del cliente
     * @throws PersistenciaException en caso de error
     */
    public String obtenerNombreCuenta (Cuenta cuenta) throws PersistenciaException;
    
    /**
     * Método el cual desactiva o activa la cuenta de un usuario cambiando su
     * estado
     * @param cuenta cuenta que se desactiavara o activara
     * @throws PersistenciaException
     */
    public void activacionCuenta(Cuenta cuenta) throws PersistenciaException;
}
