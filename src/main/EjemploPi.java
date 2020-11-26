/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

//import modelo.Cliente;
import modelo.Producto;
import modelo.ProductoDAO;
import vista.MenuGUI;

/**
 *
 * @author Lenovo
 */
public class EjemploPi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MenuGUI ventana = new MenuGUI();
        ventana.setVisible(true);
        
        /*
        Producto p = new Producto("345","Empanada",0,0);
        Producto p2 = new Producto("347","Empanada",3,0);
        ProductoDAO dao = new ProductoDAO();
        dao.agregarProducto(p);
        dao.agregarProducto(p2);
        dao.modificarProducto(new Producto("345","Dedo",1,0));
        
        System.out.println(dao.listadoProductos().get(0).getId() + " " + dao.listadoProductos().get(0).getNombre());
        System.out.println(dao.listadoProductos().get(1).getId() + " " + dao.listadoProductos().get(1).getNombre());
        
        dao.eliminarProducto("345");
        dao.eliminarProducto("347");
        
        //Cliente cliente = new Cliente("123","camila",5,5,"678");
        //System.out.println(cliente.getUbicacion());
        */
        
    }
    
}
