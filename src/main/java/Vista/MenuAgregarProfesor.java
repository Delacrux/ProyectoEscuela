package Vista;

import Modelo.Curso;
import Modelo.Profesor;
import Controlador.Controlador;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MenuAgregarProfesor extends javax.swing.JFrame {
    
    private String rut;
    private String nombre;
    private String telefono;
    private String correo;
    private String especialidad;
    private Controlador control;
    private ArrayList<Curso> listaDeCursos;
    private Curso cursoSeleccionado;
    
    
    public MenuAgregarProfesor(Controlador control, ArrayList<Curso> listaDeCursos) {
        this.control = control;
        this.listaDeCursos = listaDeCursos;
        configurarVentana();
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        llenarTablaCursos();
        llenarListaAsignaturas();
        
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        entradaRut = new javax.swing.JTextField();
        entradaNombre = new javax.swing.JTextField();
        entradaCorreo = new javax.swing.JTextField();
        entradaTelefono = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        entradaEspecialidad = new javax.swing.JTextField();
        panelListas = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAsignaturas = new javax.swing.JList<>();
        botonFinalizar = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCursos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setText("RUT");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setText("NOMBRE");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel4.setText("CORREO");

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setText("TELEFONO");

        entradaRut.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        entradaNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        entradaCorreo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        entradaTelefono.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        botonGuardar.setBackground(new java.awt.Color(102, 0, 102));
        botonGuardar.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setText("GUARDAR");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel6.setText("ESPECIALIDAD");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel1.setText("Datos Profesor");

        entradaEspecialidad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel3))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel2))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entradaRut, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entradaCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entradaEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entradaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entradaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel5))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel4)))
                .addContainerGap(204, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addComponent(botonGuardar)
                        .addGap(279, 279, 279))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(261, 261, 261))))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entradaRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entradaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entradaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entradaCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entradaEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(botonGuardar)
                .addGap(30, 30, 30))
        );

        jPanel1.add(panelDatos, "card2");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel7.setText("¿En qué curso impartirá clases?");

        listaAsignaturas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaAsignaturas);

        botonFinalizar.setBackground(new java.awt.Color(102, 0, 102));
        botonFinalizar.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        botonFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        botonFinalizar.setText("FINALIZAR");
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });

        tablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Curso", "Curso"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaCursos);
        if (tablaCursos.getColumnModel().getColumnCount() > 0) {
            tablaCursos.getColumnModel().getColumn(0).setResizable(false);
            tablaCursos.getColumnModel().getColumn(1).setMinWidth(0);
            tablaCursos.getColumnModel().getColumn(1).setPreferredWidth(0);
            tablaCursos.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel8.setText("Asignaturas");

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel9.setText("Cursos");

        javax.swing.GroupLayout panelListasLayout = new javax.swing.GroupLayout(panelListas);
        panelListas.setLayout(panelListasLayout);
        panelListasLayout.setHorizontalGroup(
            panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonFinalizar)
                        .addGap(235, 235, 235))
                    .addGroup(panelListasLayout.createSequentialGroup()
                        .addGroup(panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addContainerGap(168, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListasLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        panelListasLayout.setVerticalGroup(
            panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelListasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        jPanel1.add(panelListas, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenarTablaCursos(){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaCursos.getModel();
        modelo.setRowCount(0); 

        for (Curso c : listaDeCursos) {
            modelo.addRow(new Object[]{
                c.getIdentificador(),
                c
            });
        }
         
    }
    
    public void llenarListaAsignaturas(){
        
         tablaCursos.addMouseListener(new MouseAdapter() {
             @Override
            public void mouseClicked(MouseEvent e) {
               int fila = tablaCursos.getSelectedRow();
               
               if (fila != -1) {
                   cursoSeleccionado = (Curso) tablaCursos.getValueAt(fila, 1);
                   
                   ArrayList<String> asignaturas = control.asignaturasDisponibles(cursoSeleccionado);

                   DefaultListModel<String> modelo = new DefaultListModel<>();
                   for (String a : asignaturas) {
                    modelo.addElement(a);
                   }

                listaAsignaturas.setModel(modelo);
                listaAsignaturas.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

               }
            }
        });
    }
    
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        rut = entradaRut.getText();
        nombre = entradaNombre.getText();
        telefono = entradaTelefono.getText();
        correo = entradaCorreo.getText();
        especialidad = entradaEspecialidad.getText();
        CardLayout layoutTarjetas = (CardLayout) jPanel1.getLayout();
        layoutTarjetas.next(jPanel1);
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarActionPerformed
        
         ArrayList<String> seleccionadas = new ArrayList(listaAsignaturas.getSelectedValuesList());
         
         if (seleccionadas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar al menos una asignatura.");
            return;
        }

         Profesor nuevoProfe = new Profesor(rut, nombre, especialidad, correo, telefono);
         HashMap<Curso, ArrayList<String>> asignaturasCurso = new HashMap<>();
        
         asignaturasCurso.put(cursoSeleccionado, seleccionadas);
         nuevoProfe.setAsignaturasPorCurso(asignaturasCurso);
         control.agregarProfesor(nuevoProfe);
         this.dispose();
    }//GEN-LAST:event_botonFinalizarActionPerformed

    private void configurarVentana() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // bloquea cierre directo

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                    MenuAgregarProfesor.this, // ventana actual
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
    private javax.swing.JToggleButton botonFinalizar;
    private javax.swing.JToggleButton botonGuardar;
    private javax.swing.JTextField entradaCorreo;
    private javax.swing.JTextField entradaEspecialidad;
    private javax.swing.JTextField entradaNombre;
    private javax.swing.JTextField entradaRut;
    private javax.swing.JTextField entradaTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaAsignaturas;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelListas;
    private javax.swing.JTable tablaCursos;
    // End of variables declaration//GEN-END:variables
}
