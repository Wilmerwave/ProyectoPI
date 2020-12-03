package modelo;

/**
 *
 * @author Camila
 */
public class FacturaVenta {
    
    //ATRIBUTOS
    private String idFactura;
    private double valorVenta;
    private String idVenta;
    
    
    //CONSTRUCTOR
    public FacturaVenta(){} //Por defecto
    
    public FacturaVenta(String id, double valor, String idVenta){
        this.idFactura = id;
        this.valorVenta = valor;
        this.idVenta = idVenta;
    }
    
    
    //GETTERS
    public String getIdFactura() {
        return idFactura;
    }
    

    public double getValorVenta() {
        return valorVenta;
    }

    
    public String getIdVenta() {
        return idVenta;
    }
    
    
    //SETTERS
    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    
    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    
    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }
    

    
    
    
}
