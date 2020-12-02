/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Fabrica {

    // Atributos
    private String turno;
    private ArrayList<Producto> producido ;
    private MateriaPrima disponibilidad;
    
    //Constructores

    public Fabrica() {
    }

    public Fabrica(String turno, ArrayList<Producto> producido) {
        this.turno = turno;
        this.producido = producido;
        this.disponibilidad = disponibilidad;
    }
    
    
    //Getters

    public String getTurno() {
        return turno;
    }

    public ArrayList<Producto> getProducido() {
        return producido;
    }
    
    //Setters

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setProducido(ArrayList<Producto> producido) {
        this.producido = producido;
    }

    public MateriaPrima getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(MateriaPrima disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
    
}
