package com.mycompany.proyectoescuela;

import java.util.ArrayList;

public class Curso {
    // --------------- Atributos  ---------------
    private Profesor profesorJefe;
    private String identificador;
    private ArrayList<Asignatura> listaAsignaturas;
    private ArrayList<Alumno> listaAlumnos;
    // --------------- Constructor  ---------------
    public Curso(Profesor profesorJefe, String identificador, ArrayList<Asignatura> listaAsignaturas, ArrayList<Alumno> listaAlumnos) {
        this.profesorJefe = profesorJefe;
        this.identificador = identificador;
        this.listaAsignaturas = listaAsignaturas;
        this.listaAlumnos = listaAlumnos;
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

    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    
}
