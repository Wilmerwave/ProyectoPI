package modelo;

/**
 *
 * @author Camila
 */
public class ConsumoMateriaPrima {
    
    private String idProducto;
    private String idMaterial;
    private int cantidadConsumida;
    
    //CONSTRUCTOR
    public ConsumoMateriaPrima(){} //POR DEFECTO

    public ConsumoMateriaPrima(String idProducto, String idMaterial, int cantidadConsumida) {
        this.idProducto = idProducto;
        this.idMaterial = idMaterial;
        this.cantidadConsumida = cantidadConsumida;
    }
    
    
    //GETTERS 
    public String getIdProducto() {
        return idProducto;
    }

    
    public String getIdMaterial() {
        return idMaterial;
    }
    
    
    public int getCantidadConsumida() {
        return cantidadConsumida;
    }
    
    
    //SETTERS
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    
    
    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }
    
    
    public void setCantidadConsumida(int cantidadConsumida) {
        this.cantidadConsumida = cantidadConsumida;
    }
    
    
    
}
