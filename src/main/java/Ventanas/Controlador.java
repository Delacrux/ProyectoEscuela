package Ventanas;

import com.mycompany.proyectoescuela.*;
import java.util.*;


public class Controlador {
    
    private ProyectoEscuela sistema;
    private MenuLogin ventanaLogin;
    
    public Controlador(){
        
        sistema = new ProyectoEscuela();
        sistema.llenarDatos();
        
        System.out.println("Alumnos en sistema: " + sistema.getListaAlumnos().size());
        for (Alumno a : sistema.getListaAlumnos()) {
            System.out.println("- " + a.getNombreApellido() + " (" + a.getRut() + ")");
        }
        
        mostrarLogin();
    }
    
    public void mostrarLogin(){
        
        ventanaLogin = new MenuLogin(this);
        ventanaLogin.setVisible(true);
    }
    
    public void procesarLogin(Controlador control, String rut){
        
         System.out.println("Login comenzado con exito");
         Persona buscado = (Persona)sistema.buscarAlumnoSistema(rut);
         
         if(buscado!=null){
             System.out.println("Alumno encontrado con exito");
             Alumno encontrado = (Alumno)buscado;
             ventanaLogin.dispose();
             new MenuAsignaturasAlumno(this, encontrado).setVisible(true);
         }
         
         else{
             buscado = (Persona)sistema.buscarProfesorSistema(rut);
             if(buscado!=null){
                 System.out.println("Profesor encontrado con exito");
                 Profesor encontrado = (Profesor)buscado;
                 ventanaLogin.dispose(); // cierra el login
                 new MenuCursosProfesor(control, encontrado).setVisible(true); 
             }
         }
         
         
    }
    
    public void mostrarRecursosAlumno(String nombre, ArrayList<RecursoDigital> recursos){
        
        MenuRecursosAlumno ventanaRecursos = new MenuRecursosAlumno(nombre, recursos);
        ventanaRecursos.setVisible(true);
        
    }
    
    public void mostrarAsignaturasProfesor(Controlador control, Profesor docente, Curso curso){
        
        MenuAsignaturasProfesor ventanaAsignaturas = new MenuAsignaturasProfesor(control, docente, curso);
        ventanaAsignaturas.setVisible(true);
        
    }
    
    public void mostrarMenuAgregarRecurso(Controlador control, ArrayList<RecursoDigital> materiales){
        
        new MenuAgregarRecurso(control, materiales).setVisible(true);
    }
    
    public void agregarRecursoDigital(RecursoDigital recurso, ArrayList<RecursoDigital> materiales){
        
        materiales.add(recurso);
    }
    
    public static void main(String[] args){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controlador();
            }
        });
    }
        
}
    
