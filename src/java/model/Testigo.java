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
public class Testigo extends Persona implements Serializable, Jsonable  {
    private int idTestigo;
    

    public Testigo(){
        super();
    }

    public Testigo(int idTestigo, String identificacion, String nombre, String apellido1, String apellido2) {
        super(identificacion,nombre,apellido1,apellido2);
        this.idTestigo = idTestigo;
    }

    public int getIdTestigo() {
        return idTestigo;
    }

    public void setIdTestigo(int idTestigo) {
        this.idTestigo = idTestigo;
    }
}
