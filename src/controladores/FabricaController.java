/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.util.converter.LocalDateStringConverter;
import javax.swing.JOptionPane;
import modelo.FacturadeCompra;
import modelo.FacturadeCompra;
import modelo.Producto;
import modelo.Producto;

/**
 *
 * @author Lenovo
 */
public class FabricaController extends FacturadeCompra{

    // Atributos

    
    private ArrayList<Producto> producido ;
    private MateriaPrima disponibilidad;
    private String turno; // nombre asignado a la jornada de produccion....Unico??
    private String fechadeProduccion;// ejemplo; el 24 de Noviembre de 2020 => "2020-11-24". Fecha en que se ejecuto el turno
    //private static LocalDate fecha;
    
    private Producto emp;//atributo que representa a la empanada
    private Producto pdc;//atributo que representa al pastel de carne
    private Producto pdp;//atributo que representa al pastel de pollo
    private Producto chu;//atributo que representa al churro
    private Producto ded;//atributo que representa al dedo de queso
    private Producto hoj;//atributo que representa a la hojaldra
    
    private ArrayList<Producto> listaProductosFabricados; // Coleccion de Productos
    
    
    
    
    //Constructor

    public FabricaController() {
        
        
        
        turno = " ";  
        
        fechadeProduccion = " ";
        
        ArrayList<Producto> listaProductosFabricados =  new ArrayList<>();
        
        Producto emp = new Producto();//atributo que representa a la empanada
        Producto pdc = new Producto();//atributo que representa al pastel de carne
        Producto pdp = new Producto();//atributo que representa al pastel de pollo
        Producto chu = new Producto();//atributo que representa al churro
        Producto ded = new Producto();//atributo que representa al dedo de queso
        Producto hoj = new Producto();//atributo que representa a la hojaldra
        
        iniciarproduccion();
        
        
        
        
        
    }


    // GETTERS & SETTERS

    public FabricaController(String turno, ArrayList<Producto> producido) {
        this.turno = turno;
        this.producido = producido;
        this.disponibilidad = disponibilidad;
    }
    
    
    //Getters


    public String getTurno() {    
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFechadeProduccion() {
        return fechadeProduccion;
    }


    public void setFechadeProduccion(String fechadeProduccion) {
        this.fechadeProduccion = fechadeProduccion;
    }

    public ArrayList<Producto> getListaProductosFabricados( ArrayList<Producto> loproducido) {
        
        loproducido = listaProductosFabricados;
        
        return loproducido;
    }

    public void setListaProductosFabricados() {
        
        ArrayList<Producto> fabricados = new ArrayList<>();
        
        fabricados = listaProductosFabricados;
    }
    
    
    
    /*
    
    metodo por revisar
    
    */

    public LocalDate convierteFecha_to_LocalDate(String fecha_Prod){// convierte un String -> LocalDate
        
        try {
        
        LocalDate now = LocalDate.parse(fecha_Prod);
        
            System.out.println(" Datos ingesados correctamente");
        
        
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, " el formato debe ser => 2020-11-24  " + e);
            
           convierteFecha_to_LocalDate(fecha_Prod);
            
        
        }finally{
            
            LocalDate now = LocalDate.parse(fecha_Prod);
        
            System.out.println(" Fecha de produccion es: " + now + "\n");
        
            return now;
        }
        
        
    }
    
    //Metodo que inicia la produccion en la fabrica con datos iniciales para pruebas
    // estructura del dato String (id), String (nombre), int (cantidadx6), int (cantidadx12).
   
       public void iniciarproduccion(){
           
        ArrayList<Producto> producidos = new ArrayList<>();
        
        //producidos = listaProductosFabricados;
        Producto emp = new Producto("P01", "Empanadas", 10, 10, 4200, 8200);
        Producto pdc = new Producto("P01", "Pastel de Carne", 20, 15, 9000, 17000);
        Producto pdp = new Producto("P01", "Pastel de Pollo", 8, 12, 9000, 17000);
        Producto chu = new Producto("P01", "Churros", 22, 16, 8400, 16000);
        Producto ded = new Producto("P01", "Dedos", 15, 8, 9000, 17000);
        Producto hoj = new Producto("P01", "Hojaldras", 8, 17, 3600, 7000);
        
        producidos.add(emp);
        producidos.add(pdc);
        producidos.add(pdp);
        producidos.add(chu);
        producidos.add(ded);
        producidos.add(hoj);
        
        System.out.println(" El producto  "  + emp.getNombre()+ " de codigo: " + emp.getId()+ " fue cargado exitosamente " );
        System.out.println(" El producto  "  + pdc.getNombre()+ " de codigo: " + pdc.getId()+ " fue cargado exitosamente " );
        System.out.println(" El producto  "  + pdp.getNombre()+ " de codigo: " + pdp.getId()+ " fue cargado exitosamente " );
        System.out.println(" El producto  "  + chu.getNombre()+ " de codigo: " + chu.getId()+ " fue cargado exitosamente " );
        System.out.println(" El producto  "  + ded.getNombre()+ " de codigo: " + ded.getId()+ " fue cargado exitosamente " );
        System.out.println(" El producto  "  + hoj.getNombre()+ " de codigo: " + hoj.getId()+ " fue cargado exitosamente " );
        
        JOptionPane.showMessageDialog(null, " los productos fueron cargados exitosamente \n");
        
       }
       
       /*
    
       metodo por revisar
       METODO QUE LISTA LA PRODUCCION DE UN DIA DETERMINA
    
       */

        public String producidoTaldiaFab(String eldia ){
        
        String reportedeProduccion = " ";
        
        FabricaController relacionado = new FabricaController();
        
        if(eldia.equals(relacionado.getFechadeProduccion())){
            
            reportedeProduccion = relacionado.getTurno();
            
            System.out.println(" lo que se produjo ese dia " +
                    reportedeProduccion );
        }
        
        return reportedeProduccion;
        
        }
        
        /*
    
       metodo por revisar
       Metodo que imprime la informacion individual de los productos que esten
        contenidos en un array de productos.
    
       */
    
        
        
        public ArrayList imprimirListadeProductos2( ArrayList<Producto> fabricados){
        
        fabricados = new ArrayList<>();
        
        fabricados = listaProductosFabricados;
        
        for ( Producto ob : listaProductosFabricados){
                
                Producto buscado = (Producto) ob;
                
                int infox6 = buscado.getCantidadX6();
            
                int infox12 = buscado.getCantidadX12();
            
                String productox6 = String.valueOf(infox6);
            
                String productox12 = String.valueOf(infox12);
            
                System.out.println(" INFORMACION DEL PRODUCTO " + " \n id del producto " + buscado.getId()
            
            + " \n Nombre del producto " + buscado.getNombre() + 
                    
                    " \n Cantidad x 6 \n" + productox6 + " \n Cantidad x 12 \n" + productox12 );
                
                
            }
        
        return listaProductosFabricados;
            
        
    
    }
    
        public void imprimirListadeProductos( ){
        
        ArrayList<Producto> fabricados = new ArrayList<>();
        
        fabricados = listaProductosFabricados;
        
        Iterator iterator = fabricados.iterator();
        
        while (iterator.hasNext()){
            
            Producto aimprimir = (Producto) iterator.next();
            
            int infox6 = aimprimir.getCantidadX6();
            
            int infox12 = aimprimir.getCantidadX12();
            
            String productox6 = String.valueOf(infox6);
            
            String productox12 = String.valueOf(infox12);
            
            System.out.println(" INFORMACION DEL PRODUCTO " + " \n id del producto " + aimprimir.getId()
            
            + " \n Nombre del producto " + aimprimir.getNombre() + 
                    
                    " \n Cantidad x 6 \n" + productox6 + " \n Cantidad x 12 \n" + productox12 );
                    
                   
            
         }
        
        
    
    }
    
    /*
    
       metodo por revisar
       METODO QUE LISTA LA PRODUCCION DE UN DIA DETERMINA
    
       */
    
    public void publicarProducidoenFabrica(){
        
        ArrayList<FabricaController> fab = new ArrayList<>();
        
        for( FabricaController producido : fab){
            
            FabricaController oo = (FabricaController) producido;
            
            System.out.println(" info de la fabricacion  \n" + " Turno  \n" +
                    producido.getTurno() +  " fecha  \n" + producido.getFechadeProduccion());
        }
        
        
    }
    
   // Metodo para construir un producto
    
    public Producto construyoProducto(){
        
        Producto  mi_producto = new Producto();
        
        String id_producto = JOptionPane.showInputDialog(" ingrese el id del producto");
        
        mi_producto.setId(id_producto);
        
        String nom_producto = JOptionPane.showInputDialog(" ingrese el mombre del producto");
        
        mi_producto.setNombre(nom_producto);
        
        //String str4 = new Integer(1234).toString();
        
        String cantx12 = JOptionPane.showInputDialog(" ingrese la cantidad de paquetes x 12 unidades ");
        
        int paqx12 = 0;
        
        paqx12 = Integer.parseInt(cantx12);
        
        mi_producto.setCantidadX12(paqx12);
        
        String cantx6 = JOptionPane.showInputDialog(" ingrese la cantidad de paquetes x 6 unidades ");
        
        int paqx6 = 0;
        
        paqx6 = Integer.parseInt(cantx6);
        
        mi_producto.setCantidadX12(paqx6);
        
            System.out.println(" Info de mi nuevo producto " + " \n id del producto; " + mi_producto.getId()
                + " \n nombre del producto: " + mi_producto.getNombre());
        
        return mi_producto;
    
    
    }
    
    /*
    
    public Fabrica construyoProduccion(){
        
        ArrayList<Fabrica>  fabricadohoy = new ArrayList<>();
        
        int verificador = 0;
        
        while (verificador < 7 ) {  
            
            f
            
            
            
        }
        
        String id_producto = JOptionPane.showInputDialog(" ingrese el id del producto");
        
        mi_producto.setId(id_producto);
        
        String nom_producto = JOptionPane.showInputDialog(" ingrese el mombre del producto");
        
        mi_producto.setNombre(nom_producto);
        
        //String str4 = new Integer(1234).toString();
        
        String cantx12 = JOptionPane.showInputDialog(" ingrese la cantidad de paquetes x 12 unidades ");
        
        int paqx12 = 0;
        
        paqx12 = Integer.parseInt(cantx12);
        
        mi_producto.setCantidadX12(paqx12);
        
        String cantx6 = JOptionPane.showInputDialog(" ingrese la cantidad de paquetes x 6 unidades ");
        
        int paqx6 = 0;
        
        paqx6 = Integer.parseInt(cantx6);
        
        mi_producto.setCantidadX12(paqx6);
        
        return mi_producto;
    
    
    }

*/
    
    public void infoProducto(){
        
        Producto  producto = new Producto();
        
        System.out.println(" info producto \n" + " Id \n" + producto.getId() + " nombre \n" 
        
            + producto.getNombre() + " Cantidades x 12 \n" + producto.getCantidadX12() +  " Cantidades x 6 \n" 
                
                + producto.getCantidadX6());
       
    
    
    }
    
    
    
    
    
    public MateriaPrima getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(MateriaPrima disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
    
}
