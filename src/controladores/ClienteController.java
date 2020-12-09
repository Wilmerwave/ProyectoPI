package controladores;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.ClienteCRUD;

/**
 *
 * @author PuntoPC
 */
public class ClienteController {
    
    //ATRIBUTOS
    private ClienteCRUD vista = new ClienteCRUD();
    private ClienteDAO modelo = new ClienteDAO();
    
    
    //CONSTRUCTOR
    public ClienteController(ClienteCRUD vista, ClienteDAO modelo){
        
        this.vista = vista;
        this.modelo = modelo;
        
        //AGREGA LA ESCUCHA
        this.vista.escuchaBtnRegistrar(new ManejaAcciones());
        this.vista.escuchaBtnModificar(new ManejaAcciones());
        this.vista.escuchaBtnEliminar(new ManejaAcciones());
       //this.vista.btnCrear.addActionListener(this);
       //this.vista.btnActualizar.addActionListener(this);
       //this.vista.addListenerBtnBorrar(this);
       //this.vista.addListenerBtModificar(this);   
       
       //SE LLENA LA TABLA
        ArrayList<Cliente> listaClientes;
        listaClientes = this.modelo.listadoClientes();
        this.vista.cargarClientes(listaClientes);
    }
    
        /*
        //DONDE SE LE DA EL METODO AL BOTON
        @Override
        public void actionPerformed(ActionEvent e) {
          if(e.getSource()==vista.btnActualizar){
              listarC(vista.Tabla);
          }
         } 
        // METODO QUE LISTA LOS VALORES DE LA TABLA GRACIAS A LISTARCLIENTE EN DAO
        public void listarC (JTable tabla){
         modelo =(DefaultTableModel)tabla.getModel();
         ArrayList<Cliente> lista = dao.listarCliente();
         Object[] object = new Object[4];
         for(int i = 0; i < lista.size(); i++){
             object[0] = lista.get(i).getId();
             object[1] = lista.get(i).getNombre();
             object[2] = lista.get(i).getTelefono();
             //object[3] = lista.get(i).getUbicacion();
             //object[4] = lista.get(i).getUbicacion();
             modelo.addRow(object);
             
         }
         vista.Tabla.setModel(modelo);
         
        } */
        
        
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
        
        
        
////////////////METODO PARA REGISTRAR UN NUEVO CLIENTE EN LA BBDD
        private void registrar(){
            
            //VALIDACION DE LOS TEXTFIELD
            if(vista.getIdCliente().equals("C")){
                vista.gestionMensajes("INGRESE EL ID DEL CLIENTE",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            else if (vista.getNombre().equals("")){
                vista.gestionMensajes("INGRESE EL NOMBRE DEL CLIENTE",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);                        
            }
            else if (vista.getTelefono().equals("")){
                    vista.gestionMensajes("INGRESE EL TELEFONO DEL CLIENTE",
                            "Error de Entrada", JOptionPane.ERROR_MESSAGE );   
            }
            else if (vista.getLongitudTxt().equals("")){
                vista.gestionMensajes("INGRESE LA LONGITUD(PUNTO EN EL EJE X) DEL CLIENTE",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            else if (vista.getLatitudTxt().equals("")){
                vista.gestionMensajes("INGRESE LA LATITUD(PUNTO EN EL EJE Y) DEL CLIENTE",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            
            else{
                Cliente cliente = new Cliente();
                cliente.setId(vista.getIdCliente());
                cliente.setNombre(vista.getNombre());
                cliente.setTelefono(vista.getTelefono());
                cliente.setUbicacion(new Point(vista.getLongitudNum() , vista.getLatitudNum()));

                int tamaño;
                tamaño = modelo.listadoClientes().size();

                int resultado = 0;
                resultado = modelo.agregarCliente(cliente);
                
                if(resultado == 1){
                    
                    ArrayList<Cliente> listaClientes;
                    listaClientes = modelo.listadoClientes();
                    vista.cargarClientes(listaClientes);

                    vista.activarControles(false); 
                    vista.accionRegistrar();
                }
                else{
                    vista.gestionMensajes("ERROR AL GUARDAR",
                        "Confirmación",JOptionPane.ERROR_MESSAGE);                                                 
                }
            }                                               
        }
        
        
        
//////////////METODO PARA ACTUALIZAR LA INFORMACION DEL CLIENTE SELECCIONADO EN LA TABLA
        private void actualizar(){
            //Se crea el objeto cliente de la clase Cliente
            Cliente cliente = new Cliente();
             
            //Se configura los datos en el objeto cliente de la clase
            //Cliente
            cliente.setId(vista.getIdCliente());
            cliente.setNombre(vista.getNombre());                                          
            cliente.setTelefono(vista.getTelefono());                                          
            cliente.setUbicacion(new Point(vista.getLongitudNum() , vista.getLatitudNum())); 
                         
            if(modelo.modificarCliente(cliente) == 1){
                                        
                vista.activarControles(false); 
                vista.accionRegistrar();
                
                ArrayList<Cliente> listaClientes; 
                listaClientes = modelo.listadoClientes();
                vista.cargarClientes(listaClientes);   
            } 
            else {
                vista.gestionMensajes(
                        "ACTUALIZACION FALLIDA",
                        "Confirmación ", 
                        JOptionPane.ERROR_MESSAGE);                 
            }              
        } 
        
        
        
        
/////////METODO PARA ELIMINAR UN CLIENTE DE LA BBDD  
        private void eliminar(){
            String codigo = "";
            codigo  = vista.getIdCliente().trim();
            
            if(codigo.isEmpty()){
                
                 vista.gestionMensajes(
                         "POR FAVOR SELECCIONE UN CLIENTE DE LA TABLA",
                         "Mensaje de Advertencia ", 
                    JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿DESEA ELIMINAR EL CLIENTE DE CÓDIGO : " +
                        codigo + " ?", 
                        "Confirmación de Acción", JOptionPane.YES_NO_OPTION);
                
                if(respuesta == JOptionPane.YES_OPTION){                    

                    if(modelo.eliminarCliente(codigo) ==  1){                   
                       
                        ArrayList<Cliente> listaClientes; 
                        listaClientes = modelo.listadoClientes();
                        vista.cargarClientes(listaClientes);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                "ERROR AL ELIMINAR EL CLIENTE",
                                "Confirmación de acción", 
                                JOptionPane.ERROR_MESSAGE);                    
                    }
                }
            }
        }         
        
    }
        
}
    

// ESTE METODO ESTA ELABORADO EN BASE A LO QUE PUSE EN COMMENT CAMILA
    

