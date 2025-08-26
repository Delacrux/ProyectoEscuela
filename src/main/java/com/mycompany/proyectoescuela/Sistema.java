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
    public Alumno buscarAlumnoSistema (String rut) {
        int i;
        for(i = 0 ; i < listaAlumnos.size() ; i++) {
            if (rut.equals(listaAlumnos.get(i).getRut())) {
                return listaAlumnos.get(i);
            }
        }
        return null;
    }
    
    public Profesor buscarProfesorSistema (String rut) {
        int i;
        for ( i = 0 ; i < listaProfesores.size() ; i++) {
            if (rut.equals(listaProfesores.get(i).getRut())) {
                return listaProfesores.get(i);
            }
        }
        return null;
    }
    
    public Curso buscarCursoSistema (String identificador) {
        int i;
        for ( i = 0 ; i < listaCursos.size() ; i++) {
            if (identificador.equals(listaCursos.get(i).getIdentificador())) {
                return listaCursos.get(i);
            }
        }
        return null;
    }
    
    public void mostrarCursosSistema() {
        int i;
        for (i = 0 ; i < listaCursos.size() ; i++) {
            System.out.println((i+1) + ". " + listaCursos.get(i).getIdentificador());
        }
    }
    
    public void mostrarAsignaturasMenu(ArrayList<Asignatura> asignaturas) {
        int i;
        for (i = 0 ; i < asignaturas.size() ; i++) {
            System.out.println((i + 1) + ". " + asignaturas.get(i).getNombreAsignatura());
        }
    }
    
    public void gestionarAgregarNota(Asignatura materia) {
        System.out.println("Rut del alumno al que desea agregar la nota");
        String rutAlumno = scanner.nextLine();
        scanner.nextLine();
        /*Creo que primero se debería comprobar que el alumno esté en la asignatura 
        ??? Nueva funcion Asignatura? buscarAlumnoAsignatura(rutAlumno) */
        System.out.println("Ingresar la calificación.");
        float nota = scanner.nextFloat();
        scanner.nextLine();
        
        System.out.println("Ingresar el detalle de la nota");
        String detalle = scanner.nextLine();
        
        Nota notaAlumno = new Nota(nota, detalle);
        materia.agregarNotaAlumno(rutAlumno, notaAlumno);
    }
    
   public void gestionarAgregarMaterial(Asignatura materia) {
       System.out.println("Título del nuevo recurso digital");
       String titulo = scanner.nextLine();
       
       System.out.println("URL del material.");
       String url = scanner.nextLine();
       
       System.out.println("Detalles extras.");
       String detalle = scanner.nextLine();
       
       RecursosDigitales recurso = new RecursosDigitales(titulo, url, detalle);
       materia.setRecursosDigitales(recurso);
   }
    
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    
    public void menuAlumno (Alumno alumno) {
        Curso cursoAlumno = buscarCursoSistema(alumno.getCurso());
        ArrayList<Asignatura> asignaturasCurso = cursoAlumno.getListaAsignaturas();
        
        System.out.println("Bienvenido(a): " + alumno.getNombreApellido());
        System.out.println("Curso: " + cursoAlumno.getIdentificador());
        System.out.println();
        System.out.println("Seleccione una asignatura para ver más detalles");
        mostrarAsignaturasMenu(asignaturasCurso);
        
        int numeroAsignatura = scanner.nextInt();
        Asignatura materia = cursoAlumno.getAsignaturaPorMenu(numeroAsignatura);
        /* ❌  Falta funcion Curso
        mostrarAsignaturasCurso muetra el arrayList de asignaturas que tiene el curso, se muestran en el orden en 
        se ingresaron las asignaturas y se selecciona la asignatura por la posición
        Indice         0  1   2   3
        Posicion     1  2   3   4
        entonces ahora con getAsignaturaPorMenu, el parametro es solo el número de posicion de la asignatura que se quiere obtener,
        entonces solo hay que retornar la asignatura[posicion -1] para poder acceder a la que se quiere xd
        
         O puede set también Asignatura materia = cursoAlumno.get(numeroAsignatura - 1); ??? */
        menuAsignaturaAlumno(materia, alumno);
    }
    
     // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    
    public void menuAsignaturaAlumno(Asignatura materia, Alumno alumno) {
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
                    //✔ Ver notas del alumno en la asignatura 
                    materia.mostrarNotasAlumnos(alumno.getRut());
                    break;
                case 2:
                    // X Ver todo el material que hay en al asignatura
                    materia.mostrarRecursosDigitales();
                    // Habilitar el método skdjk
                    break;
                case 3:
                    //Ver datos de contacto del profe encargado de la asignatura, como correo, telefono etc
                    // ❌ Falta funcion informacionContactoProfesor();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }
    
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    
    public void menuProfesor(Profesor profesor) {
        ArrayList<Asignatura> listaAsignaturas = profesor.get______();
        //❌ Falta funcion Getter de Profesor, obtiene el arraylist de asignaturas que imparte.
        
        System.out.println("Bienvenido(a): " + profesor.getNombreApellido());
        System.out.println();
        System.out.println("Seleccione una asignatura para ver más detalles");
        mostrarAsignaturasMenu(listaAsignaturas);
        
        int numeroAsignatura = scanner.nextInt();
        Asignatura materia = listaAsignaturas.getAsignaturaPorMenu(numeroAsignatura);
        /* La misma funcion que pido antes dskjsd*/
        menuAsignaturaProfesor(materia);
    }
    
     // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    
    public void menuAsignaturaProfesor(Asignatura materia) {
        int opcion;
        do{
            System.out.println("Asignatura: " + materia.getNombreAsignatura());
            System.out.println();
            System.out.println("Seleccione una opción");
            System.out.println("1. Ver lista alumnos.");
            System.out.println("2. Ver notas de alumnos.");
            System.out.println("3. Ver material digital.");
            System.out.println("4. Agregar nota a alumno.");
            System.out.println("5. Agregar material digital.");
            System.out.println("6. Volver atrás.");
            System.out.println();
        
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    //Ver la lista de los alumnos de la asignatura
                    // ❌ Falta agregar funcion Asignatura, poder ver la lista de todos los alumnos del ramo
                    break;
                case 2:
                    // ✔ Ver las notas de los alumnos en la asignatura
                    materia.mostrarNotasAlumnos();
                    break;
                case 3:
                    // ❌ Ver todo el material digital que hay en la asignatura 
                    materia.mostrarRecursosDigitales();
                    // Habilitar el método skdjk
                    break;
                case 4:
                    //✔️ Agregar una nota a un alumno en la asignatura 
                    gestionarAgregarNota(materia);
                    break;
                case 5:
                    //✔ Agregar meterial digital 
                    gestionarAgregarMaterial(materia);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(opcion != 6);
    }
    
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    
    public void menuAdministrador() {
        int opcion;
        System.out.println("Sistema de Información (SIA)");
        System.out.println("Seleccione un curso para ver más detalles.");
        mostrarCursosSistema();
        
        opcion = scanner.nextInt();
        scanner.nextLine();
        //Obtener el curso mediante Arraylist curso.get(opcion-1)
        //menuAdminCurso(curso seleccionado)
    }
    
    public void menuAdminCurso(Curso curso) {
        ArrayList<Asignatura> asignaturasCurso = curso.getListaAsignaturas();
        
        System.out.println("Seleccione una asignatura para ver más detalles");
        mostrarAsignaturasMenu(asignaturasCurso);
        int numeroAsignatura = scanner.nextInt();
        
        //Obtener la asignatura mediante ArrayList asignaturasCurso.get(opcion -1)
        //menuAdminAsignatura(asignatura seleccionada)
    }
    
    public void menuAdminAsignatura(Asignatura materia) {
        int opcion;
        do{
            System.out.println("Asignatura: " + materia.getNombreAsignatura());
            System.out.println();
            System.out.println("Seleccione una opción");
            System.out.println("1. ");
            System.out.println("2. ");
            System.out.println("3. ");
            System.out.println("...");
            System.out.println();
        
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(opcion != 3);
    }
    
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    // ------------------------------------------------------------- MENU  -------------------------------------------------------------
    public void menuInicial () {
        System.out.println("Bienvenido :p");
        System.out.println("Ingrese su rut. Ej: 123456789");
        String rut = scanner.nextLine();
        
        if (rut.equals("Leonardo")) {
            menuAdministrador();
        }
        else {
            Alumno alumno;
            alumno = buscarAlumnoSistema(rut);
            if (alumno != null) {
                menuAlumno(alumno);
            }
            else {
                Profesor profesor;
                profesor = buscarProfesorSistema(rut);
                if (profesor != null) {
                    menuProfesor(profesor);
                }
                else {
                    System.out.println("Rut no encontrado.");
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
