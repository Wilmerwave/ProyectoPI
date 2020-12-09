package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.MateriaPrimaDAO;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import vista.ProveedorCRUD;

/**
 *
 * @author Camila
 */
public class ProveedorController {
    
    private ProveedorDAO modeloProveedor;
    private MateriaPrimaDAO modeloMateria;
    private ProveedorCRUD vista;
    
    public ProveedorController(ProveedorCRUD vista, ProveedorDAO modelo, MateriaPrimaDAO modelo1){
        this.vista = vista;
        this.modeloProveedor = modelo;
        this.modeloMateria = modelo1;
        
        vista.addListenerBtnRegistrar(new ManejoAcciones());
        vista.addListenerBtnModificar(new ManejoAcciones());
        vista.addListenerBtnEliminar(new ManejoAcciones());
        
        ArrayList<Proveedor> listadoProveedores;
        listadoProveedores = this.modeloProveedor.listadoProveedor();
        this.vista.cargarProveedores(listadoProveedores);
        
        ArrayList<String> listadoMaterial;
        listadoMaterial = this.modeloMateria.consultaMaterial();
        this.vista.llenaCombo(listadoMaterial);
    }
    
    
    class ManejoAcciones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(ae.getActionCommand().equalsIgnoreCase("Registrar")){
                vista.registrarAction();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("cancelar")){
                vista.registrarAction();
            }
            else if(ae.getActionCommand().equalsIgnoreCase("guardar")){     
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
        
        
        private void registrar(){
            if(vista.getID().equals("PV")){
                vista.gestionMensajes("INGRESE EL ID DEL PROVEEDOR",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            else if (vista.getNombre().equals("")){
                vista.gestionMensajes("INGRESE EL NOMBRE DEL PROVEEDOR",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);                        
            }
            else if (vista.getMateriaPrima().equals("Seleccionar...")){
                    vista.gestionMensajes("Seleccione la materia prima que vende el proveedor",
                            "Error de Entrada", JOptionPane.ERROR_MESSAGE );   
            }
            else if (vista.getPrecioTxt().equals("")){
                vista.gestionMensajes("Ingrese la materia prima y el precio al cual vende dicha meteria prima",
                        "Error de Entrada", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Proveedor proveedor = new Proveedor();
                proveedor.setID(vista.getID());
                proveedor.setNombre(vista.getNombre());
                proveedor.setId_MateriaPrima(modeloMateria.muestraID(vista.getMateriaPrima()));
                proveedor.setPrecio(vista.getPrecioNum());

                int tamaño;
                tamaño = modeloProveedor.listadoProveedor().size();

                int resultado = 0;
                resultado = modeloProveedor.grabarProveedorDAO(proveedor);
                
                if(resultado == 1){
                    
                    ArrayList<Proveedor> listadoProveedores;
                    listadoProveedores = modeloProveedor.listadoProveedor();
                    vista.cargarProveedores(listadoProveedores);

                    vista.activarControles(false); 
                    vista.registrarAction();
                }
                else{
                    vista.gestionMensajes("Error al grabar",
                        "Confirmación",JOptionPane.ERROR_MESSAGE);                                                 
                }
            }                                               
        }
        
        
        //////////////METODO PARA ACTUALIZAR LA INFORMACION DEL PROVEEDOR SELECCIONADO EN LA TABLA
        private void actualizar(){
            //Se crea el objeto proveedor de la clase Proveedor
            Proveedor proveedor = new Proveedor();
             
            //Se configura los datos en el objeto cliente de la clase
            //Cliente
            proveedor.setID(vista.getID());
            proveedor.setNombre(vista.getNombre());                                          
            proveedor.setId_MateriaPrima(modeloMateria.muestraID(vista.getMateriaPrima()));                                          
            proveedor.setPrecio(vista.getPrecioNum()); 
                         
            if(modeloProveedor.modificarProveedor(proveedor) == 1){
                                        
                vista.activarControles(false); 
                vista.registrarAction();
                
                ArrayList<Proveedor> listaProveedores; 
                listaProveedores = modeloProveedor.listadoProveedor();
                vista.cargarProveedores(listaProveedores);   
            } 
            else {
                vista.gestionMensajes(
                        "ACTUALIZACION FALLIDA",
                        "Confirmación ", 
                        JOptionPane.ERROR_MESSAGE);                 
            }              
        } 
        
        
        
        
/////////METODO PARA ELIMINAR UN PROVEEDOR DE LA BBDD  
        private void eliminar(){
            String codigo = "";
            codigo  = vista.getID().trim();
            
            if(codigo.isEmpty()){
                
                 vista.gestionMensajes(
                         "POR FAVOR SELECCIONE UN PROVEEDOR DE LA TABLA",
                         "Mensaje de Advertencia ", 
                    JOptionPane.ERROR_MESSAGE);
            }
            else{
                
                int respuesta = JOptionPane.showConfirmDialog(null,
                        "¿DESEA ELIMINAR EL PROVEEDOR DE CÓDIGO : " +
                        codigo + " ?", 
                        "Confirmación de Acción", JOptionPane.YES_NO_OPTION);
                
                if(respuesta == JOptionPane.YES_OPTION){                    

                    if(modeloProveedor.borrarProveedor(codigo) ==  1){                   
                       
                        ArrayList<Proveedor> listaProveedores; 
                        listaProveedores = modeloProveedor.listadoProveedor();
                        vista.cargarProveedores(listaProveedores);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, 
                                "ERROR AL ELIMINAR EL PROVEEDOR",
                                "Confirmación de acción", 
                                JOptionPane.ERROR_MESSAGE);                    
                    }
                }
            }
        } 

        
        
    }
        
   
    
}
