/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Point;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.ConsumoMateriaPrima;
import modelo.ConsumoMateriaPrimaDAO;
import modelo.FacturaVenta;
import modelo.FacturaVentaDAO;
import modelo.MateriaPrima;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.VentaUnitaria;
import vista.MenuGUI;

/**
 *
 * @author Lenovo
 */
public class EjemploPi {

    
    public static void main(String[] args) {
        
        //MenuGUI ventana = new MenuGUI();
        //ventana.setVisible(true);
        
        
        //Producto p = new Producto("345","Empanada",10,10,5000,7000);
        //Producto p2 = new Producto("347","Empanada",3,0,500,100);
        //ProductoDAO dao = new ProductoDAO();
        //dao.agregarProducto(p);
        //dao.agregarProducto(p2);
        //dao.modificarProducto(new Producto("347","Dedo",1,0,900,900));
        //System.out.println(dao.listadoProductos().get(0).getId() + " " + dao.listadoProductos().get(0).getNombre());
        //System.out.println(dao.listadoProductos().get(1).getId() + " " + dao.listadoProductos().get(1).getNombre());
        //dao.cantidadDocena(p, 10);
        //dao.cantidadMediaDocena(p2, 30);
        //dao.eliminarProducto("345");
        //dao.eliminarProducto("347");
        
        //ArrayList<Producto> lis = dao.listadoProductos();
        
        //for(int i=0; i<lis.size(); i++){
          // System.out.println(lis.get(i).getId() + " " + lis.get(i).getNombre() + " "
            //       + lis.get(i).getCantidadX6() + " "
              //     + lis.get(i).getCantidadX12() + " "
                //   + lis.get(i).getPreciox6() + " "
                  // + lis.get(i).getPreciox12());
        
        //}
        
        
        /*
        FacturaVenta f = new FacturaVenta("20",38000,"78");
        FacturaVentaDAO dao = new FacturaVentaDAO();
        dao.agregarFactura(f);
        //dao.modificarFactura(new FacturaVenta("16",20000,"78"));
        //System.out.println(dao.listadoFactura().get(0).getIdFactura() + " " + String.valueOf(dao.listadoFactura().get(0).getValorVenta()));
        //dao.eliminarFactura("16");
        System.out.println(dao.MuestraUnaFactura("20").get(0).getValorVenta());
        */
        
        
        //Cliente cliente = new Cliente("149","trezzz","876",new Point(40,45));
        //Cliente cliente1 = new Cliente("149","DOZZZ","877",new Point(45,45));
        //ClienteDAO dao1 = new ClienteDAO();
        //System.out.println(cliente.getUbicacion());
        //System.out.println(cliente.getUbicacion().x);
        //System.out.println(cliente.getUbicacion().y);
        //dao1.agregarCliente(cliente);
        //dao1.modificarCliente(cliente1);
        //dao1.muestraPunto("12","camila","2344",12,8);
        //Point pun = new Point(dao1.muestraPunto("149"));
        //Point pun = new Point(dao.muestraPunto(cliente));
        //System.out.println(pun);
        //System.out.println(pun.x + " " + pun.y);
        //dao1.eliminarCliente("149");
        /*
        ArrayList<Cliente> lis = dao1.listadoClientes();
        
        for(int i=0; i<lis.size(); i++){
           System.out.println(lis.get(i).getId() + " " + lis.get(i).getNombre() + " "
                   + lis.get(i).getTelefono() + " "
                   + lis.get(i).getUbicacion() );
        
        }*/
        
        
        //VentaUnitaria venta = new VentaUnitaria("34",new Date(2020,09,09),"345","docena",12,25000,"V01",);
        
        
        //ConsumoMateriaPrima consumo = new ConsumoMateriaPrima("P06","M11",900);
        //ConsumoMateriaPrimaDAO consumoDAO = new ConsumoMateriaPrimaDAO();
        //consumoDAO.agregarConsumo(consumo);
        //consumoDAO.eliminarConsumo("P06", "M10");
        //ArrayList<MateriaPrima> lis = consumoDAO.listadoDocenaX("P05",5);
        //System.out.println(lis.get(3).getId() + " " + lis.get(3).getCantidad());
        //ArrayList<MateriaPrima> lis1 = consumoDAO.listadoMediaDocenaX("P05",6);
        
        //for(int i=0; i<lis.size(); i++){
           // System.out.println(lis.get(i).getId() + " " + lis.get(i).getCantidad());
        
        //}
        
        
    }
    
}
