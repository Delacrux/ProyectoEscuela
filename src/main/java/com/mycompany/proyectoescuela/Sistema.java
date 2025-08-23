package com.mycompany.proyectoescuela;

import java.util.ArrayList;

public class Sistema {
    // --------------- Atributos  ---------------
    private ArrayList<Profesor> listaProfesores;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Curso> listaCursos;
    
    // --------------- Constructor  ---------------
    public Sistema() {
        this.listaProfesores = new ArrayList<Profesor>();
        this.listaAlumnos = new ArrayList<Alumno>();
        this.listaCursos = new ArrayList<Curso>();
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
        mostrarAsignaturasCurso(cursoAlumno);
    }
    
    public void menuInicial () {
        System.out.println("Bienvenido :p");
        System.out.println("Ingrese su rut. Ej: 123456789");
        
    }
    
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    public static void main(String[] args) {
        
     
        
    }
}
