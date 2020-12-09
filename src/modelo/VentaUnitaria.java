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
    private String idVendedor;
    private String idCliente;
    private String tipoVenta;

    //CONSTRUCTOR
    public VentaUnitaria(){} //POR DEFECTO
    
    public VentaUnitaria(String idVenta, Date fecha, String hora, String idProducto, String presentacion, int cantidad, String idVendedor, String idCliente, String tipoVenta) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.hora = hora;
        this.idProducto = idProducto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
        this.tipoVenta = tipoVenta;
    }
   
    
    //GETTERS 
    public String getIdVenta() {
        return idVenta;
    }
    
    
    public Date getFecha() {
        return fecha;
    }


    public String getHora() {
        return hora;
    }


    public String getIdProducto() {
        return idProducto;
    }
    

    public String getPresentacion() {
        return presentacion;
    }
    
    
    public int getCantidad() {
        return cantidad;
    }
    
    
    public String getIdVendedor() {
        return idVendedor;
    }

    
    public String getIdCliente() {
        return idCliente;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    


    //SETTERS
    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }
    
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
    
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
    
    
    
    
}
