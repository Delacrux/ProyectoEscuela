package Vista;
import Modelo.Curso;
import Modelo.Profesor;
import Controlador.Controlador;
import java.awt.event.*;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

public class MenuCursosProfesor extends javax.swing.JFrame {

    private Profesor docente;
    private Controlador control;
    
    public MenuCursosProfesor(Controlador control, Profesor docente) {
        this.docente = docente;
        this.control = control;
        initComponents();
        Bienvenida.setText("Bienvenido/a profesor/a " + docente.getNombreApellido());
        llenarTablaCursos(docente.getAsignaturasPorCurso().keySet());
        llenarDatosProfesor();

    }

    public void llenarTablaCursos(Set<Curso> cursos){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaCursos.getModel();
        modelo.setRowCount(0); 

        for (Curso c : cursos) {
            modelo.addRow(new Object[]{
                c.getIdentificador(),
                c.getProfesorJefe().getNombreApellido(),
                c
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

    public void llenarDatosProfesor(){
        datosProfesor.setText(docente.mostrarDatos());
        datosProfesor.setEditable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCursos = new javax.swing.JTable();
        Bienvenida = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        datosProfesor = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setText("Cursos donde imparte clases");

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

        Bienvenida.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        Bienvenida.setText("jLabel2");

        datosProfesor.setColumns(20);
        datosProfesor.setFont(new java.awt.Font("Sans Serif Collection", 0, 18)); // NOI18N
        datosProfesor.setRows(5);
        jScrollPane2.setViewportView(datosProfesor);

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setText("Datos del docente:");

        Volver.setBackground(new java.awt.Color(102, 102, 102));
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseClicked

    }//GEN-LAST:event_VolverMouseClicked

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Bienvenida;
    private javax.swing.JButton Volver;
    private javax.swing.JTextArea datosProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCursos;
    // End of variables declaration//GEN-END:variables
}
