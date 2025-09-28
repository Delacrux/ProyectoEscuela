package Vista;
import Modelo.AsignaturaException;
import Modelo.Curso;
import Modelo.Alumno;
import Modelo.AlumnoException;
import Modelo.RecursoDigital;
import Controlador.Controlador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

public class MenuCursoAdmin extends javax.swing.JFrame {
    
    private Curso curso;
    private Controlador control;
    private Alumno estudiante;
    
    public MenuCursoAdmin(Controlador control, Curso curso) {
        this.control = control;
        this.curso = curso;
        configurarVentana();
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        tituloCurso.setText(curso.getIdentificador());
        mostrarEstadisticasCurso();
        mostrarPanelAsignaturas();
        mostrarPanelAlumnos();
        
    }
    
    public void mostrarEstadisticasCurso(){
        
        estadisticasCurso.setText("📊 Estadísticas del sistema:\n" +
                "Asignaturas: " + curso.getRecursosPorAsignatura().keySet().size() + "\n" +
                "Alumnos: " + curso.getListaAlumnos().size() + "\n");
        estadisticasCurso.setEditable(false); // evitar modificaciones jijija

        
    }
    
    public void mostrarPanelAsignaturas(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (String a : curso.getRecursosPorAsignatura().keySet()) {
            System.out.println(a);
            modelo.addElement(a);
        }

        listaAsignaturas.setModel(modelo);
        listaAsignaturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    
    public void mostrarPanelAlumnos(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Alumno a : curso.getListaAlumnos()) {
          
            modelo.addElement(a.getNombreApellido());
        }

        listaAlumnos.setModel(modelo);
        listaAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloAsignaturas = new javax.swing.JLabel();
        tituloAlumnos = new javax.swing.JLabel();
        botonAgregarAsig = new javax.swing.JButton();
        botonAgregarAlum = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAsignaturas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAlumnos = new javax.swing.JList<>();
        botonEliminarAsig = new javax.swing.JButton();
        botonEliminarAlum = new javax.swing.JButton();
        tituloCurso = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        estadisticasCurso = new javax.swing.JTextArea();
        tituloAlumnos1 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloAsignaturas.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tituloAsignaturas.setText("ASIGNATURAS");

        tituloAlumnos.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tituloAlumnos.setText("Estadísticas Curso:");

        botonAgregarAsig.setBackground(new java.awt.Color(0, 102, 0));
        botonAgregarAsig.setText("Agregar");
        botonAgregarAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarAsigActionPerformed(evt);
            }
        });

        botonAgregarAlum.setBackground(new java.awt.Color(0, 102, 0));
        botonAgregarAlum.setText("Agregar");
        botonAgregarAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarAlumActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(listaAsignaturas);

        listaAlumnos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaAlumnos);

        botonEliminarAsig.setBackground(new java.awt.Color(102, 0, 0));
        botonEliminarAsig.setText("Eliminar");
        botonEliminarAsig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarAsigActionPerformed(evt);
            }
        });

        botonEliminarAlum.setBackground(new java.awt.Color(102, 0, 0));
        botonEliminarAlum.setText("Eliminar");
        botonEliminarAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarAlumActionPerformed(evt);
            }
        });

        tituloCurso.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        tituloCurso.setText("jLabel1");

        estadisticasCurso.setColumns(20);
        estadisticasCurso.setFont(new java.awt.Font("Sans Serif Collection", 0, 18)); // NOI18N
        estadisticasCurso.setRows(5);
        jScrollPane3.setViewportView(estadisticasCurso);

        tituloAlumnos1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tituloAlumnos1.setText("ALUMNOS");

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
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tituloAlumnos1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonAgregarAsig)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonEliminarAsig))
                                    .addComponent(tituloAsignaturas)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(botonAgregarAlum)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(botonEliminarAlum)))
                                .addGap(0, 248, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tituloAlumnos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(tituloAlumnos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloAlumnos1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAgregarAlum)
                            .addComponent(botonEliminarAlum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tituloAsignaturas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonAgregarAsig)
                            .addComponent(botonEliminarAsig))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarAsigActionPerformed
        JTextField campoAsignatura = new JTextField();

        int resultado = JOptionPane.showConfirmDialog(
            this,
            campoAsignatura,
            "Ingrese el nombre de la asignatura",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (resultado == JOptionPane.OK_OPTION) {
            String nuevaAsignatura = campoAsignatura.getText();
            try{
                curso.agregarAsignatura(nuevaAsignatura);
            }
            catch(AsignaturaException e){
                JOptionPane.showMessageDialog(this, "Error al agregar asignatura: " + e);
            }

        }
        mostrarEstadisticasCurso();
        mostrarPanelAsignaturas();
    }//GEN-LAST:event_botonAgregarAsigActionPerformed

    private void botonAgregarAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarAlumActionPerformed
        JTextField nombre = new JTextField();
        JTextField rut = new JTextField();
        JTextField correo = new JTextField();
        JTextField telefono = new JTextField();
        
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nombre del Alumno:"));
        panel.add(nombre);
        panel.add(new JLabel("Rut del Alumno:"));
        panel.add(rut);
        panel.add(new JLabel("Correo del Alumno:"));
        panel.add(correo);
        panel.add(new JLabel("Numero de telefono del Alumno:"));
        panel.add(telefono);
        
        int resultado = JOptionPane.showConfirmDialog(
            this,
            panel,
            "Agregar nuevo Alumno",
            JOptionPane.OK_CANCEL_OPTION
        );

        if (resultado == JOptionPane.OK_OPTION) {
            String nombreAlumno = nombre.getText();
            String rutAlumno = rut.getText();
            String correoAlumno = correo.getText();
            String telefonoAlumno = telefono.getText();
            estudiante = new Alumno(rutAlumno, nombreAlumno, correoAlumno, telefonoAlumno, curso);
        }
        
        try{
            curso.agregarAlumno(estudiante);
            
        }catch(AlumnoException e){
            JOptionPane.showMessageDialog(this, "Error al agregar alumno: " + e);
        }
        
        mostrarEstadisticasCurso();
        mostrarPanelAlumnos();

    }//GEN-LAST:event_botonAgregarAlumActionPerformed

    private void listaAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAsignaturasMouseClicked
        if(evt.getClickCount()==2){
                String asignatura = listaAsignaturas.getSelectedValue();
                ArrayList<RecursoDigital> recursos = curso.getRecursosPorAsignatura().get(asignatura);
                control.mostrarRecursosProfesor(asignatura, recursos);
            }
    }//GEN-LAST:event_listaAsignaturasMouseClicked

    private void botonEliminarAsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarAsigActionPerformed
        
        String asignatura = listaAsignaturas.getSelectedValue();
        
        try{
            curso.eliminarAsignatura(asignatura);
            control.eliminarAsignaturaDeProfesores(asignatura);
        }catch(AsignaturaException e){
            JOptionPane.showMessageDialog(this, "Error al eliminar Asignatura: " + e);
        }
        
        mostrarEstadisticasCurso();
        mostrarPanelAsignaturas();
    }//GEN-LAST:event_botonEliminarAsigActionPerformed

    private void botonEliminarAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarAlumActionPerformed
        
        String nombre = listaAlumnos.getSelectedValue();
        ArrayList<Alumno> lista = curso.getListaAlumnos();
        Alumno alumno = null;
        for(Alumno a : lista){
            if(a.getNombreApellido().equals(nombre)){
                alumno = a;
                break;
            }
        }
            
        try{
            curso.eliminarAlumno(alumno);
            AlumnoException error = control.eliminarAlumno(alumno);
            if(error!=null){
                JOptionPane.showMessageDialog(this, "Error al eliminar Alumno: " + error);
            }
        }catch(AlumnoException e){
            JOptionPane.showMessageDialog(this, "Error al eliminar Alumno: " + e);
        }
        
        mostrarEstadisticasCurso();
        mostrarPanelAlumnos();
    }//GEN-LAST:event_botonEliminarAlumActionPerformed

    private void listaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaAlumnosMouseClicked
        
        String nombre = listaAlumnos.getSelectedValue();
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
    }//GEN-LAST:event_listaAlumnosMouseClicked

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void VolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_VolverMouseClicked
  
    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // bloquea cierre directo

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                    MenuCursoAdmin.this, // ventana actual
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
    private javax.swing.JButton botonAgregarAlum;
    private javax.swing.JButton botonAgregarAsig;
    private javax.swing.JButton botonEliminarAlum;
    private javax.swing.JButton botonEliminarAsig;
    private javax.swing.JTextArea estadisticasCurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaAlumnos;
    private javax.swing.JList<String> listaAsignaturas;
    private javax.swing.JLabel tituloAlumnos;
    private javax.swing.JLabel tituloAlumnos1;
    private javax.swing.JLabel tituloAsignaturas;
    private javax.swing.JLabel tituloCurso;
    // End of variables declaration//GEN-END:variables
}
