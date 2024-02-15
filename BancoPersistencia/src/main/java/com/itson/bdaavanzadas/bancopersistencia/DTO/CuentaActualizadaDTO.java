/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdaavanzadas.bancopersistencia.DTO;

import com.itson.bdaavanzadas.bancopersistencia.excepciones.ValidacionDTOException;
import java.util.GregorianCalendar;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class CuentaActualizadaDTO {

    private int num_cuenta;//número de cuenta.
    private float saldo;//saldo de la cuenta.
    private GregorianCalendar fecha_apertura;//fecha apertura de la cuenta.
    private byte estado;//Estado de la cuenta.
    private int id_cliente;//id cliente asociado con la cuenta.

    public int getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(int num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public GregorianCalendar getFecha_apertura() {
        return fecha_apertura;
    }

    public void setFecha_apertura(GregorianCalendar fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public boolean esValido() throws ValidacionDTOException {
        if ((Integer)this.num_cuenta == null) {
            throw new ValidacionDTOException("Número de cuenta invalido");
        }
        if (this.saldo < 0
                || (Float) this.saldo == null) {
            throw new ValidacionDTOException("Saldo invalido, saldo negativo");
        }
        if (this.fecha_apertura == null) {
            throw new ValidacionDTOException("Error en fecha, fecha vacia");
        }
        if (this.estado == 0) {
            throw new ValidacionDTOException("Cuenta desactivada");
        }
        if ((Integer) this.id_cliente == null) {
            throw new ValidacionDTOException("ID de cliente vacio");
        }
        return true;
    }
}
