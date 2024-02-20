/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.bdaavanzadas.bancopersistencia.DAO;

import com.itson.bdaavanzadas.bancopersistencia.excepciones.PersistenciaException;
import org.itson.bdavanzadas.bancodominio.Transferencia;

/**
 *
 * @author Enrique Rodriguez y Hector Espinoza
 */
public interface ITransferenciasDAO {

    /**
     * Este método funciona como una transferencia, se conecta a la base de
     * datos y transfiere una cantidad de una cuenta a otra.
     *
     * @param saldo saldo a transferir.
     * @param cuenta_destino cuenta receptora.
     * @param cuenta_receptora cuenta destino.
     */
    public void transferir(float saldo, Long cuenta_destino, Long cuenta_receptora) throws PersistenciaException;

}
