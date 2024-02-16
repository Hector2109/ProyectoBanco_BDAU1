package com.itson.bdaavanzadas.bancopersistencia.DTO;

import com.itson.bdaavanzadas.bancopersistencia.excepciones.ValidacionDTOException;
import java.util.Date;

/**
 *
 * @author Hector Espinoza y Enrique Rodriguz
 */
public class ClienteActualizadoDTO {
    
    private Long id;//ID del cliente
    private String nombre; //Nombre del cliente del banco
    private String apellido_pa; //Apellido Paterno del cliente del banco
    private String apellido_ma; //Apellido Materno del cliente del banco
    private Date fecha_nacimiento;//Fecha de nacimiento 
    private String calle; //Calle del cliente
    private String colonia; //Colonia del cliente
    private String numero_casa; //Número de casa del cliente
    private String cp; //código postal del cliente
    private String contrasenia; //código postal del cliente

    /**
     * Obtiene el ID cliente 
     * @return id del cliente
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica el id del cliente
     * @param id id del cliente
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene nombre del cliente
     * @return obtiene nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del cliente
     * @param nombre nombre del cliente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente
     * @return apellido del cliente
     */
    public String getApellido_pa() {
        return apellido_pa;
    }

    /**
     * Modifica el apellido paterno del clinte
     * @param apellido_pa apellido del cliente
     */
    public void setApellido_pa(String apellido_pa) {
        this.apellido_pa = apellido_pa;
    }

    /**
     * Obtiene el apellido materno del cliente
     * @return apellido materno
     */
    public String getApellido_ma() {
        return apellido_ma;
    }

    /**
     * Modifica el apellido materno del clinte
     * @param apellido_ma apellido materno
     */
    public void setApellido_ma(String apellido_ma) {
        this.apellido_ma = apellido_ma;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente
     * @return fecha de nacimiento
     */
    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Modifica la fecha de nacimiento del cliente
     * @param fecha_nacimiento 
     */
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    
    
    /**
     * Obtiene la call del cliente
     * @return calle del cliente
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Modifica la calle del cliente
     * @param calle calle del cliente
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene la colonia del cliente
     * @return colonia del cliente
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Modifica la colonia
     * @param colonia 
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Obtiene el número de casa del cliente
     * @return número de casa del cliente
     */
    public String getNumero_casa() {
        return numero_casa;
    }

    /**
     * Modifica el número de casa del cliente
     * @param numero_casa número de casa del cliente
     */
    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }

    /**
     * Obtiene el código postal del cliente
     * @return código postal del cliente
     */
    public String getCp() {
        return cp;
    }

    /**
     * Modifica el código postal del cliente
     * @param cp 
     */
    public void setCp(String cp) {
        this.cp = cp;
    }
    
    
    public boolean esValido ()throws ValidacionDTOException{
        
        if (this.nombre == null || 
                this.nombre.isBlank() || 
                this.nombre.length() > 50){
            throw new ValidacionDTOException("Nombre del cliente inválido");
        }
        if (this.apellido_pa == null || 
                this.apellido_pa.isBlank() || 
                this.apellido_pa.length() > 25){
            throw new ValidacionDTOException("Apellido paterno del cliente inválido");
        }
        if (this.calle == null || 
                this.calle.isBlank() || 
                this.calle.length() > 45){
            throw new ValidacionDTOException("Calle del cliente inválido");
        }
        if (this.numero_casa == null || 
                this.numero_casa.isBlank() || 
                this.numero_casa.length() > 5){
            throw new ValidacionDTOException("Calle del cliente inválido");
        }
        if (this.colonia == null || 
                this.colonia.isBlank() || 
                this.colonia.length() > 45){
            throw new ValidacionDTOException("Colonia del cliente inválido");
        }
        if (this.cp == null || 
                this.cp.isBlank() || 
                this.cp.length() > 5){
            throw new ValidacionDTOException("Calle del cliente inválido");
        }
        if (this.contrasenia == null || 
                this.contrasenia.isBlank() || 
                this.contrasenia.length() > 50){
            throw new ValidacionDTOException("Calle del cliente inválido");
        }
        if (this.fecha_nacimiento == null){
            throw new ValidacionDTOException("Fecha no valida del cliente inválido");
        }
        return true;
    }
    
}
