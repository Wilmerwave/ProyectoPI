/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Point;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.FacturaVenta;
import modelo.FacturaVentaDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.VentaUnitaria;
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
        */
        
        /*
        FacturaVenta f = new FacturaVenta("20",38000,"78");
        FacturaVentaDAO dao = new FacturaVentaDAO();
        dao.agregarFactura(f);
        //dao.modificarFactura(new FacturaVenta("16",20000,"78"));
        //System.out.println(dao.listadoFactura().get(0).getIdFactura() + " " + String.valueOf(dao.listadoFactura().get(0).getValorVenta()));
        //dao.eliminarFactura("16");
        System.out.println(dao.MuestraUnaFactura("20").get(0).getValorVenta());
        */
        
        
        //Cliente cliente = new Cliente("149","trezzz",new Point(40,45),"876");
        //ClienteDAO dao = new ClienteDAO();
        //System.out.println(cliente.getUbicacion());
        //System.out.println(cliente.getUbicacion().x);
        //System.out.println(cliente.getUbicacion().y);
        //dao.agregarCliente(cliente);
        //dao.modificarCliente(cliente);
        //dao.muestraPunto("12","camila","2344",12,8);
        //dao.muestraPunto(cliente);
        //Point pun = new Point(dao.muestraPunto("149"));
        //Point pun = new Point(dao.muestraPunto(cliente));
        //System.out.println(pun);
        //System.out.println(pun.x + " " + pun.y);
        //*/
        
        
        //VentaUnitaria venta = new VentaUnitaria("34",new Date(2020,09,09),"345","docena",12,25000,"V01",);
    }
    
}
