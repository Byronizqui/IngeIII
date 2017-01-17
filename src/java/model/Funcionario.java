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
public class Funcionario extends Persona implements Serializable, Jsonable{
    private int idFuncionario;
    private String puesto;

    public Funcionario() {
    }

    public Funcionario(int idFuncionario,String puesto, String identificacion, String nombre, String apellido1, String apellido2) {
        super(identificacion, nombre, apellido1, apellido2);
        this.idFuncionario = idFuncionario;
        this.puesto=puesto;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    
    
}
