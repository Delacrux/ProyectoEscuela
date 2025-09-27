package Vista;
import Modelo.Curso;
import Modelo.Alumno;
import Modelo.Profesor;
import Modelo.RecursoDigital;
import Controlador.Controlador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.util.*;

public class MenuCursoProfesor extends javax.swing.JFrame {
    
    private Profesor docente;
    private Curso curso;
    private Controlador control;
    
    public MenuCursoProfesor(Controlador control, Profesor docente, Curso curso) {
        this.docente = docente;
        this.control = control;
        this.curso = curso;
        configurarVentana();
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        tituloCurso.setText(curso.getIdentificador());
        mostrarListaAsignaturas();
        mostrarPanelAlumnos();
        
    }
    
    public void mostrarListaAsignaturas(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (String a : docente.getAsignaturasEnCurso(curso)) {
            System.out.println(a);
            modelo.addElement(a);
        }

        listaAsignaturas.setModel(modelo);
        listaAsignaturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listaAsignaturas.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String asignatura = listaAsignaturas.getSelectedValue();
                ArrayList<RecursoDigital> recursos = curso.getRecursosPorAsignatura().get(asignatura);
                control.mostrarRecursosProfesor(asignatura, recursos);
            }
        });
    }
    
    public void mostrarPanelAlumnos(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Alumno a : curso.getListaAlumnos()) {
          
            modelo.addElement(a.getNombreApellido());
        }

        panelAlumnos.setModel(modelo);
        panelAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    
    public void mostrarDatosCurso(){
        datosCurso.setText("📊 Estadísticas del sistema:\n" +
                "Asignaturas: " + docente.getAsignaturasEnCurso(curso) + "\n" +
                "Alumnos: " + curso.getListaAlumnos().size() + "\n");
        datosCurso.setEditable(false); // evitar modificaciones jijija
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloAsignaturas = new javax.swing.JLabel();
        tituloAlumnos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelAlumnos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAsignaturas = new javax.swing.JList<>();
        tituloCurso = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        datosCurso = new javax.swing.JTextArea();
        tituloAlumnos1 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloAsignaturas.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tituloAsignaturas.setText("Asignaturas que imparte:");

        tituloAlumnos.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tituloAlumnos.setText("Alumnos en curso:");

        panelAlumnos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        panelAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(panelAlumnos);

        listaAsignaturas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaAsignaturasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaAsignaturas);

        tituloCurso.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        tituloCurso.setText("jLabel1");

        datosCurso.setColumns(20);
        datosCurso.setRows(5);
        jScrollPane3.setViewportView(datosCurso);

        tituloAlumnos1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tituloAlumnos1.setText("Datos de Curso:");

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
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloAlumnos1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloAsignaturas)
                            .addComponent(tituloAlumnos)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloAlumnos)
                    .addComponent(tituloAlumnos1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(tituloAsignaturas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAlumnosMouseClicked
        String nombre = panelAlumnos.getSelectedValue();
        ArrayList<Alumno> lista = curso.getListaAlumnos();
        Alumno alumno = null;
        for(Alumno a : lista){
            if(a.getNombreApellido().equals(nombre)){
                alumno = a;
                break;
            }
        }
        
        if(evt.getClickCount()==2){
            JOptionPane.showMessageDialog(this, alumno.mostrarDatos(), "Datos del Alumno", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_panelAlumnosMouseClicked

    private void listaAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAsignaturasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listaAsignaturasMouseClicked

    private void VolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_VolverMouseClicked

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // bloquea cierre directo

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                    MenuCursoProfesor.this, // ventana actual
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
    private javax.swing.JTextArea datosCurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaAsignaturas;
    private javax.swing.JList<String> panelAlumnos;
    private javax.swing.JLabel tituloAlumnos;
    private javax.swing.JLabel tituloAlumnos1;
    private javax.swing.JLabel tituloAsignaturas;
    private javax.swing.JLabel tituloCurso;
    // End of variables declaration//GEN-END:variables
}
