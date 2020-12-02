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
public class Pago {
    //Atributos
    
    private ArrayList<Vendedor> vendedor;
    private ArrayList<FacturadeCompra>factura;
    
    //Contructores

    public Pago() {
    }

    public Pago(ArrayList<Vendedor> vendedor, ArrayList<FacturadeCompra> factura) {
        this.vendedor = vendedor;
        this.factura = factura;
    }

    
    
    //Getters
    public ArrayList<Vendedor> getVendedor() {
        return vendedor;
    }

    public ArrayList<FacturadeCompra> getFactura() {
        return factura;
    }
    //Setters

    public void setVendedor(ArrayList<Vendedor> vendedor) {
        this.vendedor = vendedor;
    }

    public void setFactura(ArrayList<FacturadeCompra> factura) {
        this.factura = factura;
    }
    
    
}
