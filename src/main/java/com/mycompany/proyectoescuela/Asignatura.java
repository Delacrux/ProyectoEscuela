package com.mycompany.proyectoescuela;

import java.util.ArrayList;
import java.util.HashMap;

public class Asignatura {
    // --------------- Atributos  ---------------
    private Profesor profesorJefe;
    private String nombreAsignatura;
    private ArrayList<RecursosDigitales> recursosDigitales;
    private HashMap<String, ArrayList<Nota>> notasAlumnos;
    
// --------------- Constructor  --------------- Ni idea que es wn xd
    public Asignatura(Profesor profesorJefe, ArrayList<RecursosDigitales> recursosDigitales, HashMap<String, ArrayList<Nota>> notasAlumnos, String nombreAsignatura) {
        this.profesorJefe = profesorJefe;
        this.recursosDigitales = recursosDigitales;
        this.notasAlumnos = notasAlumnos;
        this.nombreAsignatura = nombreAsignatura;
    }
    // --------------- Getter y Setter  --------------- 
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
    
    public Profesor getProfesorJefe() {
        return profesorJefe;
    }

    public void setProfesorJefe(Profesor profesorJefe) {
        this.profesorJefe = profesorJefe;
    }

    public ArrayList<RecursosDigitales> getRecursosDigitales() {
        return recursosDigitales;
    }

    public void setRecursosDigitales(ArrayList<RecursosDigitales> recursosDigitales) {
        this.recursosDigitales = recursosDigitales;
    }

    public HashMap<String, ArrayList<Nota>> getNotasAlumnos() {
        return notasAlumnos;
    }
    
    public void setNotasAlumnos(HashMap<String, ArrayList<Nota>> notasAlumnos) {
        this.notasAlumnos = notasAlumnos;
    }
    
    
}
