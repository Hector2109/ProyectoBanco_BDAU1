
package com.itson.bdaavanzadas.bancopersistencia.DTO;

import com.itson.bdaavanzadas.bancopersistencia.excepciones.ValidacionDTOException;
import java.util.GregorianCalendar;

/**
 * DTO para representar la creación de una nueva cuenta en el banco.
 * Contiene los datos básicos de la cuenta y métodos para validar la información.
 * 
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class CuentaNuevaDTO {
    
    private float saldo; // Saldo de la cuenta
    private GregorianCalendar fecha_apertura; // Fecha de apertura de la cuenta
    private byte estado; // Estado de la cuenta
    private int id_cliente; // ID del cliente asociado con la cuenta

    /**
     * Obtiene el saldo de la cuenta.
     * 
     * @return Saldo de la cuenta
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * Modifica el saldo de la cuenta.
     * 
     * @param saldo Saldo de la cuenta
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene la fecha de apertura de la cuenta.
     * 
     * @return Fecha de apertura de la cuenta
     */
    public GregorianCalendar getFecha_apertura() {
        return fecha_apertura;
    }

    /**
     * Modifica la fecha de apertura de la cuenta.
     * 
     * @param fecha_apertura Fecha de apertura de la cuenta
     */
    public void setFecha_apertura(GregorianCalendar fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }

    /**
     * Obtiene el estado de la cuenta.
     * 
     * @return Estado de la cuenta
     */
    public byte getEstado() {
        return estado;
    }

    /**
     * Modifica el estado de la cuenta.
     * 
     * @param estado Estado de la cuenta
     */
    public void setEstado(byte estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el ID del cliente asociado con la cuenta.
     * 
     * @return ID del cliente asociado con la cuenta
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Modifica el ID del cliente asociado con la cuenta.
     * 
     * @param id_cliente ID del cliente asociado con la cuenta
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    /**
     * Verifica si los datos de la cuenta son válidos.
     * Lanza una excepción si algún dato es inválido.
     * 
     * @return true si los datos son válidos, false en caso contrario
     * @throws ValidacionDTOException si algún dato es inválido
     */
    public boolean esValido() throws ValidacionDTOException {
        if (this.saldo < 0) {
            throw new ValidacionDTOException("Saldo inválido, saldo negativo");
        }
        if (this.fecha_apertura == null) {
            throw new ValidacionDTOException("Fecha de apertura inválida, fecha vacía");
        }
        if (this.estado == 0) {
            throw new ValidacionDTOException("Cuenta desactivada");
        }
        if (this.id_cliente <= 0) {
            throw new ValidacionDTOException("ID de cliente inválido");
        }
        return true;
    }
}
