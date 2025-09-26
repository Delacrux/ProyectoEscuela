package Vista;
import Modelo.AsignaturaException;
import Modelo.Curso;
import Modelo.Alumno;
import Modelo.Profesor;
import Modelo.RecursoDigital;
import Controlador.Controlador;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MenuAsignaturasProfesor extends javax.swing.JFrame {
    
    private Profesor docente;
    private Curso curso;
    private Controlador control;
    
    public MenuAsignaturasProfesor(Controlador control, Profesor docente, Curso curso) {
        this.docente = docente;
        this.control = control;
        this.curso = curso;
        initComponents();
        mostrarPanelAsignaturas();
        mostrarPanelAlumnos();
        
    }
    
    public void mostrarPanelAsignaturas(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (String a : docente.getAsignaturasEnCurso(curso)) {
            System.out.println(a);
            modelo.addElement(a);
        }

        JList<String> lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lista.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String asignatura = lista.getSelectedValue();
                ArrayList<RecursoDigital> recursos = curso.getRecursosPorAsignatura().get(asignatura);
                control.mostrarRecursosProfesor(asignatura, recursos);
            }
        });

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setPreferredSize(new Dimension(200, 150));
        panelAsignaturas.setLayout(new BorderLayout());
        panelAsignaturas.add(scroll, BorderLayout.CENTER);
        panelAsignaturas.revalidate();
        panelAsignaturas.repaint();

    }
    
    public void mostrarPanelAlumnos(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Alumno a : curso.getListaAlumnos()) {
          
            modelo.addElement(a.getNombreApellido());
        }

        JList<String> lista = new JList<>(modelo);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(lista);
        scroll.setPreferredSize(new Dimension(200, 150));
        panelAlumnos.setLayout(new BorderLayout());
        panelAlumnos.add(scroll, BorderLayout.CENTER);
        panelAlumnos.revalidate();
        panelAlumnos.repaint();

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloAsignaturas = new javax.swing.JLabel();
        panelAsignaturas = new javax.swing.JPanel();
        tituloAlumnos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelAlumnos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloAsignaturas.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        tituloAsignaturas.setText("ASIGNATURAS");

        panelAsignaturas.setForeground(new java.awt.Color(255, 255, 255));
        panelAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAsignaturasMouseClicked(evt);
            }
        });
        panelAsignaturas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelAsignaturasKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panelAsignaturasLayout = new javax.swing.GroupLayout(panelAsignaturas);
        panelAsignaturas.setLayout(panelAsignaturasLayout);
        panelAsignaturasLayout.setHorizontalGroup(
            panelAsignaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        panelAsignaturasLayout.setVerticalGroup(
            panelAsignaturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        tituloAlumnos.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        tituloAlumnos.setText("ALUMNOS");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(tituloAsignaturas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(tituloAlumnos)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloAsignaturas)
                    .addComponent(tituloAlumnos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelAsignaturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelAsignaturasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelAsignaturasKeyPressed
        
    }//GEN-LAST:event_panelAsignaturasKeyPressed

    private void panelAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAsignaturasMouseClicked

    }//GEN-LAST:event_panelAsignaturasMouseClicked

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

    public static void main(String[] args) {
    // Crear profesor
    Profesor prof = new Profesor(
        "12345678-9",
        "Israel González",
        "Matemáticas",
        "israel@colegio.cl",
        "+56912345678"
    );

    // Crear curso
    Curso curso = new Curso(prof, "4to Medio A");
    curso.setProfesorJefe(prof);

    // Agregar asignaturas
    try {
        curso.agregarAsignatura("Matemáticas");
        curso.agregarAsignatura("Física");
    } catch (AsignaturaException e) {
        e.printStackTrace();
    }

    // Agregar recursos digitales
    try {
        curso.agregarRecursoDigital("Matemáticas", new RecursoDigital(
            "Guía Álgebra",
            "https://recursos.edu/matematicas/algebra.pdf",
            "Ejercicios de factorización"
        ));
        curso.agregarRecursoDigital("Física", new RecursoDigital(
            "Simulador Movimiento",
            "https://simuladores.edu/fisica/movimiento",
            "Simula trayectorias y aceleración"
        ));
    } catch (AsignaturaException e) {
        e.printStackTrace();
    }

    // Agregar alumnos
    curso.getListaAlumnos().add(new Alumno("11111111-1", "Ana Torres", "ana@correo.cl", "+56911111111", null));
    curso.getListaAlumnos().add(new Alumno("22222222-2", "Luis Pérez", "luis@correo.cl", "+56922222222", null));

    // Asociar asignaturas al profesor
    ArrayList<String> asignaturas = new ArrayList<>();
    asignaturas.add("Matemáticas");
    asignaturas.add("Física");
    prof.getAsignaturasPorCurso().put(curso, asignaturas);

    // Crear controlador de prueba
    Controlador control = new Controlador() {
        @Override
        public void mostrarRecursosAlumno(String nombre, ArrayList<RecursoDigital> recursos) {
            System.out.println("Asignatura seleccionada: " + nombre);
            for (RecursoDigital r : recursos) {
                System.out.println("- " + r.getTituloMaterial() + " (" + r.getUrl() + ")");
            }
        }
    };

    // Lanzar ventana
    SwingUtilities.invokeLater(() -> {
        new MenuAsignaturasProfesor(control, prof, curso).setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> panelAlumnos;
    private javax.swing.JPanel panelAsignaturas;
    private javax.swing.JLabel tituloAlumnos;
    private javax.swing.JLabel tituloAsignaturas;
    // End of variables declaration//GEN-END:variables
}
