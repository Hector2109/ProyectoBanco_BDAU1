package org.itson.bdavanzadas.bancodominio;

import java.util.Date;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class Cuenta {

    private Long num_cuenta;//número de cuenta.
    private float saldo;//saldo de la cuenta.
    private Date fecha_apertura;//fecha apertura de la cuenta.
    private byte estado;//Estado de la cuenta.
    private Long id_cliente;//id cliente asociado con la cuenta.

    /**
     * Constructor para crear un objeto cuenta.
     *
     * @param num_cuenta número de cuenta.
     * @param saldo saldo de la cuenta.
     * @param fecha_apertura fecha apertura de la cuenta.
     * @param estado Estado de la cuenta.
     * @param id_cliente id cliente asociado con la cuenta.
     */
    public Cuenta(Long num_cuenta, float saldo, Date fecha_apertura, byte estado, Long id_cliente) {
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
        this.fecha_apertura = fecha_apertura;
        this.estado = estado;
        this.id_cliente = id_cliente;
    }

    public Cuenta(Long num_cuenta, float saldo, byte estado) {
        this.num_cuenta = num_cuenta;
        this.saldo = saldo;
        this.estado = estado;
    }
    
    
    public Cuenta(Long num_cuenta) {
        this.num_cuenta = num_cuenta;
    }
    
    

    /**
     * Método para obtener el número de cuenta.
     * @return número de cuenta.
     */
    public Long getNum_cuenta() {
        return num_cuenta;
    }

    /**
     * Método para establecer el número de cuenta.
     */
    public void setNum_cuenta(Long num_cuenta) {
        this.num_cuenta = num_cuenta;
    }
    
    /**
     * Método para obtener el saldo de cuenta.
     * @return saldo de cuenta.
     */
    public float getSaldo() {
        return saldo;
    }
    
    /**
     * Método para establecer el saldo de cuenta.
     * @param saldo saldo de cuenta.
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    /**
     * Método para obtener la fecha de apertura de la cuenta.
     * @return fecha de apertura de la cuenta.
     */
    public Date getFecha_apertura() {
        return fecha_apertura;
    }
    
    /**
     * Método para establecer la fecha de apertura de la cuenta.
     * @param fecha_apertura fecha de apertura de la cuenta
     */
    public void setFecha_apertura(Date fecha_apertura) {
        this.fecha_apertura = fecha_apertura;
    }
    
    /**
     * Método para obtener el estado de cuenta.
     * @return estado de cuenta.
     */
    public byte getEstado() {
        return estado;
    }
    
    /**
     * Método para establecer el saldo de cuenta.
     * @param estado estado de cuenta.
     */
    public void setEstado(byte estado) {
        this.estado = estado;
    }
    
    /**
     * Método para obtener el id cliente asociado a la cuenta.
     * @return id cliente asociado a la cuenta.
     */
    public Long getId_cliente() {
        return id_cliente;
    }
    
    /**
     * Método para establecer el id cliente asociado a la cuenta.
     * @param id_cliente id cliente asociado a la cuenta.
     */
    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    /**
     * Método to String que devuelve una cadena ordenada con los valores de los 
     * datos de la clase.
     * @return cadena de texto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("num_cuenta=").append(num_cuenta);
        sb.append(", saldo=").append(saldo);
        sb.append(", fecha_apertura=").append(fecha_apertura);
        sb.append(", estado=").append(estado);
        sb.append(", id_cliente=").append(id_cliente);
        sb.append('}');
        return sb.toString();
    }

}
