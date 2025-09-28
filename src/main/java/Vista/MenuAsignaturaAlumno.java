package Vista;
import Modelo.RecursoDigital;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MenuAsignaturaAlumno extends javax.swing.JFrame {
    
    public MenuAsignaturaAlumno(String asignatura, ArrayList<RecursoDigital> materiales) {
        initComponents();
        tituloAsignatura.setText(asignatura);
        llenarTablaAsignaturas(materiales);
    }
    
    public void llenarTablaAsignaturas(ArrayList<RecursoDigital> materiales){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaRecursos.getModel();
        modelo.setRowCount(0); 

        for (RecursoDigital a : materiales) {
            modelo.addRow(new Object[]{
                a.getTituloMaterial(),
                a.getUrl(),
                a.getDetalles(),
                a
            });
        }


    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloAsignatura = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRecursos = new javax.swing.JTable();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloAsignatura.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        tituloAsignatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloAsignatura.setText("jLabel1");

        tablaRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Titulo", "Url", "Detalles", "null"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaRecursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRecursosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRecursos);
        if (tablaRecursos.getColumnModel().getColumnCount() > 0) {
            tablaRecursos.getColumnModel().getColumn(0).setResizable(false);
            tablaRecursos.getColumnModel().getColumn(1).setResizable(false);
            tablaRecursos.getColumnModel().getColumn(2).setResizable(false);
            tablaRecursos.getColumnModel().getColumn(3).setMinWidth(0);
            tablaRecursos.getColumnModel().getColumn(3).setPreferredWidth(0);
            tablaRecursos.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        Volver.setText("VOLVER");
        Volver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VolverMouseClicked(evt);
            }
        });
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(tituloAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloAsignatura)
                    .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_VolverMouseClicked

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void tablaRecursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRecursosMouseClicked
        if(evt.getClickCount()==2){
            int fila = tablaRecursos.getSelectedRow();
            if (fila != -1) {
                RecursoDigital recursoSeleccionado = (RecursoDigital) tablaRecursos.getValueAt(fila, 3); 
                mostrarDatosRecurso(recursoSeleccionado);
            }
        }
    }//GEN-LAST:event_tablaRecursosMouseClicked

    private void mostrarDatosRecurso(RecursoDigital recurso) {
    String mensaje = 
        "Título: " + recurso.getTituloMaterial() + "\n" +
        "URL: " + recurso.getUrl() + "\n" +
        "Detalles: " + recurso.getDetalles();

    JOptionPane.showMessageDialog(
        this,
        mensaje,
        "Detalles del Recurso Digital",
        JOptionPane.INFORMATION_MESSAGE
    );
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRecursos;
    private javax.swing.JLabel tituloAsignatura;
    // End of variables declaration//GEN-END:variables

}
