/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.ClienteCRUD;
import modelo.Cliente;
import modelo.ClienteDAO;
/**
 *
 * @author Wil
 */
public class ClienteController implements ActionListener {
    private ClienteCRUD vista = new ClienteCRUD();
    private ClienteDAO dao = new ClienteDAO();
    Cliente cliente = new Cliente();
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    public ClienteController (ClienteCRUD v) {
        this.vista = v;
        //this.dao = dao;
        
       //this.vista.btnCrear.addActionListener(this);
       this.vista.btnActualizar.addActionListener(this);
       //this.vista.addListenerBtnBorrar(this);
       //this.vista.addListenerBtModificar(this);        
    }
    
    
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
         
        }
        
        
        }
    

// ESTE METODO ESTA ELABORADO EN BASE A LO QUE PUSE EN COMMENT CAMILA