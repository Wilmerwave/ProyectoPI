/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Wil
 */
public class VentaxProducto {
    private String fecha;
    private String idProducto;
    private float presentacion; //docena o media docena
    private float valor;
    private int cantidad;
    private String idVendedor;

    public VentaxProducto(String fecha, String idProducto, float presentacion, float valor, int cantidad, String idVendedor) {
        this.fecha = fecha;
        this.idProducto = idProducto;
        this.presentacion = presentacion;
        this.valor = valor;
        this.cantidad = cantidad;
        this.idVendedor = idVendedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public float getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(float presentacion) {
        this.presentacion = presentacion;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    
    
    
    
}
