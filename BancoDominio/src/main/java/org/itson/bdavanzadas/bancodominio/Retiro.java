package org.itson.bdavanzadas.bancodominio;

import java.util.Date;

/**
 * Esta clase representa un retiro en el sistema bancario.
 * Un retiro está asociado a una transacción y contiene información sobre el folio,
 * contraseña, estado y la ID de la transacción asociada.
 * 
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class Retiro extends Transaccion{
    
    private Long folio; // Folio del retiro.
    private String contrasenia; // Contraseña del retiro.
    private byte estado; // Estado del retiro.
    private Long id_transaccion; // ID de la transacción asociada al retiro.

    /**
     * Constructor para crear un objeto retiro.
     * 
     * @param folio el folio del retiro.
     * @param contrasenia la contraseña del retiro.
     * @param estado el estado del retiro.
     * @param id_transaccion la ID de la transacción asociada al retiro.
     * @param saldo_transaccion monto a retirar.
     * @param fecha fecha del retiro.
     * @param num_cuenta numero de cuenta del que se retira.
     */
    public Retiro(Long folio, String contrasenia, byte estado, Long id_transaccion, float saldo_transaccion, Date fecha, Long num_cuenta) {
        super(id_transaccion, saldo_transaccion, fecha, num_cuenta);
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    /**
     * Constructor vacio
     */
    public Retiro() {

    }
    
    

    /**
     * Método para obtener el folio del retiro.
     * @return el folio del retiro.
     */
    public Long getFolio() {
        return folio;
    }

    /**
     * Método para establecer el folio del retiro.
     * @param folio el folio del retiro.
     */
    public void setFolio(Long folio) {
        this.folio = folio;
    }

    /**
     * Método para obtener la contraseña del retiro.
     * @return la contraseña del retiro.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Método para establecer la contraseña del retiro.
     * @param contrasenia la contraseña del retiro.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Método para obtener el estado del retiro.
     * @return el estado del retiro.
     */
    public byte getEstado() {
        return estado;
    }

    /**
     * Método para establecer el estado del retiro.
     * @param estado el estado del retiro.
     */
    public void setEstado(byte estado) {
        this.estado = estado;
    }

    /**
     * Método toString que devuelve una cadena ordenada con los valores de los
     * datos de la clase.
     * @return Cadena de texto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Retiro{");
        sb.append("folio=").append(folio);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append(", estado=").append(estado);
        sb.append(", id_transaccion=").append(id_transaccion);
        sb.append('}');
        return sb.toString();
    }
    
}
