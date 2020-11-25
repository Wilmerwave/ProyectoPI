/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;


/**
 *
 * @author federicobarbetti
 */
public class FacturadeCompra {
    
    //ATRIBUTOS
    
    private String id;
    private static LocalDate fecha; // ejemplo; el 24 de Noviembre de 2020 => "2020-11-24".
    private double valorFactura;
    //private items_MateriaPrimaComprada infoMP;
    
    
    //CONSTRUCTOR

    public FacturadeCompra(String id, double valorFactura) {
        this.id = id;
        this.valorFactura = valorFactura;
    }
    public FacturadeCompra() {
        id = " ";
        valorFactura = 0.0;
    }
    
    
    
    
    //GETTERS & SETTERS

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public double getValorFactura() {
        return valorFactura;
    }

    public void setValorFactura(double valorFactura) {
        this.valorFactura = valorFactura;
    }
    
    public LocalDate setFechaFacturadeCompra(String fcompra){// convierte un String -> LocalDate
        
        try {
        
        LocalDate now = LocalDate.parse(fcompra);
        
            System.out.println(" Datos ingesados correctamente");
        
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, " el formato debe ser => 2020-11-24  " + e);
            
           // setFechaFacturadeCompra(" 1111-11-11");
            
        
        }finally{
            
            LocalDate now = LocalDate.parse(fcompra);
        
            System.out.println(" Fecha de compra es: " + now + "\n");
        
            return now;
        }
        
    }
        
        
    
    
    
    
    public String getFechadeHoy( LocalDate fecha){ // devuelve un String del dato LocalDate
        
        String fechaFC = " ";// ejemplo; el 24 de Noviembre de 2020 => "2020-11-24".
        
        fechaFC = fecha.toString();
        
        //System.out.println(" Fecha de compra es: " + fechaFC + "\n");
        
        return fechaFC;
        
        
    }

    public static LocalDate getFecha() {
        return fecha;
    }
    
        
    
    
    
}
