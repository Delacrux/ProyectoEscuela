package com.mycompany.proyectoescuela;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    // ------------------------------------------------------------- Atributos  -------------------------------------------------------------
    private ArrayList<Profesor> listaProfesores;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Curso> listaCursos;
    private Scanner scanner;
    
    // ------------------------------------------------------------- Constructor  -------------------------------------------------------------
    public Sistema() {
        this.listaProfesores = new ArrayList<>();
        this.listaAlumnos = new ArrayList<>();
        this.listaCursos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    // ------------------------------------------------------------- Getter y Setter  -------------------------------------------------------------
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

    // ------------------------------------------------------------- Métodos  -------------------------------------------------------------
    
     // ------------------------------  Búsqueda ------------------------------ 
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
    
    // ------------------------------  Mostrar ------------------------------ 
    public void mostrarCursosMenu() {
        int i;
        for (i = 0 ; i < listaCursos.size() ; i++) {
            System.out.println((i+1) + ". " + listaCursos.get(i).getIdentificador());
        }
    }
    
    public void mostrarAsignaturasMenu(ArrayList<Asignatura> lista){
        int i;
        System.out.println("Asignaturas en Curso:");
        for(i = 0; i<lista.size(); i++){
            System.out.println((i+1) + ") "+ lista.get(i).getNombreAsignatura());
        }
        
    }
    
    // ------------------------------  Métodos menú ------------------------------ 
    public Asignatura getAsignaturaPorMenu(ArrayList<Asignatura> lista, int opcion) {
        if( opcion >= lista.size() || opcion < 0){
            System.out.println("Indice fuera de rango: 0-"+lista.size());
            return null;
        }
        return lista.get((opcion-1));
    }
    
    public Curso getCursoPorMenu(ArrayList<Curso> lista, int opcion) {
        if( opcion >= lista.size() || opcion < 0){
            System.out.println("Indice fuera de rango: 0-"+lista.size());
            return null;
        }
        return lista.get((opcion-1));
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
       materia.agregarRecursoDigital(recurso);
   }
    
    // ------------------------------------------------------------- MENU ALUMNO -------------------------------------------------------------
    // ------------------------------------------------------------- MENU ALUMNO -------------------------------------------------------------
    // ------------------------------------------------------------- MENU ALUMNO -------------------------------------------------------------
    
    public void menuAlumno (Alumno alumno) {
        Curso cursoAlumno = buscarCursoSistema(alumno.getCurso());
        ArrayList<Asignatura> lista = cursoAlumno.getListaAsignaturas();
        
        System.out.println("Bienvenido(a): " + alumno.getNombreApellido());
        System.out.println("Curso: " + cursoAlumno.getIdentificador());
        System.out.println();
        System.out.println("Seleccione una asignatura para ver más detalles");
        mostrarAsignaturasMenu(lista);
        
        int opcion = scanner.nextInt();
        Asignatura materia = getAsignaturaPorMenu(lista,opcion);
        menuAsignaturaAlumno(materia, alumno);
    }
    
     // ------------------------------------------------------------- MENU ALUMNO -------------------------------------------------------------
    
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
                    materia.mostrarNotasAlumnos(alumno.getRut());
                    break;
                case 2:
                    materia.mostrarRecursosDigitales();
                    break;
                case 3:
                    Profesor profesorAsignatura = materia.getProfesorJefe();
                    profesorAsignatura.informacionContactoProfesor();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }
    
    // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    
    public void menuProfesor(Profesor profesor) {
        ArrayList<Asignatura> listaAsignaturas = profesor.getListaAsignaturas();

        System.out.println("Bienvenido(a): " + profesor.getNombreApellido());
        System.out.println();
        System.out.println("Seleccione una asignatura para ver más detalles");
        mostrarAsignaturasMenu(listaAsignaturas);
        
        int opcion = scanner.nextInt();
        Asignatura materia = getAsignaturaPorMenu(listaAsignaturas, opcion);
        menuAsignaturaProfesor(materia);
    }
    
     // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    
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
                    materia.mostrarNotasAlumnos();
                    break;
                case 3:
                    materia.mostrarRecursosDigitales();
                    break;
                case 4:
                    gestionarAgregarNota(materia);
                    break;
                case 5:
                    gestionarAgregarMaterial(materia);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(opcion != 6);
    }
    
    
    public void menuAdministrador() {
        System.out.println("Cargando...");
    }
    // ------------------------------------------------------------- LOGIN -------------------------------------------------------------
    // ------------------------------------------------------------- LOGIN -------------------------------------------------------------
    // ------------------------------------------------------------- LOGIN -------------------------------------------------------------
    
    public void menuInicial () {
        System.out.println("Bienvenido");
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
       sistema.scanner.close();
    }
}
