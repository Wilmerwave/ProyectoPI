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
    //private int cantidadX6;
    //private int cantidadX12;
    //private ArrayList<MateriaPrima> consumo;
    
    //CONSTRUCTOR
    public Producto(){} //Por defecto
    
    public Producto(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    
    //GETTERS
    public String getId(){
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    //SETTERS
    public void setId(String id){
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
