package Ventanas;
import com.mycompany.proyectoescuela.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

public class MenuCursosProfesor extends javax.swing.JFrame {

    private Profesor docente;
    private Controlador control;
    
    public MenuCursosProfesor(Controlador control, Profesor docente) {
        this.docente = docente;
        this.control = control;
        initComponents();
        llenarTablaCursos(docente.getAsignaturasPorCurso().keySet());

    }

    public void llenarTablaCursos(Set<Curso> cursos){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaCursos.getModel();
        modelo.setRowCount(0); 

        for (Curso c : cursos) {
            modelo.addRow(new Object[]{
                c.getIdentificador(),
                c.getProfesorJefe().getNombreApellido()
            });
        }
        
         tablaCursos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               int fila = tablaCursos.getSelectedRow();
               
               if (fila != -1) {
                   Curso cursoSeleccionado = (Curso) tablaCursos.getValueAt(fila, 2);
                   control.mostrarAsignaturasProfesor(control, docente, cursoSeleccionado);
               }
            }
        });
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCursos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 48)); // NOI18N
        jLabel1.setText("Cursos");

        tablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Curso", "Profesor Jefe", "null"
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
        jScrollPane1.setViewportView(tablaCursos);
        if (tablaCursos.getColumnModel().getColumnCount() > 0) {
            tablaCursos.getColumnModel().getColumn(0).setResizable(false);
            tablaCursos.getColumnModel().getColumn(1).setResizable(false);
            tablaCursos.getColumnModel().getColumn(2).setMinWidth(0);
            tablaCursos.getColumnModel().getColumn(2).setPreferredWidth(0);
            tablaCursos.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MenuCursosProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCursosProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCursosProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCursosProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            // Crear el profesor
        Profesor prof = new Profesor(
            "12345678-9",
            "Israel González",
            "Matemáticas",
            "israel@colegio.cl",
            "+56912345678"
        );

        // Crear el curso y asignarlo como jefe
        Curso curso = new Curso(prof, "4to Medio A");
        prof.setAsignaturasPorCurso(new HashMap<>()); // aseguramos que esté limpio
        curso.setProfesorJefe(prof);

        // Agregar asignaturas al curso
        try {
            curso.agregarAsignatura("Matemáticas");
            curso.agregarAsignatura("Física");
        } catch (AsignaturaException e) {
            e.printStackTrace();
        }

        // Crear recursos digitales
        RecursoDigital recurso1 = new RecursoDigital(
            "Guía Álgebra",
            "https://recursos.edu/matematicas/algebra.pdf",
            "Ejercicios de factorización y ecuaciones"
        );

        RecursoDigital recurso2 = new RecursoDigital(
            "Simulador Movimiento",
            "https://simuladores.edu/fisica/movimiento",
            "Simula trayectorias y aceleración"
        );

        // Agregar recursos a asignaturas
        try {
            curso.agregarRecursoDigital("Matemáticas", recurso1);
            curso.agregarRecursoDigital("Física", recurso2);
        } catch (AsignaturaException e) {
            e.printStackTrace();
        }

        // Asociar asignaturas al profesor
        ArrayList<String> asignaturasDelCurso = new ArrayList<>();
        asignaturasDelCurso.add("Matemáticas");
        asignaturasDelCurso.add("Física");
        prof.getAsignaturasPorCurso().put(curso, asignaturasDelCurso);


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new MenuCursosProfesor(prof).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCursos;
    // End of variables declaration//GEN-END:variables
}
