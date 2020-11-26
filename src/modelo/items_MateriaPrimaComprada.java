/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;



/**
 *
 * @author Lenovo
 */
public class items_MateriaPrimaComprada {


    //Atributos
    private ArrayList<MateriaPrima> items;
    
    //Constructor
    
    public items_MateriaPrimaComprada() {
    }

    public items_MateriaPrimaComprada(ArrayList<MateriaPrima> items) {
        this.items = items;
    }
    //Getters

    public ArrayList<MateriaPrima> getItems() {
        return items;
    }
    //Setters

    public void setItems(ArrayList<MateriaPrima> items) {
        this.items = items;
    }
    
    // Metodo para adicionar un insumo comprado a una lista
    
    public void adicionarInsumo( MateriaPrima insumo){
        
        items.add(insumo);
    }
    
    // Metodo para calcular el valor de una lista de materia prima
    
    public Double valorlistaitems( ArrayList<MateriaPrima> compra){
        
        double cuenta = 0.0;
        
        FacturadeCompra pahoy = new FacturadeCompra();
        
        cuenta = cuenta + pahoy.valorFactura(compra);
        
        return cuenta;
    
    }
        
}
