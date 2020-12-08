/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;

/**
 *
 * @author PuntoPC
 */
public class ClienteCRUD extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    public ClienteCRUD() {
        initComponents();
        activarControles(false);
    }
    
    
////////////////////////GETTERS DE TEXTFIELD
    
    //ID
    public String getIdCliente(){
        return txtID.getText().trim();
    }
    
    //NOMBRE
    public String getNombre(){
        return txtNombre.getText();
    }
    
    //TELEFONO
    public String getTelefono(){
        return txtTelefono.getText();
    }
    
    //DIRECCION (LONGITUD)
    public String getLongitudTxt(){
        return txtLongitud.getText();
    }
    
    public int getLongitudNum(){
        return Integer.parseInt(txtLongitud.getText());
    }
    
    
    //DIRECCION (LATITUD)
    public String getLatitudTxt(){
        return txtLatitud.getText();
    }
    
    public int getLatitudNum(){
        return Integer.parseInt(txtLatitud.getText());
    }
    
    
////////////////METODOS PARA AGREGAR LA ESCUCHA A LOS BOTONES
    
    //BOTON REGISTRAR
    public void escuchaBtnRegistrar(ActionListener listenPrograma){
        btnRegistrar.addActionListener(listenPrograma);        
    }
    
    //BOTON MODIFICAR
    public void escuchaBtnModificar(ActionListener listenPrograma){
        btnModificar.addActionListener(listenPrograma);        
    }
    
    //BOTON ELIMINAR
    public void escuchaBtnEliminar(ActionListener listenPrograma){
        btnEliminar.addActionListener(listenPrograma);        
    }
    
    
//////////////////////////////GESTION DE MENSAJES 
    public void gestionMensajes(String mensaje, String titulo, int icono){
         JOptionPane.showMessageDialog(this,mensaje, titulo, icono);
    }



////////////////LIMPIAR LA TABLA (BORRA TODAS LAS FILAS)
    private void limpiarTabla(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTablaClientes.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
    
    
    
////////////////CARGA LOS DATOS DE LOS CLIENTES EN LA TABLA
    public void cargarClientes(ArrayList<Cliente> listado){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTablaClientes.getModel();        
        limpiarTabla();
        for(int i= 0; i < listado.size(); i++){
              modelo.addRow(
                      new Object[]{
              listado.get(i).getId(),
              listado.get(i).getNombre(),
              listado.get(i).getTelefono(),
              listado.get(i).getUbicacion().x,
              listado.get(i).getUbicacion().y,
                      });
        }
    }
    
    
 //////////////////ACTIVA Y DESACTIVA LOS TEXTFIELD Y TABLA
    public void activarControles(boolean estado){
        txtID.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtTelefono.setEnabled(estado);
        txtLongitud.setEnabled(estado);
        txtLatitud.setEnabled(estado);
        jTablaClientes.setEnabled(!estado);
    }   
    
    
////////////////LIMPIA LOS TEXTFIELD
    public void limpiarTxt(){
        txtID.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtLongitud.setText("");
        txtLatitud.setText("");
    }    
    
    

/////ACCION AL DAR EN EL BOTON DE REGISTRAR PARA INSERTAR UN NUEVO CLIENTE    
    public void accionRegistrar(){  
        
        if(btnRegistrar.getText().equals("Registrar")){  
            limpiarTxt();
            activarControles(true);
            btnEliminar.setEnabled(false);
            txtID.setText("C");
            
            btnRegistrar.setText("Guardar");
            btnRegistrar.setActionCommand("Guardar");
            
            btnModificar.setText("Cancelar");
            btnModificar.setActionCommand("Cancelar");
            txtID.requestFocusInWindow();
        }
        else{
            activarControles(false); 
            limpiarTxt();
            btnEliminar.setEnabled(true);
            
            btnRegistrar.setText("Registrar");
            btnRegistrar.setActionCommand("Registrar");
            
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            btnRegistrar.requestFocusInWindow();
        }
    }
    
    
    
//////ACCION AL DAR EN EL BOTON MODIFICAR PARA ACTUALIZAR UN PRODUCTO
    public void accionModificar(){
        
        if(btnModificar.getText().equals("Modificar")){
            
            if(jTablaClientes.getSelectedRow() == -1){
                
               if(jTablaClientes.getRowCount() == 0){
                   JOptionPane.showMessageDialog(this,"NO HAY REGISTROS");
               }
               else{
                   JOptionPane.showMessageDialog(this,"SELECCIONE UN CLIENTA EN LA TABLA");
               }
            }else{ 
                activarControles(true); 
                txtID.setEnabled(false);
                btnEliminar.setEnabled(false);
                jTablaClientes.setEnabled(false);
                
                btnRegistrar.setText("Actualizar");
                btnRegistrar.setActionCommand("Actualizar");  
                
                btnModificar.setText("Cancelar");
                btnModificar.setActionCommand("Cancelar");
                txtNombre.requestFocusInWindow();
            }
        }else{
            activarControles(false);    
            btnEliminar.setEnabled(true);
            jTablaClientes.setEnabled(true);
            
        btnRegistrar.setText("Registrar");
            btnRegistrar.setActionCommand("Registrar");
            
            btnModificar.setText("Modificar");
            btnModificar.setActionCommand("Modificar");
            btnModificar.requestFocusInWindow();
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jpDatosPersonales1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtLongitud = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtLatitud = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablaClientes = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Registro de Clientes");

        jpDatosPersonales1.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Datos personales ]"));
        jpDatosPersonales1.setToolTipText("");

        jLabel10.setText("Identificacion");

        jLabel11.setText("Nombre");

        jLabel12.setText("Telefono");

        jLabel13.setText("Longitud (X)");

        btnRegistrar.setText("Registrar");

        btnEliminar.setText("Eliminar");

        btnModificar.setText("Modificar");

        jLabel14.setText("Latitud (Y)");

        javax.swing.GroupLayout jpDatosPersonales1Layout = new javax.swing.GroupLayout(jpDatosPersonales1);
        jpDatosPersonales1.setLayout(jpDatosPersonales1Layout);
        jpDatosPersonales1Layout.setHorizontalGroup(
            jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosPersonales1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(4, 4, 4)
                .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnModificar)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(jpDatosPersonales1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpDatosPersonales1Layout.setVerticalGroup(
            jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosPersonales1Layout.createSequentialGroup()
                .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpDatosPersonales1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
                    .addGroup(jpDatosPersonales1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnModificar)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosPersonales1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar))
                    .addGroup(jpDatosPersonales1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatosPersonales1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addContainerGap())
        );

        jLabel5.setText("[ Listado Clientes ]");

        jTablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono", "Longitud (X)", "Latitud (Y)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTablaClientes);

        btnVolver.setBackground(new java.awt.Color(0, 102, 255));
        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/volver.PNG"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpDatosPersonales1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVolver))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jpDatosPersonales1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(btnVolver))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        //remove(this);
        setVisible(false);
        EmpresaGUI menuEmpresa =new EmpresaGUI();
        menuEmpresa.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jTablaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaClientesMouseClicked
        
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTablaClientes.getModel();
                            
        if(jTablaClientes.getSelectedRow()==-1){
            
            if(jTablaClientes.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"NO HAY REGISTROS");
            }
            else{
                JOptionPane.showMessageDialog(this,"SELECCIONE UN CLIENTE EN LA TABLA");
            }
        }
        else {                               
            txtID.setText(modelo.getValueAt(jTablaClientes.getSelectedRow(), 0).toString());            
            txtNombre.setText(modelo.getValueAt(jTablaClientes.getSelectedRow(), 1).toString());
            txtTelefono.setText(modelo.getValueAt(jTablaClientes.getSelectedRow(), 2).toString());  
            txtLongitud.setText(modelo.getValueAt(jTablaClientes.getSelectedRow(), 3).toString());
            txtLatitud.setText(modelo.getValueAt(jTablaClientes.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_jTablaClientesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablaClientes;
    private javax.swing.JPanel jpDatosPersonales1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
