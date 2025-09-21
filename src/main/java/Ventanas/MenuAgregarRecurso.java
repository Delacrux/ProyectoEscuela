package Ventanas;

import com.mycompany.proyectoescuela.*;
import java.util.*;

public class MenuAgregarRecurso extends javax.swing.JFrame {
    
    private Controlador control;
    private ArrayList<RecursoDigital> materiales;
    MenuRecursosProfesor padre;
    
    public MenuAgregarRecurso(MenuRecursosProfesor padre, Controlador control, ArrayList<RecursoDigital> materiales) {
        this.control = control;
        this.materiales = materiales;
        this.padre = padre;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entradaTitulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        entradaUrl = new javax.swing.JTextField();
        entradaDetalles = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        entradaTitulo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        entradaTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaTituloActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        jLabel1.setText("Url");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        jLabel2.setText("Detalles");

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        jLabel3.setText("Titulo");

        entradaUrl.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        entradaUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaUrlActionPerformed(evt);
            }
        });

        entradaDetalles.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        entradaDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaDetallesActionPerformed(evt);
            }
        });

        botonAgregar.setBackground(new java.awt.Color(102, 0, 102));
        botonAgregar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregar.setText("AGREGAR");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(286, 286, 286))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entradaDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entradaUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entradaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entradaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entradaUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entradaDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botonAgregar)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaTituloActionPerformed

    private void entradaUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaUrlActionPerformed

    private void entradaDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaDetallesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaDetallesActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        String detalles = entradaDetalles.getText();
        String titulo = entradaTitulo.getText();
        String url = entradaUrl.getText();
        
        if(!detalles.isEmpty() && !titulo.isEmpty() && !url.isEmpty()){
            RecursoDigital recurso = new RecursoDigital(titulo, url, detalles);
            control.agregarRecursoDigital(recurso, materiales);
            padre.llenarTablaAsignaturas(materiales);
            this.dispose();
        }
    }//GEN-LAST:event_botonAgregarActionPerformed


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
            java.util.logging.Logger.getLogger(MenuAgregarRecurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAgregarRecurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAgregarRecurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAgregarRecurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenuAgregarRecurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonAgregar;
    private javax.swing.JTextField entradaDetalles;
    private javax.swing.JTextField entradaTitulo;
    private javax.swing.JTextField entradaUrl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
