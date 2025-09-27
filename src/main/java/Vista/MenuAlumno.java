package Vista;
import Modelo.*;
import Modelo.RecursoDigital;
import Controlador.Controlador;
import javax.swing.*;
import java.util.*;

public class MenuAlumno extends javax.swing.JFrame {
    
    private Alumno estudiante;
    private Controlador control;
    
    public MenuAlumno(Controlador control, Alumno estudiante) {
        this.estudiante = estudiante;
        this.control = control;
        bienvenida.setText("Bienvenido/a " + estudiante.getNombreApellido());
        initComponents();
        mostrarPanelAsignaturas();
        
    }
    
    public void mostrarPanelAsignaturas(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (String a : estudiante.getCurso().getRecursosPorAsignatura().keySet()) {
            modelo.addElement(a);
        }

        listaAsignaturas.setModel(modelo);
        listaAsignaturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        listaAsignaturas.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String index = listaAsignaturas.getSelectedValue();
                ArrayList<RecursoDigital> recursos = estudiante.getCurso().getRecursosPorAsignatura().get(index);
                control.mostrarRecursosAlumno(index, recursos);
            }
        });

    }
    
    public void mostrarDatosAlumno(){
        datosAlumno.setText( ((Persona)estudiante).mostrarDatos() );
        datosAlumno.setEditable(false); // para que no se pueda modificar

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloAsignaturas = new javax.swing.JLabel();
        bienvenida = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAsignaturas = new javax.swing.JList<>();
        tituloDatos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        datosAlumno = new javax.swing.JTextArea();
        tituloCurso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloAsignaturas.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tituloAsignaturas.setText("Asignaturas:");

        bienvenida.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        bienvenida.setText("jLabel1");

        listaAsignaturas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaAsignaturas);

        tituloDatos.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tituloDatos.setText("Datos Alumno:");

        datosAlumno.setColumns(20);
        datosAlumno.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        datosAlumno.setRows(5);
        jScrollPane2.setViewportView(datosAlumno);

        tituloCurso.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        tituloCurso.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tituloDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 37, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloAsignaturas)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bienvenida)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(tituloAsignaturas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tituloCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tituloDatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenida;
    private javax.swing.JTextArea datosAlumno;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaAsignaturas;
    private javax.swing.JLabel tituloAsignaturas;
    private javax.swing.JLabel tituloCurso;
    private javax.swing.JLabel tituloDatos;
    // End of variables declaration//GEN-END:variables
}
