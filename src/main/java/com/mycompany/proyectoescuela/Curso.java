package com.mycompany.proyectoescuela;

import java.util.HashMap;
import java.util.ArrayList;

public class Curso {
    // --------------- Atributos  ---------------
    private Profesor profesorJefe;
    private String identificador;
    private HashMap< String , ArrayList<RecursoDigital >> recursosPorAsignatura;
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

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
/*
    public void agregarAsignatura(Asignatura materia){
        
        if(listaAsignaturas.contains(materia)){
            System.out.println("Asignatura ya está en Curso");
            return;
        }
        listaAsignaturas.add(materia);
        
    }
    public void eliminarAsignatura(int i){
        
        if(i>=listaAsignaturas.size() || i<0){
            System.out.println("Indice fuera de rango disponible: 0-"+(listaAsignaturas.size()));
            return;
        }
        listaAsignaturas.remove(i);
    }
    public void eliminarAsignatura(Asignatura materia){
        
        if(!listaAsignaturas.contains(materia)){
            System.out.println("Asignatura no existente");
            return;
        }
        listaAsignaturas.remove(materia);
    }
    */
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
    
    public void mostrarAlumnosCurso(){
        int i;
        for(i = 0; i<listaAlumnos.size();i++){
            System.out.println((i+1) + ") " + listaAlumnos.get(i).getNombreApellido());
        }
    }
    
    public Alumno getAlumnoPorMenu(int i){
        if(i>=listaAlumnos.size() || i<0){
            System.out.println("Indice fuera de rango: 0-"+listaAlumnos.size());
            return null;
        }
        return listaAlumnos.get((i-1));
    }
    
    public void mostrarCurso(){
        System.out.println("Curso: " + identificador);
        System.out.println("Profesor Jefe: " + profesorJefe);
        System.out.println("Cantidad de Asignaturas: " + recursosPorAsignatura.size());
        System.out.println("Cantidad de Alumnos: " + listaAlumnos.size());
    }
}
