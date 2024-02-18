/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import org.itson.bdavanzadas.bancodominio.Transferencia;

/**
 *
 * @author Enrique Rodriguez
 */
public interface ITransferenciasDAO {
    public void transferir(float saldo, Long cuenta_destino, Long cuenta_receptora) throws PersistenciaException;
    
}
