/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author federicobarbetti
 */
public class InventarioProductoTerminado {
    
    private Fabrica ingresoProductos; // Objeto Fabrica por agregacion
    private Venta venta; // Objeto Venta por agregacion
    private int cantidadMediasDocenas; // Presentacion del producto por mediasdocenas
    private int cantidadDocenas; // Presentacion del producto por docenas
    
    //CONSTRUCTORES

    public InventarioProductoTerminado(Fabrica ingresoProductos, Venta venta, int cantidadMediasDocenas, int cantidadDocenas) {
        this.ingresoProductos = ingresoProductos;
        this.venta = venta;
        this.cantidadMediasDocenas = cantidadMediasDocenas;
        this.cantidadDocenas = cantidadDocenas;
    }
    
    public InventarioProductoTerminado() {
        cantidadMediasDocenas = 0;
        cantidadDocenas = 0;
    }
    
    // GETTERS / SETTERS

    public Fabrica getIngresoProductos() {
        return ingresoProductos;
    }

    public void setIngresoProductos(Fabrica ingresoProductos) {
        this.ingresoProductos = ingresoProductos;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCantidadMediasDocenas() {
        return cantidadMediasDocenas;
    }

    public void setCantidadMediasDocenas(int cantidadMediasDocenas) {
        this.cantidadMediasDocenas = cantidadMediasDocenas;
    }

    public int getCantidadDocenas() {
        return cantidadDocenas;
    }

    public void setCantidadDocenas(int cantidadDocenas) {
        this.cantidadDocenas = cantidadDocenas;
    }
    
    
    
    
    
    
}
