package Vista;
import Modelo.RecursoDigital;
import Controlador.Controlador;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MenuAsignaturaProfesor extends javax.swing.JFrame {
    
    private Controlador control;
    ArrayList<RecursoDigital> materiales;
    
    
    public MenuAsignaturaProfesor(Controlador control, String asignatura, ArrayList<RecursoDigital> materiales) {
        this.control = control;
        this.materiales = materiales;
        configurarVentana();
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        tituloAsignatura.setText(asignatura);
        llenarTablaAsignaturas();
    }
    
    public void llenarTablaAsignaturas(){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaRecursos.getModel();
        modelo.setRowCount(0); 

        for (RecursoDigital a : materiales) {
            modelo.addRow(new Object[]{
                a.getTituloMaterial(),
                a.getUrl(),
                a.getDetalles()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloAsignatura = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRecursos = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloAsignatura.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        tituloAsignatura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloAsignatura.setText("jLabel1");

        tablaRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Titulo", "Url", "Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        }

        botonAgregar.setBackground(new java.awt.Color(0, 102, 0));
        botonAgregar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        botonAgregar.setText("AGREGAR");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(102, 0, 0));
        botonEliminar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        botonEliminar.setText("ELIMINAR");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        Volver.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        Volver.setText("VOLVER");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(tituloAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Volver))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonEliminar)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloAsignatura)
                    .addComponent(Volver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar)
                    .addComponent(botonEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaRecursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRecursosMouseClicked

    }//GEN-LAST:event_tablaRecursosMouseClicked

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        control.mostrarMenuAgregarRecurso(this, materiales); //Acá le mostramos una ventana para que llene datos
        
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed

        int fila = tablaRecursos.getSelectedRow();

        if (fila != -1) {
            String titulo = (String) tablaRecursos.getValueAt(fila, 0);

            int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas eliminar el recurso \"" + titulo + "\"?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                RecursoDigital recursoAEliminar = null;

                for (RecursoDigital r : materiales) {
                    if (r.getTituloMaterial().equals(titulo)) {
                        recursoAEliminar = r;
                        break;
                    }

                }

                if (recursoAEliminar != null) {
                    control.eliminarRecursoDigital(recursoAEliminar, materiales); 
                    llenarTablaAsignaturas();
                }
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // bloquea cierre directo

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                    MenuAsignaturaProfesor.this, // ventana actual
                    "¿Deseas cerrar esta ventana? Se perderán los cambios no guardados.",
                    "Confirmar cierre",
                    JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    dispose(); // Cerramos
                }
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Volver;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRecursos;
    private javax.swing.JLabel tituloAsignatura;
    // End of variables declaration//GEN-END:variables

}
