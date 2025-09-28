package Vista;

import Controlador.Controlador;
import Modelo.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;


public class MenuAdmin extends javax.swing.JFrame {

    private Controlador control;
    private ArrayList<Curso> listaDeCursos;
    private ArrayList<Profesor> listaDeProfesores;
    
    public MenuAdmin(Controlador control, ArrayList<Curso> listaDeCursos, ArrayList<Profesor> listaDeProfesores) {
        this.control = control;
        this.listaDeCursos = listaDeCursos;
        this.listaDeProfesores = listaDeProfesores;
        configurarVentana();
        initComponents();
        llenarListaCursos();
        llenarTablaProfesores();
        llenarEstadisticas();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCursos = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProfesores = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoEstadisticas = new javax.swing.JTextPane();
        botonEliminar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Profesores");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SISTEMA");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cursos");

        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        listaCursos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaCursosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaCursos);

        tablaProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Especialidad", "Title 3"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        tablaProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProfesoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaProfesores);
        if (tablaProfesores.getColumnModel().getColumnCount() > 0) {
            tablaProfesores.getColumnModel().getColumn(0).setResizable(false);
            tablaProfesores.getColumnModel().getColumn(1).setResizable(false);
            tablaProfesores.getColumnModel().getColumn(2).setMinWidth(0);
            tablaProfesores.getColumnModel().getColumn(2).setPreferredWidth(0);
            tablaProfesores.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        botonAgregar.setBackground(new java.awt.Color(0, 102, 0));
        botonAgregar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregar.setText("AGREGAR");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("📊 Estadísticas del sistema");

        jScrollPane2.setViewportView(textoEstadisticas);

        botonEliminar.setBackground(new java.awt.Color(102, 0, 0));
        botonEliminar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("ELIMINAR");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        botonGuardar.setText("GUARDAR");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(315, 315, 315))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonAgregar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonEliminar))
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAgregar)
                            .addComponent(botonEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaCursosMouseClicked
        control.mostrarAsignaturasAdmin((String)listaCursos.getSelectedValue());
    }//GEN-LAST:event_listaCursosMouseClicked

    private void llenarEstadisticas(){
        textoEstadisticas.setText(control.estadisticasSistema());
    }
    
    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        control.mostrarAgregarProfesor(listaDeCursos, this);
    }//GEN-LAST:event_botonAgregarActionPerformed
    
    //Clickear tabla profesores
    private void tablaProfesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProfesoresMouseClicked
            if (evt.getClickCount() == 2) {    //Hacemos que con 2 clicks pueda ver los datos del profesor
                int fila = tablaProfesores.getSelectedRow();
            
                if (fila != -1) {
                    Profesor seleccionado = (Profesor)tablaProfesores.getValueAt(fila, 2); 
                    JOptionPane.showMessageDialog(null, seleccionado.mostrarDatos(), "Datos de Profesor:\n", JOptionPane.PLAIN_MESSAGE);

                }
            }
    }//GEN-LAST:event_tablaProfesoresMouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        int fila = tablaProfesores.getSelectedRow();
            
        if (fila != -1) {
            String nombre = (String) tablaProfesores.getValueAt(fila, 0);

            int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Deseas eliminar al profesor \"" + nombre + "\"?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
                );

             if (confirmacion == JOptionPane.YES_OPTION) {
                Profesor profesorAEliminar = (Profesor)tablaProfesores.getValueAt(fila, 2);

                if (profesorAEliminar != null) {
                    control.eliminarProfesor(profesorAEliminar); 
                    llenarTablaProfesores();
                    llenarEstadisticas();
                }
             }
        }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(
            this,
            "¿Deseas guardar los cambios realizados?",
            "Confirmar guardado",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (opcion == JOptionPane.YES_OPTION) {
            control.guardarDatos(); // guardado directo
            JOptionPane.showMessageDialog(
                this,
                "Los datos han sido guardados correctamente.",
                "Guardado exitoso",
                JOptionPane.INFORMATION_MESSAGE
            );
            llenarEstadisticas();
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    public void llenarListaCursos(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        
        for (Curso c : listaDeCursos) {
            modelo.addElement(c.getIdentificador()); //  conseguimos ID
        }

        listaCursos.setModel(modelo);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    
    public void llenarTablaProfesores(){
         DefaultTableModel modelo = (DefaultTableModel) tablaProfesores.getModel();
         modelo.setRowCount(0);
         
         
         
         for (Profesor p : listaDeProfesores) {
             modelo.addRow(new Object[]{
                 p.getNombreApellido(),
                 p.getEspecialidad(),
                 p
             });
        }

        
    }
    
    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //No sale directamente

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                    MenuAdmin.this,
                    "Cerrando ventana, quieres guardar los datos?",
                    "Confirmar guardado",
                    JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    control.guardarDatos(); // guardamos
                }
                dispose(); // cerrar la ventana
                control.generarReporte();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaCursos;
    private javax.swing.JTable tablaProfesores;
    private javax.swing.JTextPane textoEstadisticas;
    // End of variables declaration//GEN-END:variables
}
