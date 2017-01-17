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
public class Lugar implements Serializable, Jsonable{
    private Distrito distrito;
    private String direccionExacta;

    public Lugar() {
    }

    public Lugar(Distrito distrito, String direccionExacta) {
        this.distrito = distrito;
        this.direccionExacta = direccionExacta;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public String getDireccionExacta() {
        return direccionExacta;
    }

    public void setDireccionExacta(String direccionExacta) {
        this.direccionExacta = direccionExacta;
    }
    
    
}
