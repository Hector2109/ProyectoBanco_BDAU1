package com.itson.bdaavanzadas.bancopersistencia.excepciones;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class PersistenciaException extends Exception{
    
    /**
     * Constrictor que contiene el mensaje de la exepción
     * @param message mensaje de excpecion 
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor el cual contiene el mensaje u un objeto tipo Throwable
     * @param message mensaje
     * @param cause causa del eror
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructir con un objeto Throwable de la causa de la exepción
     * @param cause causa
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * 
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace 
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
