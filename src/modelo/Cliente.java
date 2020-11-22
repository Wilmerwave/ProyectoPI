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
    private Point ubicacion;
    private String telefono;
    
    
    //CONSTRUCTOR
    public Cliente(String id, String nombre, int x, int y, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = new Point(x,y);
        this.telefono = telefono;
    }
    
    
    //GETTERS
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Point getUbicacion() {
        return ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }
    
    
    //SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(Point ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}
