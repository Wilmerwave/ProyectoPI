/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lenovo
 */
public class Proveedor {
    private String ID;
    private String nombre;
    private String id_MateriaPrima;
    private double precio;

    public Proveedor() {
    }

    public Proveedor(String ID, String nombre, String id_MateriaPrima, double precio) {
        this.ID = ID;
        this.nombre = nombre;
        this.id_MateriaPrima = id_MateriaPrima;
        this.precio = precio;
    }
//Getters
    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId_MateriaPrima() {
        return id_MateriaPrima;
    }

    public double getPrecio() {
        return precio;
    }
    
    //Setters

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId_MateriaPrima(String id_MateriaPrima) {
        this.id_MateriaPrima = id_MateriaPrima;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
