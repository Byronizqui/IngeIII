/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marco
 */
public class ActaDecomiso implements Serializable,Jsonable{
    private int idDecomiso;
    private Policia policia;
    private Testigo testigo;
    private Lugar lugar;
    private Date fecha;
    private String hora;
    private Interesado interesado;
    private List<Decomiso> decomisos;
    private String observaciones;

    public ActaDecomiso() {
    }

    public ActaDecomiso(int idDecomiso, Policia policia, Testigo testigo, Lugar lugar, Date fecha, String hora, Interesado interesado, List<Decomiso> decomisos, String observaciones) {
        this.idDecomiso = idDecomiso;
        this.policia = policia;
        this.testigo = testigo;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.interesado = interesado;
        this.decomisos = decomisos;
        this.observaciones = observaciones;
    }

    public int getIdDecomiso() {
        return idDecomiso;
    }

    public void setIdDecomiso(int idDecomiso) {
        this.idDecomiso = idDecomiso;
    }

    public Policia getPolicia() {
        return policia;
    }

    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    public Testigo getTestigo() {
        return testigo;
    }

    public void setTestigo(Testigo testigo) {
        this.testigo = testigo;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public void setInteresado(Interesado interesado) {
        this.interesado = interesado;
    }

    public List<Decomiso> getDecomisos() {
        return decomisos;
    }

    public void setDecomisos(List<Decomiso> decomisos) {
        this.decomisos = decomisos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
}
