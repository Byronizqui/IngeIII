/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Marco
 */
public class Interesado extends Persona implements Serializable, Jsonable{
    private int idInteresado;
    private Date fechaNacimiento;
    private Lugar domicilio;

    public Interesado() {
        super();
    }

    public Interesado(int idInteresado, Date fechaNacimiento, Lugar domicilio, String identificacion, String nombre, String apellido1, String apellido2) {
        super(identificacion, nombre, apellido1, apellido2);
        this.idInteresado = idInteresado;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
    }

    public int getIdInteresado() {
        return idInteresado;
    }

    public void setIdInteresado(int idInteresado) {
        this.idInteresado = idInteresado;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Lugar getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Lugar domicilio) {
        this.domicilio = domicilio;
    }
    
    
}
