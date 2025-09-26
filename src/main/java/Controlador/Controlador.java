package Controlador;

import Modelo.Persona;
import Modelo.ProyectoEscuela;
import Modelo.Curso;
import Modelo.Profesor;
import Modelo.Alumno;
import Modelo.AlumnoException;
import Modelo.RecursoDigital;
import Vista.MenuAdmin;
import Vista.MenuAgregarProfesor;
import Vista.MenuAgregarRecurso;
import Vista.MenuAsignaturasAdmin;
import Vista.MenuAsignaturasAlumno;
import Vista.MenuAsignaturasProfesor;
import Vista.MenuCursosProfesor;
import Vista.MenuLogin;
import Vista.MenuRecursosAlumno;
import Vista.MenuRecursosProfesor;
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
         
         if(rut.equals("20878643")){
             new MenuAdmin(this, sistema.getListaCursos(), sistema.getListaProfesores()).setVisible(true);
         }
         
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
    
    public AlumnoException eliminarAlumno(Alumno estudiante){
        
        try{
            sistema.eliminarAlumno(estudiante.getRut());
        }catch(AlumnoException e){
            return e;
        }
        return null;
    }
    
    public void agregarAlumno(Alumno estudiante){
        
         sistema.getListaAlumnos().add(estudiante);
    }
    
    public void mostrarRecursosProfesor(String nombre, ArrayList<RecursoDigital> recursos){
        MenuRecursosProfesor ventanaRecursos = new MenuRecursosProfesor(this, nombre, recursos);
        ventanaRecursos.setVisible(true);
    }
    
    public void mostrarAsignaturasProfesor(Controlador control, Profesor docente, Curso curso){
        
        MenuAsignaturasProfesor ventanaAsignaturas = new MenuAsignaturasProfesor(control, docente, curso);
        ventanaAsignaturas.setVisible(true);
        
    }
    
    public void mostrarAgregarProfesor(ArrayList<Curso> listaCursos){
        
        new MenuAgregarProfesor(this, listaCursos).setVisible(true);
    }
    
    public void mostrarAsignaturasAdmin(String identificador){

        new MenuAsignaturasAdmin(this, sistema.buscarCursoSistema(identificador)).setVisible(true);
    }
    
    public void agregarProfesor(Profesor profesorNuevo){
        sistema.getListaProfesores().add(profesorNuevo);
    }
    
    public void eliminarProfesor(Profesor profesorEliminar){
        sistema.getListaProfesores().remove(profesorEliminar);
    }
    
    public void eliminarAsignaturaDeProfesores(String asignatura){
        ArrayList<Profesor> listaProfesores = sistema.getListaProfesores();
        
        for(Profesor profe : listaProfesores){
            for(ArrayList<String> listaAsignaturas : profe.getAsignaturasPorCurso().values()){
                listaAsignaturas.remove(asignatura);
            }
        }
        
    }
    
    public void mostrarMenuAgregarRecurso(MenuRecursosProfesor padre, ArrayList<RecursoDigital> materiales){
        
        new MenuAgregarRecurso(padre, this, materiales).setVisible(true);
    }
    
    public ArrayList<String> asignaturasDisponibles(Curso curso){
        
        ArrayList<String> asignaturasDisponibles = sistema.listaAsignaturasDisponibles();
        String[] asignaturasCurso = curso.getRecursosPorAsignatura().keySet().toArray(new String[0]);
        ArrayList<String> asignaturasDisponiblesCurso = new ArrayList<>();
        
        for(int i = 0; i<asignaturasDisponibles.size(); i++){
            for(int j = 0; j<asignaturasCurso.length; j++){
                
                if(asignaturasDisponibles.get(i).equals(asignaturasCurso[j])){
                    asignaturasDisponiblesCurso.add(asignaturasCurso[j]);
                }
            }
        }
        
        return asignaturasDisponiblesCurso;
    }
    
    public void agregarRecursoDigital(RecursoDigital recurso, ArrayList<RecursoDigital> materiales){
        materiales.add(recurso);
    }
    
    public void eliminarRecursoDigital(RecursoDigital recurso, ArrayList<RecursoDigital> materiales){
        
        materiales.remove(recurso);
    }
    
    
    public static void main(String[] args){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controlador();
            }
        });
    }

        
}
    
