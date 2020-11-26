/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lenovo
 */
public class ProductoPresentacion {
    //Atributos
    
    private String paquete; // valores esperados(d, md)
    private double precio; // (Precio por unidad)
    
    //Constructor

    public ProductoPresentacion() {
    }

    public ProductoPresentacion(String paquete, double precio) {
        this.paquete = paquete;
        this.precio = precio;
    }
    //Getters

    public String getPaquete() {
        return paquete;
    }

    public double getPrecio() {
        return precio;
    }
    //Settters

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    public double precioMD(){
        if(paquete.endsWith("md") ){
            return 6*precio;
        }else{
                    return 1;
            }
    }
    
    public double precioD(){
        if(paquete.endsWith("d") ){
            return 12*precio;
        }else{
                    return 1;
            }
    }
}
