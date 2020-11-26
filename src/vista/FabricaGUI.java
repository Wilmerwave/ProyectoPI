/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author PuntoPC
 */
public class FabricaGUI extends javax.swing.JFrame {

    /**
     * Creates new form Fabrica
     */
    public FabricaGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        iniciarProduccion = new javax.swing.JButton();
        inventarioMP = new javax.swing.JButton();
        inventarioPT = new javax.swing.JButton();
        btnVolver1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Menú Fabrica");

        iniciarProduccion.setText("Iniciar Producción");

        inventarioMP.setText("Inventario Materia Prima");
        inventarioMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioMPActionPerformed(evt);
            }
        });

        inventarioPT.setText("Inventario Productos");
        inventarioPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioPTActionPerformed(evt);
            }
        });

        btnVolver1.setBackground(new java.awt.Color(0, 102, 255));
        btnVolver1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnVolver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/volver.PNG"))); // NOI18N
        btnVolver1.setText("Volver Menú Principal");
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inventarioMP)
                    .addComponent(inventarioPT)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iniciarProduccion)
                            .addComponent(jLabel1))))
                .addContainerGap(233, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVolver1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addComponent(iniciarProduccion)
                .addGap(60, 60, 60)
                .addComponent(inventarioMP)
                .addGap(45, 45, 45)
                .addComponent(inventarioPT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(btnVolver1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inventarioMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioMPActionPerformed
        setVisible(false);
        InventarioMateriaGUI inv = new InventarioMateriaGUI();
        inv.setVisible(true);
    }//GEN-LAST:event_inventarioMPActionPerformed

    private void inventarioPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioPTActionPerformed
        setVisible(false);
        InventarioProductosGUI inv = new InventarioProductosGUI();
        inv.setVisible(true);
    }//GEN-LAST:event_inventarioPTActionPerformed

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        setVisible(false);
        MenuGUI principal =new MenuGUI();
        principal.setVisible(true);
    }//GEN-LAST:event_btnVolver1ActionPerformed

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
            java.util.logging.Logger.getLogger(FabricaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FabricaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FabricaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FabricaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FabricaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver1;
    private javax.swing.JButton iniciarProduccion;
    private javax.swing.JButton inventarioMP;
    private javax.swing.JButton inventarioPT;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
