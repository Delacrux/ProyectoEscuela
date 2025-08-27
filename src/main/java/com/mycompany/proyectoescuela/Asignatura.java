package com.mycompany.proyectoescuela;

import java.util.ArrayList;
import java.util.HashMap;

public class Asignatura {
    // --------------- Atributos  ---------------
    private Profesor profesorJefe;
    private String nombreAsignatura;
    private ArrayList<RecursosDigitales> recursosDigitales;
    private HashMap<String, ArrayList<Nota>> notasAlumnos;

    // --------------- Constructor  ---------------
    public Asignatura(Profesor profesorJefe, String nombreAsignatura) {
        this.profesorJefe = profesorJefe;
        this.recursosDigitales = new ArrayList<>();
        this.notasAlumnos = new HashMap<>();
        this.nombreAsignatura = nombreAsignatura;
    }

    // --------------- getter y setter  ---------------
    
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
    public RecursosDigitales getRecursosDigitales(int i){
        if(i>=recursosDigitales.size() || i<0){return null;}
        return recursosDigitales.get(i);
    }
    
    public void setRecursosDigitales(ArrayList<RecursosDigitales> recursosDigitales) {
        this.recursosDigitales = recursosDigitales;
    }
    
    public HashMap<String, ArrayList<Nota>> getNotasAlumnos() {
        return notasAlumnos;
    }
    public Nota getNotasAlumnos(String nombre, int i){
        ArrayList<Nota> notas = notasAlumnos.get(nombre);
        if(notas == null || notas.isEmpty() || i >= notas.size()){
            return null;
        }
        return notas.get(i);
    }
    
    public void setNotasAlumnos(HashMap<String, ArrayList<Nota>> notasAlumnos) {
        this.notasAlumnos = notasAlumnos;
    }

    
    //Métodos.
    
    public void agregarRecursoDigital(RecursosDigitales recurso){
        recursosDigitales.add(recurso);
    }
    
    public boolean eliminarRecursoDigital(RecursosDigitales recurso){
        if(recursosDigitales.contains(recurso)){
            recursosDigitales.remove(recurso);
            return true;
        }
        return false;
    }
    
    public void mostrarRecursosDigitales(){
        int i;
        for(i=0;i<recursosDigitales.size();i++){
            System.out.println("Recurso n° "+ (i+1));
            recursosDigitales.get(i).mostrarRecursoDigital();
        }
    }

    //------NotasAlumnos------
    public void agregarNotaAlumno(String nombre, Nota evaluacion) {
        //Verificamos si hay una key con ese nombre
        if(!notasAlumnos.containsKey(nombre)){
            //No existe esta clave, así que la inicializamos
            notasAlumnos.put(nombre, new ArrayList<>());
        }
        notasAlumnos.get(nombre).add(evaluacion);
    }
    public void eliminarNotaAlumno(String nombre, Nota evaluacion) {
        ArrayList<Nota> notas = notasAlumnos.get(nombre);
        if (notas == null || !notas.contains(evaluacion)) {
            System.out.println("Alumno no existe");
            return;
        }
        notas.remove(evaluacion);
    }
   
    //Sobrecarga
    public void mostrarNotasAlumnos(String nombre){
        ArrayList<Nota> notas = notasAlumnos.get(nombre);
        //Verificamos si existe, retorna si no, imprime en caso de que sí.
        if (notas == null) {
            System.out.println("No existe el alumno " + nombre);
            return;
        }
        int i = 1;
        for (Nota nota : notas){
            System.out.println((i)+") "+nota.toString());
            i++;
        }
    }
    public void mostrarNotasAlumnos(){
        for(HashMap.Entry<String, ArrayList<Nota>> dupla: notasAlumnos.entrySet()){
            String alumno = dupla.getKey();
            ArrayList<Nota> notas = dupla.getValue();
            int i = 1;
            System.out.print("Alumno: "+alumno);
            for(Nota nota : notas){
                System.out.println(i+ ") " +nota.toString());
                i++;
            }
        }
    }

    public void mostrarAsignatura(){
        System.out.println("Asignatura");
        System.out.println("Nombre: "+nombreAsignatura+". Profesor Jefe: "+ profesorJefe);
        System.out.println("Cantidad de recursos: "+recursosDigitales.size());
        System.out.println("Cantidad de alumnos: "+notasAlumnos.size());
    }

}
