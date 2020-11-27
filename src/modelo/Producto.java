package modelo;

/**
 *
 * @author Camila
 */
public class Producto {
    
    //ATRIBUTOS
    private String id;
    private String nombre;
    //private ProductoPresentacion presentacion;
    private int cantidadX6;
    private int cantidadX12;
    //private ArrayList<MateriaPrima> consumo;
    
    //CONSTRUCTOR
    //public Producto(){} //Por defecto
    
    public Producto(String id, String nombre, int cantX6, int cantX12){
        this.id = id;
        this.nombre = nombre;
        this.cantidadX6 = cantX6;
        this.cantidadX12 = cantX12;
    }
    
    
    //GETTERS
    public String getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadX6() {
        return cantidadX6;
    }

    public int getCantidadX12() {
        return cantidadX12;
    }
    
    
    
    
    //SETTERS
    public void setId(String id){
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadX6(int cantidadX6) {
        this.cantidadX6 = cantidadX6;
    }

    public void setCantidadX12(int cantidadX12) {
        this.cantidadX12 = cantidadX12;
    }
    
    
    
}
