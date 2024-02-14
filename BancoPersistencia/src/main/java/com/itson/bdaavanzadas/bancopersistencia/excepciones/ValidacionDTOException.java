package com.itson.bdaavanzadas.bancopersistencia.excepciones;

/**
 *
 * @author Hector Espinoza
 */
public class ValidacionDTOException extends Exception{
    
    public ValidacionDTOException() {
    }

    public ValidacionDTOException(String message) {
        super(message);
    }

    public ValidacionDTOException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidacionDTOException(Throwable cause) {
        super(cause);
    }

    public ValidacionDTOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
