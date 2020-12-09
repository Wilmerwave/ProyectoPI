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
import modelo.Producto;

/**
 *
 * @author PuntoPC
 */
public class InventarioProductosGUI extends javax.swing.JFrame {

    /**
     * Creates new form InventarioPT
     */
    public InventarioProductosGUI() {
        initComponents();
        activarControles(false);
    }
    
    
////////////////////////GETTERS DE TEXTFIELD
    
    //ID
    public String getID(){
        return txtID.getText().trim();
    }
    
    //NOMBRE
    public String getNombre(){
        return txtNombre.getText();
    }
    
    //CANTIDAD X6
    public String getCantidad6Txt(){
        return txtCantidad6.getText();
    }
    
    public int getCantidad6Num(){
        return Integer.parseInt(txtCantidad6.getText());
    }
    
    //CANTIDAD X12
    public String getCantidad12Txt(){
        return txtCantidad12.getText();
    }
    
    public int getCantidad12Num(){
        return Integer.parseInt(txtCantidad12.getText());
    }
    
    //PRECIO X6
    public String getPrecio6Txt(){
        return txtPrecio6.getText();
    }
    
    public int getPrecio6Num(){
        return Integer.parseInt(txtPrecio6.getText());
    }
    
    //PRECIO X12
    public String getPrecio12Txt(){
        return txtPrecio12.getText();
    }
    
    public int getPrecio12Num(){
        return Integer.parseInt(txtPrecio12.getText());
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
        modelo = (DefaultTableModel) jTablaProductos.getModel();
        for(int i=modelo.getRowCount()-1; i>=0 ; i--){
            modelo.removeRow(i);
        }
    }
    
    
    
////////////////CARGA LOS DATOS DE LOS PRODUCTOS EN LA TABLA
    public void cargarProductos(ArrayList<Producto> listado){
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTablaProductos.getModel();        
        limpiarTabla();
        for(int i= 0; i < listado.size(); i++){
              modelo.addRow(
                      new Object[]{
              listado.get(i).getId(),
              listado.get(i).getNombre(),
              listado.get(i).getCantidadX6(),
              listado.get(i).getCantidadX12(),
              listado.get(i).getPreciox6(),
              listado.get(i).getPreciox12()
                      });
        }
    }
    

//////////////////ACTIVA Y DESACTIVA LOS TEXTFIELD    
    public void activarControles(boolean estado){
        txtID.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtCantidad6.setEnabled(estado);
        txtCantidad12.setEnabled(estado);
        txtPrecio6.setEnabled(estado);
        txtPrecio12.setEnabled(estado);
    }
    
    
//////////////////ACTIVA Y DESACTIVA LA TABLA  
    public void activarTabla(boolean estado){
        jTablaProductos.setEnabled(!estado);
    }
    
    
////////////////DESACTIVAR LOS BOTONES
    public void desactivaBotones(){
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    
////////////////LIMPIA LOS TEXTFIELD
    public void limpiarTxt(){
        txtID.setText("");
        txtNombre.setText("");
        txtCantidad6.setText("");
        txtCantidad12.setText("");
        txtPrecio6.setText("");
        txtPrecio12.setText("");
    }
    
    
/////ACCION AL DAR EN EL BOTON DE REGISTRAR PARA INSERTAR UN NUEVO PRODUCTO    
    public void accionRegistrar(){  
        
        if(btnRegistrar.getText().equals("Registrar")){  
            limpiarTxt();
            activarControles(true);
            jTablaProductos.setEnabled(false);
            btnEliminar.setEnabled(false);
            txtID.setText("P");
            
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
            jTablaProductos.setEnabled(true);
            
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
            
            if(jTablaProductos.getSelectedRow() == -1){
                
               if(jTablaProductos.getRowCount() == 0){
                   JOptionPane.showMessageDialog(this,"NO HAY REGISTROS");
               }
               else{
                   JOptionPane.showMessageDialog(this,"SELECCIONE UN PRODUCTO EN EL INVENTARIO");
               }
            }else{ 
                activarControles(true); 
                txtID.setEnabled(false);
                btnEliminar.setEnabled(false);
                jTablaProductos.setEnabled(false);
                
                btnRegistrar.setText("Actualizar");
                btnRegistrar.setActionCommand("Actualizar");  
                
                btnModificar.setText("Cancelar");
                btnModificar.setActionCommand("Cancelar");
                txtNombre.requestFocusInWindow();
            }
        }else{
            activarControles(false);    
            btnEliminar.setEnabled(true);
            jTablaProductos.setEnabled(true);
            
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaProductos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad6 = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCantidad12 = new javax.swing.JTextField();
        txtPrecio12 = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Inventario Productos Terminados");

        jTablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Codigo", "Paquete x6", "Paquete x12", "Precio x6", "Precio x12"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTablaProductos);

        btnVolver.setBackground(new java.awt.Color(0, 102, 255));
        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/volver.PNG"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setText("[ Registro Producto Terminado ]");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("ID Producto:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Cantidad x6:");

        btnEliminar.setText("Eliminar");

        btnModificar.setText("Modificar");

        jLabel6.setText("Precio x6:");

        jLabel7.setText("Precio x12:");

        jLabel8.setText("Cantidad x12:");

        btnRegistrar.setText("Registrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(149, 149, 149))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrecio6, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(txtCantidad6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrecio12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCantidad12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCantidad12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtPrecio12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegistrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnVolver))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        //remove(this);
        setVisible(false);
        MenuGUI menu =new MenuGUI();
        menu.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jTablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaProductosMouseClicked

        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jTablaProductos.getModel();
                            
        if(jTablaProductos.getSelectedRow()==-1){
            
            if(jTablaProductos.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"NO HAY REGISTROS");
            }
            else{
                JOptionPane.showMessageDialog(this,"SELECCIONE UN PRODUCTO DEL INVENTARIO");
            }
        }
        else {                               
            txtID.setText(modelo.getValueAt(jTablaProductos.getSelectedRow(), 0).toString());            
            txtNombre.setText(modelo.getValueAt(jTablaProductos.getSelectedRow(), 1).toString());
            txtCantidad6.setText(modelo.getValueAt(jTablaProductos.getSelectedRow(), 2).toString());  
            txtCantidad12.setText(modelo.getValueAt( jTablaProductos.getSelectedRow(), 3).toString());
            txtPrecio6.setText(modelo.getValueAt( jTablaProductos.getSelectedRow(), 4).toString());
            txtPrecio12.setText(modelo.getValueAt( jTablaProductos.getSelectedRow(), 5).toString());
        }
        
    }//GEN-LAST:event_jTablaProductosMouseClicked

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
            java.util.logging.Logger.getLogger(InventarioProductosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioProductosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioProductosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioProductosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarioProductosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaProductos;
    private javax.swing.JTextField txtCantidad12;
    private javax.swing.JTextField txtCantidad6;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio12;
    private javax.swing.JTextField txtPrecio6;
    // End of variables declaration//GEN-END:variables
}
