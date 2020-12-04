package modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Wil
 */
public class VentaUnitaria {
    private String idVenta;
    private Date fecha;
    //private SimpleDateFormat fecha;
    private String idProducto;
    private String presentacion; //docena o media docena
    private int cantidad;
    private double valor;
    private String idVendedor;
    private String idCliente;

    public VentaUnitaria() {
    }
    
    public VentaUnitaria(String idVenta, Date fecha, String idProducto, String presentacion, int cantidad, double valor, String idVendedor, String idCliente) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.idProducto = idProducto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
    }
    
    /*
    public VentaUnitaria(String idVenta, SimpleDateFormat fecha, String idProducto, String presentacion, int cantidad, double valor, String idVendedor, String idCliente) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.idProducto = idProducto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
    } */

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /*
    public SimpleDateFormat getFecha() {
        return fecha;
    }

    public void setFecha(SimpleDateFormat fecha) {
        this.fecha = fecha;
    }
    */

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    


    
    
    
    
    
}
