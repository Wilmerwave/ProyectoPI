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
    private String hora;
    private String idProducto;
    private String presentacion; //docena o media docena
    private int cantidad;
    private double valor;
    private String idVendedor;
    private String idCliente;

    //CONSTRUCTOR
    public VentaUnitaria(){} //POR DEFECTO
    
    public VentaUnitaria(String idVenta, Date fecha, String hora, String idProducto, String presentacion, int cantidad, double valor, String idVendedor, String idCliente) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.hora = hora;
        this.idProducto = idProducto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.valor = valor;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
    }
   
    
    //GETTERS AND SETTERS
    
    //ID VENTA
    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    
    //FECHA
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    //HORA
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }


    //ID PRODUCTO
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    
    //PRESENTACION
    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    
    //CANTIDAD
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    //VALOR
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    
    //ID VENDEDOR
    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    
    //ID CLIENTE
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    


    
    
    
    
    
}
