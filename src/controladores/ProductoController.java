package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.ProductoDAO;
import vista.InventarioProductosGUI;

/**
 *
 * @author Camila
 */
public class ProductoController {
    
    ProductoDAO modelo;
    InventarioProductosGUI vista;
    
    //CONSTRUCTOR
    public ProductoController(InventarioProductosGUI vista, ProductoDAO modelo){
        this.vista = vista;
        this.modelo = modelo;
        
        //AGREGA LA ESCUCHA
        vista.escuchaBtnRegistrar(new ManejaAcciones());
        vista.escuchaBtnModificar(new ManejaAcciones());
        vista.escuchaBtnEliminar(new ManejaAcciones());
        
        //SE LLENA LA TABLA
        ArrayList<Producto> listadoProductos;
        listadoProductos = this.modelo.listadoProductos();
        this.vista.cargarProductos(listadoProductos);
    }
    
    
    class ManejaAcciones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(ae.getActionCommand().equalsIgnoreCase("REGISTRAR")){
                vista.accionRegistrar();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("CANCELAR")){
                vista.accionRegistrar();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("GUARDAR")){     
                registrar();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("MODIFICAR")){
                vista.accionModificar();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("ACTUALIZAR")){
                actualizar();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("ELIMINAR")){
                eliminar();
            }
        }
        
        
////////////////METODO PARA REGISTRAR UN NUEVO PRODUCTO EN LA BBDD
        private void registrar(){
            
            //VALIDACION DE LOS TEXTFIELD
            if(vista.getID().equals("P")){
                vista.gestionMensajes("INGRESE EL ID DEL PRODUCTO",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            else if (vista.getNombre().equals("")){
                vista.gestionMensajes("INGRESE EL NOMBRE DEL PRODUCTO",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);                        
            }
            else if (vista.getCantidad6Txt().equals("")){
                    vista.gestionMensajes("INGRESE LA CANTIDAD DE MEDIAS DOCENAS (0)",
                            "Error de Entrada", JOptionPane.ERROR_MESSAGE );   
            }
            else if (vista.getCantidad12Txt().equals("")){
                vista.gestionMensajes("INGRESE LA CANTIDAD DE DOCENAS (0)",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            else if (vista.getPrecio6Txt().equals("")){
                vista.gestionMensajes("INGRESE EL PRECIO POR MEDIA DOCENA",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            else if (vista.getPrecio12Txt().equals("")){
                vista.gestionMensajes("INGRESE EL PRECIO POR DOCENA",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            
            else{
                Producto producto = new Producto();
                producto.setId(vista.getID());
                producto.setNombre(vista.getNombre());
                producto.setCantidadX6(vista.getCantidad6Num());
                producto.setCantidadX12(vista.getCantidad12Num());
                producto.setPreciox6(vista.getPrecio6Num());
                producto.setPreciox12(vista.getPrecio12Num());

                int tamaño;
                tamaño = modelo.listadoProductos().size();

                int resultado = 0;
                resultado = modelo.agregarProducto(producto);
                
                if(resultado == 1){
                    
                    ArrayList<Producto> listadoProductos;
                    listadoProductos = modelo.listadoProductos();
                    vista.cargarProductos(listadoProductos);

                    vista.activarControles(false); 
                    vista.accionRegistrar();
                }
                else{
                    vista.gestionMensajes("ERROR AL GUARDAR",
                        "Confirmación",JOptionPane.ERROR_MESSAGE);                                                 
                }
            }                                               
        }
        
        
        
//////////////METODO PARA ACTUALIZAR LA INFORMACION EL PRODUCTO SELECCIONADO EN LA TABLA
        private void actualizar(){
            //Se crea el objeto producto de la clase Producto
            Producto producto = new Producto();
             
            //Se configura los datos en el objeto producto de la clase
            //Producto
            producto.setId(vista.getID());
            producto.setNombre(vista.getNombre());                                          
            producto.setCantidadX6(vista.getCantidad6Num());                                          
            producto.setCantidadX12(vista.getCantidad12Num()); 
            producto.setPreciox6(vista.getPrecio6Num());
            producto.setPreciox12(vista.getPrecio12Num());
                         
            if(modelo.modificarProducto(producto) == 1){
                                        
                vista.activarControles(false); 
                vista.accionRegistrar();
                
                ArrayList<Producto> listadoProductos; 
                listadoProductos = modelo.listadoProductos();
                vista.cargarProductos(listadoProductos);   
            } 
            else {
                vista.gestionMensajes(
                        "ACTUALIZACION FALLIDA",
                        "Confirmación ", 
                        JOptionPane.ERROR_MESSAGE);                 
            }              
        } 
        
        
        
        
/////////METODO PARA ELIMINAR UN PRODUCTO DE LA BBDD  
        private void eliminar(){
            String codigo = "";
            codigo  = vista.getID().trim();
            
            if(codigo.isEmpty()){
                
                 vista.gestionMensajes(
                         "POR FAVOR SELECCIONE UN PRODUCTO DEL INVENTARIO",
                         "Mensaje de Advertencia ", 
                    JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿DESEA ELIMINAR EL PRODUCTO DE CÓDIGO : " +
                        codigo + " ?", 
                        "Confirmación de Acción", JOptionPane.YES_NO_OPTION);
                
                if(respuesta == JOptionPane.YES_OPTION){                    

                    if(modelo.eliminarProducto(codigo) ==  1){                   
                       
                        ArrayList<Producto> listadoProductos; 
                        listadoProductos = modelo.listadoProductos();
                        vista.cargarProductos(listadoProductos);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                "ERROR AL ELIMINAR EL PRODUCTO",
                                "Confirmación de acción", 
                                JOptionPane.ERROR_MESSAGE);                    
                    }
                }
            }
        } 
        
    
    }
    
}
