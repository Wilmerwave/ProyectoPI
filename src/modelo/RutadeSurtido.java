/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author federicobarbetti
 */
public class RutadeSurtido {
    
    private  ArrayList <Cliente> rutaEstablecida; // Agregacion objeto Arraylist<ClienteEstablecimiento>
    private String nombre; // nombre asiganado a la ruta de surtido.
    
    //CONSTRUCTORES

    public RutadeSurtido( String nombre) {
        rutaEstablecida = new ArrayList<>();
        
    }
    
    //GETTERS /  SETTERS

    public ArrayList<Cliente> getRutaEstablecida() {
        return rutaEstablecida;
    }

    public void setRutaEstablecida() {
        
        rutaEstablecida = new ArrayList<>();
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // Metodo para ingresar un cliente a una ruta
    
    public void ingresarClienteaRuta( Cliente nvocliente){
        
        rutaEstablecida.add(nvocliente);
    }
    
    // Metodo para borrar un cliente a una ruta
    
    public void eliminarClienteaRuta( String abuscar){
        
        for (Cliente elcliente : rutaEstablecida){
            if(abuscar.equals(elcliente.getNombre()))
                rutaEstablecida.remove(elcliente);
        
        }
        
    }
    
    // Metodo para accesar a la informacion del cliente.
    
    public void muestrainfoCliente(){ 
        
        for (Cliente elcliente : rutaEstablecida){
            
            System.out.println("informacion cliente" + elcliente.getId()
            + elcliente.getNombre() + elcliente.getTelefono());
        }
        
        
    }
    
    // Metodo para buscaruncliente en una ruta
    
    public Cliente buscaCliente ( String abuscar){
        
        for (Cliente elcliente : rutaEstablecida){
            if(abuscar.equals(elcliente.getNombre()))
                return elcliente;
            
            System.out.println("el cliente " + elcliente.getNombre()
                    + " se encontro ");
        }
        
        return null;
        
        
    }
}
