package Vista;

import Controlador.Controlador;

public class MenuLogin extends javax.swing.JFrame {
    
    private String rut;
    private Controlador control;
    
    public MenuLogin(Controlador control) {
        this.control = control;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        tituloRut = new javax.swing.JLabel();
        entradaRut = new javax.swing.JTextField();
        botonEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        Titulo.setText("INICIO DE SESION");

        tituloRut.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        tituloRut.setText("RUT");

        entradaRut.setForeground(new java.awt.Color(102, 102, 102));
        entradaRut.setText("XXXXXXXX");
        entradaRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaRutActionPerformed(evt);
            }
        });

        botonEnviar.setBackground(new java.awt.Color(0, 0, 102));
        botonEnviar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        botonEnviar.setText("ENVIAR");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(tituloRut))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entradaRut, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Titulo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(botonEnviar)))
                .addContainerGap(219, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(Titulo)
                .addGap(33, 33, 33)
                .addComponent(tituloRut, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(entradaRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(botonEnviar)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entradaRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaRutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entradaRutActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        // TODO add your handling code here:
         rut = entradaRut.getText();
         control.procesarLogin(control, rut);
         
        
    }//GEN-LAST:event_botonEnviarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JTextField entradaRut;
    private javax.swing.JLabel tituloRut;
    // End of variables declaration//GEN-END:variables
}
