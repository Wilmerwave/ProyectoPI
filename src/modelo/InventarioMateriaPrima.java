/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author federicobarbetti
 */
public class InventarioMateriaPrima {
    
    private FacturadeCompra compras; // Agregacion Objeto FacturadeCompras. 
    private Fabrica consumo; // Agregacion Objeto Fabrica.
    
    //CONSTRUCTOR

    public InventarioMateriaPrima(FacturadeCompra compras, Fabrica consumo) {
        this.compras = compras;
        this.consumo = consumo;
    }
    
    //GETTERS / SETTERS

    public FacturadeCompra getCompras() {
        return compras;
    }

    public void setCompras(FacturadeCompra compras) {
        this.compras = compras;
    }

    public Fabrica getConsumo() {
        return consumo;
    }

    public void setConsumo(Fabrica consumo) {
        this.consumo = consumo;
    }
    
    
    
}
