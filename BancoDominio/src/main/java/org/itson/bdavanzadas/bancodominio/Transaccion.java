package org.itson.bdavanzadas.bancodominio;

import java.util.Date;


/**
 * Esta clase representa una transacción en el sistema bancario.
 * Una transacción contiene información sobre el ID de la transacción,
 * el saldo de la transacción, la fecha de la transacción y el número
 * de cuenta asociado a la transacción.
 * 
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class Transaccion {
    
    private Long id_transaccion; // ID de la transacción.
    private float saldo_transaccion; // Saldo de la transacción.
    private Date fecha; // Fecha de la transacción.
    private Long num_cuenta; // Número de cuenta asociado a la transacción.

    /**
     * Constructor para crear un objeto transacción.
     * 
     * @param id_transaccion el ID de la transacción.
     * @param saldo_transaccion el saldo de la transacción.
     * @param fecha la fecha de la transacción.
     * @param num_cuenta el número de cuenta asociado a la transacción.
     */
    public Transaccion(Long id_transaccion, float saldo_transaccion, Date fecha, Long num_cuenta) {
        this.id_transaccion = id_transaccion;
        this.saldo_transaccion = saldo_transaccion;
        this.fecha = fecha;
        this.num_cuenta = num_cuenta;
    }

    /**
     * Constructor vacio
     */
    public Transaccion() {
    }
    
    
    
    /**
     * Método para obtener el ID de la transacción.
     * @return el ID de la transacción.
     */
    public Long getId_transaccion() {
        return id_transaccion;
    }

    /**
     * Método para establecer el ID de la transacción.
     * @param id_transaccion el ID de la transacción.
     */
    public void setId_transaccion(Long id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    /**
     * Método para obtener el saldo de la transacción.
     * @return el saldo de la transacción.
     */
    public float getSaldo_transaccion() {
        return saldo_transaccion;
    }

    /**
     * Método para establecer el saldo de la transacción.
     * @param saldo_transaccion el saldo de la transacción.
     */
    public void setSaldo_transaccion(float saldo_transaccion) {
        this.saldo_transaccion = saldo_transaccion;
    }

    /**
     * Método para obtener la fecha de la transacción.
     * @return la fecha de la transacción.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Método para establecer la fecha de la transacción.
     * @param fecha la fecha de la transacción.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Método para obtener el número de cuenta asociado a la transacción.
     * @return el número de cuenta asociado a la transacción.
     */
    public Long getNum_cuenta() {
        return num_cuenta;
    }

    /**
     * Método para establecer el número de cuenta asociado a la transacción.
     * @param num_cuenta el número de cuenta asociado a la transacción.
     */
    public void setNum_cuenta(Long num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    /**
     * Método toString que devuelve una cadena ordenada con los valores de los
     * datos de la clase.
     * @return Cadena de texto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaccion{");
        sb.append("id_transaccion=").append(id_transaccion);
        sb.append(", saldo_transaccion=").append(saldo_transaccion);
        sb.append(", fecha=").append(fecha);
        sb.append(", num_cuenta=").append(num_cuenta);
        sb.append('}');
        return sb.toString();
    }
    
}
