/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Marco
 */
public class Policia extends Persona implements Serializable, Jsonable{
    private int idPolicia;

    public Policia() {
    }

    public Policia(int idPolicia, String identificacion, String nombre, String apellido1, String apellido2) {
        super(identificacion,nombre,apellido1,apellido2);
        this.idPolicia = idPolicia;
    }

    public int getIdPolicia() {
        return idPolicia;
    }

    public void setIdPolicia(int idPolicia) {
        this.idPolicia = idPolicia;
    }
    
}
