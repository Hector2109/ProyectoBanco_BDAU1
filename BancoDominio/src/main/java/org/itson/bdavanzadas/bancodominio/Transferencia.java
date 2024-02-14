package org.itson.bdavanzadas.bancodominio;

import java.util.GregorianCalendar;

/**
 * Esta clase representa una transferencia en el sistema bancario.
 * Una transferencia contiene información sobre el ID de la transferencia,
 * el ID de la transacción asociada y el número de cuenta a la que se está
 * transfiriendo el dinero.
 * 
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class Transferencia extends Transaccion{
    
    private int id_transferencia; // ID de la transferencia.
    private int id_transaccion; // ID de la transacción asociada.
    private int num_cuenta_transferir; // Número de cuenta a transferir el dinero.

    /**
     * Constructor para crear un objeto transferencia.
     * 
     * @param id_transferencia el ID de la transferencia.
     * @param id_transaccion el ID de la transacción asociada.
     * @param num_cuenta_transferir el número de cuenta a la que se está transfiriendo el dinero.
     * @param saldo_transaccion monto a transferir.
     * @param fecha fecha de la transferencia.
     * @param num_cuenta numero de cuenta del que se transfiere.
     */
    public Transferencia(int id_transferencia, int num_cuenta_transferir, int id_transaccion, float saldo_transaccion, GregorianCalendar fecha, int num_cuenta) {
        super(id_transaccion, saldo_transaccion, fecha, num_cuenta);
        this.id_transferencia = id_transferencia;
        this.num_cuenta_transferir = num_cuenta_transferir;
    }
    
    /**
     * Método para obtener el ID de la transferencia.
     * @return el ID de la transferencia.
     */
    public int getId_transferencia() {
        return id_transferencia;
    }

    /**
     * Método para establecer el ID de la transferencia.
     * @param id_transferencia el ID de la transferencia.
     */
    public void setId_transferencia(int id_transferencia) {
        this.id_transferencia = id_transferencia;
    }

    /**
     * Método para obtener el ID de la transacción asociada a la transferencia.
     * @return el ID de la transacción asociada.
     */
    public int getId_transaccion() {
        return id_transaccion;
    }

    /**
     * Método para establecer el ID de la transacción asociada a la transferencia.
     * @param id_transaccion el ID de la transacción asociada.
     */
    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    /**
     * Método para obtener el número de cuenta a la que se está transfiriendo el dinero.
     * @return el número de cuenta a transferir el dinero.
     */
    public int getNum_cuenta_transferir() {
        return num_cuenta_transferir;
    }

    /**
     * Método para establecer el número de cuenta a la que se está transfiriendo el dinero.
     * @param num_cuenta_transferir el número de cuenta a transferir el dinero.
     */
    public void setNum_cuenta_transferir(int num_cuenta_transferir) {
        this.num_cuenta_transferir = num_cuenta_transferir;
    }

    /**
     * Método toString que devuelve una cadena ordenada con los valores de los
     * datos de la clase.
     * @return Cadena de texto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transferencia{");
        sb.append("id_transferencia=").append(id_transferencia);
        sb.append(", id_transaccion=").append(id_transaccion);
        sb.append(", num_cuenta_transferir=").append(num_cuenta_transferir);
        sb.append('}');
        return sb.toString();
    }
    
}
