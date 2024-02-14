package org.itson.bdavanzadas.bancodominio;

/**
 * Esta clase representa un retiro en el sistema bancario.
 * Un retiro está asociado a una transacción y contiene información sobre el folio,
 * contraseña, estado y la ID de la transacción asociada.
 * 
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class Retiro {
    
    private int folio; // Folio del retiro.
    private String contrasenia; // Contraseña del retiro.
    private byte estado; // Estado del retiro.
    private int id_transaccion; // ID de la transacción asociada al retiro.

    /**
     * Constructor para crear un objeto retiro.
     * 
     * @param folio el folio del retiro.
     * @param contrasenia la contraseña del retiro.
     * @param estado el estado del retiro.
     * @param id_transaccion la ID de la transacción asociada al retiro.
     */
    public Retiro(int folio, String contrasenia, byte estado, int id_transaccion) {
        this.folio = folio;
        this.contrasenia = contrasenia;
        this.estado = estado;
        this.id_transaccion = id_transaccion;
    }

    /**
     * Método para obtener el folio del retiro.
     * @return el folio del retiro.
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Método para establecer el folio del retiro.
     * @param folio el folio del retiro.
     */
    public void setFolio(int folio) {
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
     * Método para obtener la ID de la transacción asociada al retiro.
     * @return la ID de la transacción asociada al retiro.
     */
    public int getId_transaccion() {
        return id_transaccion;
    }

    /**
     * Método para establecer la ID de la transacción asociada al retiro.
     * @param id_transaccion la ID de la transacción asociada al retiro.
     */
    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
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
