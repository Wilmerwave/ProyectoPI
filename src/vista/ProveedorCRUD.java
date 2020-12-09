/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controladores.ProveedorController;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;
import modelo.ProveedorDAO;

/**
 *
 * @author PuntoPC
 */
public class ProveedorCRUD extends javax.swing.JFrame {

    /**
     * Creates new form ProveedorCRUD
     */
    public ProveedorCRUD() {
        initComponents();
        activarControles(false);
    }
    
    
    //Borra todas la filas del jTable
    private void limpiarListadoTabla(){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTabla.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
    
    
     //Carga los datos de las comunas en el jTable
    public void cargarProveedores(ArrayList<Proveedor> listado){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTabla.getModel();        
        limpiarListadoTabla();
        for(int i= 0; i < listado.size(); i++){
              modelo.addRow(new Object[]{
              listado.get(i).getID(),
              listado.get(i).getNombre(),
              listado.get(i).getId_MateriaPrima(),
              listado.get(i).getPrecio()
              });
        }
    }
    
    public void gestionMensajes(String mensaje, String titulo, int icono){
         JOptionPane.showMessageDialog(this,mensaje, titulo, icono);
    }
    
    public String getID(){
        return txtIdentificacion.getText().trim();
    }

    
    public String getNombre(){
        return txtNombre.getText();
    }
    
    public String getMateriaPrima(){
        return cbxMateria.getSelectedItem().toString().trim();
    }
    
    public String getPrecioTxt(){
        return txtPrecio.getText();
    }
    
    public int getPrecioNum(){
        return Integer.parseInt(txtPrecio.getText());
    }
    
    public void addListenerBtnModificar(ActionListener listenPrograma){
        btnModificar.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnRegistrar(ActionListener listenPrograma){
        btnRegistrar.addActionListener(listenPrograma);        
    }
    
    public void addListenerBtnEliminar(ActionListener listenPrograma){
        btnEliminar.addActionListener(listenPrograma);        
    }
    
    
    public void llenaCombo(ArrayList<String> materia){
        
        for(int i=0; i<materia.size(); i++){
            cbxMateria.addItem(materia.get(i));
        }
        
    }
            
            
    
    public void activarControles(boolean estado){
        txtIdentificacion.setEnabled(estado);
        txtNombre.setEnabled(estado);
        cbxMateria.setEnabled(estado);
        txtPrecio.setEnabled(estado);
        jTabla.setEnabled(!estado);
    }
    
    
    public void limpiarTxt(){
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
    } 
    
    public void registrarAction(){          
        if(btnRegistrar.getText().equals("Registrar")){  
            limpiarTxt();
            activarControles(true);
            btnEliminar.setEnabled(false);
            txtIdentificacion.setText("PV");
            btnRegistrar.setText("Guardar");
            btnRegistrar.setActionCommand("Guardar");            
            btnModificar.setText("Cancelar");
            btnModificar.setActionCommand("Cancelar");
            txtIdentificacion.requestFocusInWindow();
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
     
     
//////ACCION AL DAR EN EL BOTON MODIFICAR PARA ACTUALIZAR UN PROVEEDOR
    public void accionModificar(){
        
        if(btnModificar.getText().equals("Modificar")){
            
            if(jTabla.getSelectedRow() == -1){
                
               if(jTabla.getRowCount() == 0){
                   JOptionPane.showMessageDialog(this,"NO HAY REGISTROS");
               }
               else{
                   JOptionPane.showMessageDialog(this,"SELECCIONE UN PROVEEDOR EN LA TABLA");
               }
            }else{ 
                activarControles(true); 
                txtIdentificacion.setEnabled(false);
                btnEliminar.setEnabled(false);
                jTabla.setEnabled(false);
                
                btnRegistrar.setText("Actualizar");
                btnRegistrar.setActionCommand("Actualizar");  
                
                btnModificar.setText("Cancelar");
                btnModificar.setActionCommand("Cancelar");
                txtNombre.requestFocusInWindow();
            }
        }else{
            activarControles(false);    
            btnEliminar.setEnabled(true);
            jTabla.setEnabled(true);
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpDatosPersonales = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cbxMateria = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Recorrido", "Salario"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("[ Listado de Empleados ] ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Registro de Proveedores");

        jpDatosPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder("[ Datos personales ]"));
        jpDatosPersonales.setToolTipText("");

        jLabel6.setText("Identificacion");

        jLabel7.setText("Nombre");

        jLabel8.setText("Materia Prima");

        jLabel9.setText("Precio");

        btnRegistrar.setText("Registrar");

        btnModificar.setText("Modificar");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        cbxMateria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar..." }));

        javax.swing.GroupLayout jpDatosPersonalesLayout = new javax.swing.GroupLayout(jpDatosPersonales);
        jpDatosPersonales.setLayout(jpDatosPersonalesLayout);
        jpDatosPersonalesLayout.setHorizontalGroup(
            jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosPersonalesLayout.createSequentialGroup()
                .addGroup(jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosPersonalesLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)))
                    .addGroup(jpDatosPersonalesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 47, Short.MAX_VALUE)
                .addGroup(jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        jpDatosPersonalesLayout.setVerticalGroup(
            jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosPersonalesLayout.createSequentialGroup()
                .addGroup(jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosPersonalesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpDatosPersonalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jpDatosPersonalesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "ID Materia Prima", "Precio"
            }
        ));
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabla);

        jLabel3.setText("[ Listado de Proveedores ] ");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVolver))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(130, 130, 130))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpDatosPersonales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jpDatosPersonales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked
        // TODO add your handling code here:
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTabla.getModel();
                            
        if(jTabla.getSelectedRow()==-1){
            
            if(jTabla.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"NO HAY REGISTROS");
            }
            else{
                JOptionPane.showMessageDialog(this,"SELECCIONE UN PROVEEDOR EN LA TABLA");
            }
        }
        else {                               
            txtIdentificacion.setText(modelo.getValueAt(jTabla.getSelectedRow(), 0).toString());            
            txtNombre.setText(modelo.getValueAt(jTabla.getSelectedRow(), 1).toString());
            cbxMateria.setSelectedItem(modelo.getValueAt(jTabla.getSelectedRow(), 2).toString());    
            txtPrecio.setText(modelo.getValueAt(jTabla.getSelectedRow(), 3).toString());
        }
    }//GEN-LAST:event_jTablaMouseClicked

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
            java.util.logging.Logger.getLogger(ProveedorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProveedorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProveedorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProveedorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProveedorCRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabla;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpDatosPersonales;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
