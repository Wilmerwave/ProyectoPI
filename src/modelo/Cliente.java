package modelo;

import java.awt.Point;

/**
 *
 * @author Camila
 */
public class Cliente {
    
    //ATRIBUTOS
    private String id;
    private String nombre;
    private String telefono;
    private Point ubicacion;
    
    
    //CONSTRUCTOR
    public Cliente(){}
    
    public Cliente(String id, String nombre, String telefono, Point ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
    }
   
    
    //GETTERS
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public Point getUbicacion() {
        return ubicacion;
    }
    
    
    //SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public void setUbicacion(Point ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    
}
