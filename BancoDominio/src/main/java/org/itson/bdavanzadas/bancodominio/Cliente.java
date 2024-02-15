package org.itson.bdavanzadas.bancodominio;

import java.util.GregorianCalendar;

/**
 * 
 * @author Hector Espinoza y Enrique Rodriguez
 */
public class Cliente {
    
    private Long id_cliente; //id del cliente del Banco
    private String nombre; //Nombre del cliente del banco
    private String apellido_pa; //Apellido Paterno del cliente del banco
    private String apellido_ma; //Apellido Materno del cliente del banco
    private GregorianCalendar fecha_nacimiento;//Fecha de nacimiento 
    private String calle; //Calle del cliente
    private String colonia; //Colonia del cliente
    private String numero_casa; //Número de casa del cliente
    private String cp; //código postal del cliente
    private String contrasenia; //Contraseña del cliente

    /**
     * Constructor para crear un objeto Cliente
     * @param id_cliente id del cliente
     * @param nombre nombre del cliente
     * @param apellido_pa apellido paterno del cliente
     * @param apellido_ma apellido materno del cliente
     * @param calle calle del cliente
     * @param colonia colonia del cliente
     * @param numero_casa numero de cas del cliente
     * @param cp código postal del cliente
     */
    public Cliente(Long id_cliente, String nombre, String apellido_pa, String apellido_ma, String calle, String colonia, String numero_casa, String cp, String contrasenia) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido_pa = apellido_pa;
        this.apellido_ma = apellido_ma;
        this.calle = calle;
        this.colonia = colonia;
        this.numero_casa = numero_casa;
        this.cp = cp;
        this.contrasenia = contrasenia;
    }

    /**
     * Este constructor se utiliza para los objetos clientes los cuales se requeiren consultarm, de esta forma se muestra
     * el nombre completo en un campo y la contraseña no es guardada ni mostrada
     * @param id_cliente id del cliente
     * @param nombre nombre del cliente
     * @param calle calle del cliente
     * @param colonia colonia del cliente
     * @param numero_casa numero de casa
     * @param cp código postal del cliente
     */
    public Cliente(Long id_cliente, String nombre, String calle, String colonia, String numero_casa, String cp) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.calle = calle;
        this.colonia = colonia;
        this.numero_casa = numero_casa;
        this.cp = cp;
    }

    public Cliente(Long id_cliente, String nombre, String apellido_pa, String apellido_ma, GregorianCalendar fecha_nacimiento, String calle, String colonia, String numero_casa, String cp) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido_pa = apellido_pa;
        this.apellido_ma = apellido_ma;
        this.fecha_nacimiento = fecha_nacimiento;
        this.calle = calle;
        this.colonia = colonia;
        this.numero_casa = numero_casa;
        this.cp = cp;
    }
    
    
    
    
    /**
     * Obtiene la id del cliente
     * @return id del cliente
     */
    public Long getId_cliente() {
        return id_cliente;
    }

    /**
     * Modifica la id del cliente
     * @param id_cliente id del cliente
     */
    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
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
    public GregorianCalendar getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Modifica la fecha de nacimiento del cliente
     * @param fecha_nacimiento 
     */
    public void setFecha_nacimiento(GregorianCalendar fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    /**
    * Regresa todos los atributos del cliente
    * @return Cliente
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("id_cliente=").append(id_cliente);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido_pa=").append(apellido_pa);
        sb.append(", apellido_ma=").append(apellido_ma);
        sb.append(", fecha_nacimiento=").append(fecha_nacimiento);
        sb.append(", calle=").append(calle);
        sb.append(", colonia=").append(colonia);
        sb.append(", numero_casa=").append(numero_casa);
        sb.append(", cp=").append(cp);
        sb.append('}');
        return sb.toString();
    }


}
