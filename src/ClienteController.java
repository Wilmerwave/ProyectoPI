import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ClienteDAO;
import vista.ClienteCRUD;

/**
 *
 * @author Wil
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
                //registrar();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("MODIFICAR")){
                vista.accionModificar();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("ACTUALIZAR")){
                //actualizar();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("ELIMINAR")){
                //eliminar();
            }
        }
        
        
        
    }
        
}
    

// ESTE METODO ESTA ELABORADO EN BASE A LO QUE PUSE EN COMMENT CAMILA