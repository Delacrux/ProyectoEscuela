package Ventanas;

import com.mycompany.proyectoescuela.*;
import java.util.*;


public class Controlador {
    
    private ProyectoEscuela sistema;
    private LoginFrame ventanaLogin;
    
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
        
        ventanaLogin = new LoginFrame(this);
        ventanaLogin.setVisible(true);
    }
    
    public void procesarLogin(String rut){
        
         System.out.println("Login comenzado con exito");
         Persona buscado = (Persona)sistema.buscarAlumnoSistema(rut);
         if(buscado!=null){
             System.out.println("Alumno encontrado con exito");
             Alumno encontrado = (Alumno)buscado;
             ventanaLogin.dispose();
             new MenuAlumnoFrame(this, encontrado).setVisible(true);
         }
         else{
             buscado = (Persona)sistema.buscarProfesorSistema(rut);
             if(buscado!=null){
                 System.out.println("Profesor encontrado con exito");
                 Profesor encontrado = (Profesor)buscado;
                 ventanaLogin.dispose(); // cierra el login
                 new MenuProfesorFrame(encontrado).setVisible(true); 
             }
         }
         
         
    }
    
    public void mostrarAsignatura(String nombre, ArrayList<RecursoDigital> recursos){
        
        RecursosAsignaturaFrame ventanaRecursos = new RecursosAsignaturaFrame(nombre, recursos);
        ventanaRecursos.setVisible(true);
        
    }
    
    public static void main(String[] args){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controlador();
            }
        });
    }
        
}
    
