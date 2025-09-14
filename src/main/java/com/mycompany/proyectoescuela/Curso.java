package com.mycompany.proyectoescuela;

import java.util.HashMap;
import java.util.ArrayList;

public class Curso {
    // --------------- Atributos  ---------------
    private Profesor profesorJefe;
    private String identificador;
    private HashMap< String, ArrayList<RecursoDigital >> recursosPorAsignatura;
    private ArrayList<Alumno> listaAlumnos;
    
    // --------------- Constructor  ---------------
    public Curso(Profesor profesorJefe, String identificador) {
        this.profesorJefe = profesorJefe;
        this.identificador = identificador;
        this.recursosPorAsignatura = new HashMap <>();
        this.listaAlumnos = new ArrayList<>();
    }
    // --------------- Getter y Setter  ---------------
    public Profesor getProfesorJefe() {
        return profesorJefe;
    }

    public void setProfesorJefe(Profesor profesorJefe) {
        this.profesorJefe = profesorJefe;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public HashMap< String , ArrayList<RecursoDigital>> getRecursosPorAsignatura () {
        return this.recursosPorAsignatura;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
    
    public Alumno getAlumnoPorMenu(int i){
        if(i>=listaAlumnos.size() || i<0){
            System.out.println("Indice fuera de rango: 0-"+listaAlumnos.size());
            return null;
        }
        return listaAlumnos.get((i-1));
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    public void agregarAsignatura(String materia){
        
        if(recursosPorAsignatura.containsKey(materia)){
            System.out.println("Asignatura ya está en Curso");
            return;
        }
        recursosPorAsignatura.put(materia, new ArrayList<>());
        
    }
    
    public void eliminarAsignatura(int i){
        
        if(i>=recursosPorAsignatura.size() || i<0){
            System.out.println("Indice fuera de rango disponible: 0-"+(recursosPorAsignatura.size()));
            return;
        }
        recursosPorAsignatura.remove(i);
    }
    public void eliminarAsignatura(String materia){
        
        if(!recursosPorAsignatura.containsKey(materia)){
            System.out.println("Asignatura no existente");
            return;
        }
        recursosPorAsignatura.remove(materia);
    }
    
    public void agregarAlumno(Alumno estudiante){
        if(listaAlumnos.contains(estudiante)){
            System.out.println("Estudiante ya se encuentra en el Curso");
            return;
        }
        listaAlumnos.add(estudiante);
    }
    
    public void eliminarAlumno(int i){
        if(i>=listaAlumnos.size() || i<0){
            System.out.println("Indice fuera de rango: 0-"+listaAlumnos.size());
            return;
        }
        listaAlumnos.remove(i);
    }
    
    public void eliminarAlumno(Alumno estudiante){
        if(!listaAlumnos.contains(estudiante)){
            System.out.println("Estudiante no registrado en el Curso");
            return;
        }
        listaAlumnos.remove(estudiante);
    }
    
    public void agregarRecursoDigital(String asignatura, RecursoDigital recurso){
        
        if(!recursosPorAsignatura.containsKey(asignatura)){
            System.out.println("No se encontró asignatura para agregar recurso");
            return;
        }
       
         ArrayList<RecursoDigital> lista = recursosPorAsignatura.get(asignatura);
         int i; RecursoDigital actual;
            
         for(i = 0; i<lista.size(); i++){
             actual = lista.get(i);
             if(actual == recurso || actual.getUrl().equals(recurso.getUrl())){
                 System.out.println("Recurso ya existe en " + asignatura);
                 return;
             }
         }
        
        lista.add(recurso);
    }
    
    public void mostrarAlumnosCurso(){
        int i;
        for(i = 0; i<listaAlumnos.size();i++){
            System.out.println((i+1) + ") " + listaAlumnos.get(i).getNombreApellido());
        }
    }
    
    public void mostrarAsignaturas(){
        int i = 1;
        for(String asignatura: recursosPorAsignatura.keySet()){
            System.out.println(i + ") " + asignatura);
            i++;
        }
        
    }
    
    public void mostrarCurso(){
        System.out.println("Curso: " + identificador);
        System.out.println("Profesor Jefe: " + profesorJefe);
        System.out.println("Cantidad de Asignaturas: " + recursosPorAsignatura.size());
        System.out.println("Cantidad de Alumnos: " + listaAlumnos.size());
    }
}
