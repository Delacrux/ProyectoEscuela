package Ventanas;
import com.mycompany.proyectoescuela.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MenuRecursosProfesor extends javax.swing.JFrame {
    
    private Controlador control;
    ArrayList<RecursoDigital> materiales;
    
    
    public MenuRecursosProfesor(Controlador control, String asignatura, ArrayList<RecursoDigital> materiales) {
        this.control = control;
        this.materiales = materiales;
        initComponents();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        opcionAgregar = new javax.swing.JMenu();

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

        opcionAgregar.setText("Agregar");
        opcionAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcionAgregarMouseClicked(evt);
            }
        });
        jMenuBar1.add(opcionAgregar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(tituloAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloAsignatura)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcionAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAgregarMouseClicked
        control.mostrarMenuAgregarRecurso(this, materiales); //Acá le mostramos una ventana para que llene datos
        
    }//GEN-LAST:event_opcionAgregarMouseClicked

    private void tablaRecursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRecursosMouseClicked
        if (evt.getClickCount() == 2) {    //Hacemos que con 2 clicks le salga la opcion de eliminar un recurso a lo dog
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
                        materiales.remove(recursoAEliminar);
                        control.eliminarRecursoDigital(recursoAEliminar, materiales); 
                        llenarTablaAsignaturas();
                    }
                }
            }
        }

    }//GEN-LAST:event_tablaRecursosMouseClicked

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
            java.util.logging.Logger.getLogger(MenuRecursosProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuRecursosProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuRecursosProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuRecursosProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArrayList<RecursoDigital> recursos = new ArrayList<>();

                recursos.add(new RecursoDigital(
                    "Guía de Estudio Matemáticas",
                    "https://recursos.edu/matematicas/guia1.pdf",
                    "Contiene ejercicios de álgebra y geometría"
                ));

                recursos.add(new RecursoDigital(
                    "Video Historia Universal",
                    "https://youtube.com/watch?v=abc123",
                    "Resumen visual de la Segunda Guerra Mundial"
                ));

                recursos.add(new RecursoDigital(
                    "Simulador Física",
                    "https://simuladores.edu/fisica/movimiento",
                    "Simula trayectorias y aceleración en tiempo real"
                ));

                //new MenuRecursosProfesor("Matemática", recursos).setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu opcionAgregar;
    private javax.swing.JTable tablaRecursos;
    private javax.swing.JLabel tituloAsignatura;
    // End of variables declaration//GEN-END:variables

}
