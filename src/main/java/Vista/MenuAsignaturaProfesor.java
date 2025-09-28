package Vista;
import Modelo.RecursoDigital;
import Controlador.Controlador;
import java.awt.GridLayout;
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
        llenarTablaRecursos();
    }
    
    public void llenarTablaRecursos(){
        
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
        botonAgregar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

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

        botonAgregar.setBackground(new java.awt.Color(0, 102, 0));
        botonAgregar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregar.setText("AGREGAR");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEliminar.setBackground(new java.awt.Color(102, 0, 0));
        botonEliminar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
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

        botonEditar.setBackground(new java.awt.Color(0, 51, 102));
        botonEditar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        botonEditar.setForeground(new java.awt.Color(255, 255, 255));
        botonEditar.setText("EDITAR");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
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
                                .addComponent(botonEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonEditar)))
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
                    .addComponent(botonEliminar)
                    .addComponent(botonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void mostrarEditorRecurso(RecursoDigital recurso) {
        JTextField campoTitulo = new JTextField(recurso.getTituloMaterial());
        JTextField campoUrl = new JTextField(recurso.getUrl());
        JTextField campoDetalles = new JTextField(recurso.getDetalles());

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Título:"));
        panel.add(campoTitulo);
        panel.add(new JLabel("URL:"));
        panel.add(campoUrl);
        panel.add(new JLabel("Detalles:"));
        panel.add(campoDetalles);

        int resultado = JOptionPane.showConfirmDialog(
            this,
            panel,
            "Editar Recurso Digital",
            JOptionPane.OK_CANCEL_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (resultado == JOptionPane.OK_OPTION && !campoTitulo.getText().isBlank() && !campoUrl.getText().isBlank() 
                && !campoDetalles.getText().isBlank()) {
            recurso.setTituloMaterial(campoTitulo.getText().trim());
            recurso.setUrl(campoUrl.getText().trim());
            recurso.setDetalles(campoDetalles.getText().trim());

            llenarTablaRecursos(); // refresca la tabla
            JOptionPane.showMessageDialog(this, "Recurso actualizado correctamente.");
        }
        else{
            JOptionPane.showMessageDialog(this, "Error actualizando recurso: Espacios en blanco");
        }
    }
    
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
                    llenarTablaRecursos();
                }
            }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        int fila = tablaRecursos.getSelectedRow();
        if (fila != -1) {
            RecursoDigital recursoSeleccionado = (RecursoDigital) tablaRecursos.getValueAt(fila, 3);
            mostrarEditorRecurso(recursoSeleccionado);
        }
    }//GEN-LAST:event_botonEditarActionPerformed

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
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRecursos;
    private javax.swing.JLabel tituloAsignatura;
    // End of variables declaration//GEN-END:variables

}
