package com.mycompany.proyectoescuela;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    // --------------- Atributos  ---------------
    private ArrayList<Profesor> listaProfesores;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Curso> listaCursos;
    private Scanner scanner;
    
    // --------------- Constructor  ---------------
    public Sistema() {
        this.listaProfesores = new ArrayList<Profesor>();
        this.listaAlumnos = new ArrayList<Alumno>();
        this.listaCursos = new ArrayList<Curso>();
        this.scanner = new Scanner(System.in);
    }
    // --------------- Getter y Setter  ---------------
    public ArrayList<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }
    // --------------- Métodos  ---------------
    public Alumno buscarAlumno (String rut) {
        int i;
        for(i = 0 ; i < listaAlumnos.size() ; i++) {
            if (rut.equals(listaAlumnos.get(i).getRut())) {
                return listaAlumnos.get(i);
            }
        }
        return null;
    }
    
    public Profesor buscarProfesor (String rut) {
        int i;
        for ( i = 0 ; i < listaProfesores.size() ; i++) {
            if (rut.equals(listaProfesores.get(i).getRut())) {
                return listaProfesores.get(i);
            }
        }
        return null;
    }
    
    public Curso buscarCurso (String identificador) {
        int i;
        for ( i = 0 ; i < listaCursos.size() ; i++) {
            if (identificador.equals(listaCursos.get(i).getIdentificador())) {
                return listaCursos.get(i);
            }
        }
        return null;
    }
    
    public void mostrarAsignaturasCurso(Curso curso) {
        int i;
        ArrayList<Asignatura> asignaturas = curso.getListaAsignaturas();
        for (i = 0 ; i < asignaturas.size() ; i++) {
            System.out.println((i + 1) + ". " + asignaturas.get(i).getNombreAsignatura());
        }
    }
    
    public void menuAlumno (Alumno alumno) {
        Curso cursoAlumno;
        cursoAlumno = buscarCurso(alumno.getCurso());
        
        System.out.println("Bienvenido(a): " + alumno.getNombreApellido());
        System.out.println("Curso: " + cursoAlumno.getIdentificador());
        System.out.println();
        System.out.println("Seleccione una asignatura para ver más detalles");
        mostrarAsignaturasCurso(cursoAlumno);
        int numeroAsignatura = scanner.nextInt();
        Asignatura materia;
        materia = cursoAlumno.getAsignaturaPorID(numeroAsignatura);
        
        menuAsignatura(materia);
    }
    
    public void menuAsignatura(Asignatura materia) {
        int opcion;
        do {
            System.out.println("Asignatura: " + materia.getNombreAsignatura());
            System.out.println();
            System.out.println("Seleccione una opción");
            System.out.println("1. Ver notas.");
            System.out.println("2. Ver material digital");
            System.out.println("3. Ver contacto profesor.");
            System.out.println("4. Volver atrás");
            System.out.println();
        
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {
                case 1:
                    //Ver notas del alumno en la asignatura xd
                    break;
                case 2:
                    //Ver todo el material que hay en al asignatura
                    break;
                case 3:
                    //Vwer datos de contacxto del profe, correo, telefono etc
                    break;
                case 4:
                    break;
                default:
                    System.out.println("No valido");
            }
        } while (opcion != 4);
    }
    
    public void menuInicial () {
        System.out.println("Bienvenido :p");
        System.out.println("Ingrese su rut. Ej: 123456789");
        String rut = scanner.nextLine();
        
        if (rut.equals("LeonardoCubillos")) {
            menuAdministador();
        }
        else {
            Alumno alumno;
            alumno = buscarAlumno(rut);
            if (alumno != null) {
                menuAlumno(alumno);
            }
            else {
                Profesor profesor;
                profesor = buscarProfesor(rut);
                if (profesor != null) {
                    menuProfesor(profesor);
                }
                else {
                    System.out.println("Rut no encontrado");
                }
            }
        }
    }
    
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    public static void main(String[] args) {
       Sistema sistema = new Sistema();
       sistema.menuInicial();
    }
}
