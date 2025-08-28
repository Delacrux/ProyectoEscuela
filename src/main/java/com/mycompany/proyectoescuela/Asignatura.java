package com.mycompany.proyectoescuela;

import java.util.ArrayList;
import java.util.HashMap;

public class Asignatura {
    // --------------- Atributos  ---------------
    private Profesor profesorJefe;
    private String nombreAsignatura;
    private ArrayList<RecursosDigitales> recursosDigitales;
    private HashMap<Alumno, ArrayList<Nota>> notasAlumnos;

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

    public HashMap<Alumno, ArrayList<Nota>> getNotasAlumnos() {
        return notasAlumnos;
    }

    public Nota getNotasAlumnos(Alumno estudiante, int i){
        ArrayList<Nota> notas = notasAlumnos.get(estudiante);

        if(notas == null || notas.isEmpty() || i >= notas.size()){
            System.out.println("Nota no encontrada en índice "+ i);
            return null;
        }
        return notas.get(i);
    }

    public void setNotasAlumnos(HashMap<Alumno, ArrayList<Nota>> notasAlumnos) {
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
        if(recursosDigitales.isEmpty()){
            System.out.println("No hay recursos Digitales!");
            return;
        }
        for(i=0;i<recursosDigitales.size();i++){
            System.out.println("Recurso n° "+ (i+1));
            recursosDigitales.get(i).mostrarRecursoDigital();
        }
    }

    //------NotasAlumnos------
    public void agregarNotaAlumno(Alumno estudiante, Nota evaluacion) {
        //Verificamos si hay una key con ese nombre
        if(!notasAlumnos.containsKey(estudiante) || notasAlumnos.get(estudiante) == null){
            //No existe esta clave, así que la inicializamos
            notasAlumnos.put(estudiante, new ArrayList<>());
        }
        if (evaluacion != null) {
            notasAlumnos.get(estudiante).add(evaluacion);
        }
        
    }

    public void eliminarNotaAlumno(Alumno estudiante, Nota evaluacion) {
        ArrayList<Nota> notas = notasAlumnos.get(estudiante);
        if (notas == null) {
            System.out.println("Alumno no existe");
            return;
        }
        if(!notas.contains(evaluacion)){
            System.out.println("No existe esta nota para el Alumno");
            return;
        }
        notas.remove(evaluacion);
    }

    //Sobrecarga
    public void mostrarNotasAlumnos(Alumno estudiante){
        ArrayList<Nota> notas = notasAlumnos.get(estudiante);

        //Verificamos si existe, retorna si no, imprime en caso de que sí.
        if (notas == null) {
            System.out.println("No existe alumno " + estudiante.getNombreApellido());
            return;
        }
        
        if(notas.isEmpty()){
            System.out.println("Alumno " + estudiante.getNombreApellido() + " no tiene notas");
            return;
        }
        
        int i = 1;
        for (Nota nota : notas){
            System.out.println((i)+") "+nota.getNota() + " " + nota.getDetalleNota());
            i++;
        }
    }
    public void mostrarNotasAlumnos(){
        for(HashMap.Entry<Alumno, ArrayList<Nota>> dupla: notasAlumnos.entrySet()){
            Alumno alumno = dupla.getKey();
            ArrayList<Nota> notas = dupla.getValue();
            int i = 1;

            System.out.println("Alumno: "+alumno.getNombreApellido());
            
            if(notas.isEmpty()){
            System.out.println("Alumno " + alumno.getNombreApellido() + " no tiene notas");
            }
            
            else{
                for(Nota nota : notas){
                    System.out.println(i+ ") " +nota.getNota());
                    i++;
                }
            }
            System.out.println("");
        }
    }

    public void mostrarAlumnos(){
        int i  = 1;
        for(HashMap.Entry<Alumno, ArrayList<Nota>> dupla : notasAlumnos.entrySet()){
            Alumno alumno = dupla.getKey();

            System.out.println((i) + ") Alumno: "+ alumno.getNombreApellido() + " " + alumno.getRut());
            i++;
        }
    }
    
    public void mostrarAsignatura(){
        System.out.println("Asignatura");
        System.out.println("Nombre: "+nombreAsignatura+". Profesor Jefe: "+ profesorJefe.getNombreApellido());
        System.out.println("Cantidad de recursos: "+recursosDigitales.size());
        System.out.println("Cantidad de alumnos: "+notasAlumnos.size());
    }

}
