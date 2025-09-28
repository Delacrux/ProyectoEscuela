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
import Vista.MenuCursoAdmin;
import Vista.MenuAlumno;
import Vista.MenuCursoProfesor;
import Vista.MenuProfesor;
import Vista.MenuLogin;
import Vista.MenuAsignaturaAlumno;
import Vista.MenuAsignaturaProfesor;
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
        System.out.println("Cursos en sistema: " + sistema.getListaCursos().size());
        for (Curso c : sistema.getListaCursos()) {
            System.out.println("- " + c.getIdentificador());
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
             new MenuAlumno(this, encontrado).setVisible(true);
         }
         
         else{
             buscado = (Persona)sistema.buscarProfesorSistema(rut);
             if(buscado!=null){
                 System.out.println("Profesor encontrado con exito");
                 Profesor encontrado = (Profesor)buscado;
                 ventanaLogin.dispose(); 
                 new MenuProfesor(control, encontrado).setVisible(true); 
             }
         }
         
         
    }
    
    public String estadisticasSistema(){
        String stats = "Cantidad de Cursos: " + sistema.getListaCursos().size() + "\n" +
                "Cantidad de Alumnos: " + sistema.getListaAlumnos().size() + "\n" +
                "Cantidad de Profesores: " + sistema.getListaProfesores().size() + "\n" +
                "\nAsignatura con más recursos: " + sistema.asignaturaConMasRecursos().keySet();
        
        return stats;
    } 
    
    public void mostrarRecursosAlumno(String nombre, ArrayList<RecursoDigital> recursos){
        
        MenuAsignaturaAlumno ventanaRecursos = new MenuAsignaturaAlumno(nombre, recursos);
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
        MenuAsignaturaProfesor ventanaRecursos = new MenuAsignaturaProfesor(this, nombre, recursos);
        ventanaRecursos.setVisible(true);
    }
    
    public void mostrarAsignaturasProfesor(Controlador control, Profesor docente, Curso curso){
        
        MenuCursoProfesor ventanaAsignaturas = new MenuCursoProfesor(control, docente, curso);
        ventanaAsignaturas.setVisible(true);
        
    }
    
    public void mostrarAgregarProfesor(ArrayList<Curso> listaCursos){
        
        new MenuAgregarProfesor(this, listaCursos).setVisible(true);
    }
    
    public void mostrarAsignaturasAdmin(String identificador){

        new MenuCursoAdmin(this, sistema.buscarCursoSistema(identificador)).setVisible(true);
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
    
    public void mostrarMenuAgregarRecurso(MenuAsignaturaProfesor padre, ArrayList<RecursoDigital> materiales){
        
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
    
    public void guardarDatos(){
        sistema.guardadoDeDatos();
    }
    
    public void generarReporte(){
        sistema.generarReporte();
    }
    
    
    public static void main(String[] args){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controlador();
            }
        });
    }

        
}
    
