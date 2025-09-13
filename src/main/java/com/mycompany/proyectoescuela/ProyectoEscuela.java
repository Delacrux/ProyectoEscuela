package com.mycompany.proyectoescuela;

import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProyectoEscuela {
    // ------------------------------------------------------------- Atributos  -------------------------------------------------------------
    private ArrayList<Profesor> listaProfesores;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Curso> listaCursos;
    private Scanner scanner;
    
    // ------------------------------------------------------------- Constructor  -------------------------------------------------------------
    public ProyectoEscuela() {
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
    
    // ------------------------------  Métodos menú ------------------------------ 
    
   public void gestionarAgregarMaterial() {
       System.out.println("Título del nuevo recurso digital");
       String titulo = scanner.nextLine();
       
       System.out.println("URL del material.");
       String url = scanner.nextLine();
       
       System.out.println("Detalles extras.");
       String detalle = scanner.nextLine();
       
       RecursoDigital recurso = new RecursoDigital(titulo, url, detalle);
   }
   
       //------------------------------Datos Iniciales ------------------------------
    public void llenarDatos() {
        System.out.println("Cargando datos...");
        llenadoDeProfesores();
        llenadoDeAlumnos();
        llenadoDeCursos();
        System.out.println("Datos cargados correctamente");
    }
    
    public void llenadoDeProfesores(){
        try(Scanner sc = new Scanner(new File("profesores.csv"))){
            while(sc.hasNextLine()){
                String linea  = sc.nextLine();
                String[] campos = linea.split(",");
                if(campos.length == 5)
                {
                    Profesor profe = new Profesor(campos[0], campos[1],campos[2],campos[3],campos[4]);
                    listaProfesores.add(profe);
                    
                }
            }
         }
        catch(FileNotFoundException e){
            System.out.println("Error al leer profesores.csv: " + e.getMessage());
        }
    
    }
    public void llenadoDeAlumnos(){
    
    }
    public void llenadoDeCursos(){
    
    }
    // ------------------------------------------------------------- MENU ALUMNO -------------------------------------------------------------
    // ------------------------------------------------------------- MENU ALUMNO -------------------------------------------------------------
    // ------------------------------------------------------------- MENU ALUMNO -------------------------------------------------------------
    /*
    public void menuAlumno (Alumno alumno) {
        Curso cursoAlumno = alumno.getCurso();
        System.out.println("Bienvenido(a): " + alumno.getNombreApellido());
        System.out.println("Curso: " + cursoAlumno.getIdentificador());
        System.out.println();
        System.out.println("Seleccione una asignatura para ver más detalles");
        
        int opcion = scanner.nextInt();
        
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
                    materia.mostrarNotasAlumnos();
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
    */
    // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    public ArrayList <Curso> mostrarCursosProfesor(Profesor profesor) {
        Set<Curso> lista = profesor.getCursosAsignados();
        int i = 1;
        for (Curso curso : lista) {
            System.out.println(i + ". " + curso.getIdentificador());
            i++;
        }
        ArrayList<Curso> arraylist = new ArrayList<>(lista);
        return arraylist;
    }
    
    public ArrayList<String> mostrarAsignaturas(Profesor profesor, Curso curso) {
        ArrayList<String> lista = profesor.getAsignaturasEnCurso(curso);
        for (int i = 0 ; i < lista.size() ; i++) {
            String asignatura = lista.get(i);
            System.out.println((i + 1) + ". " + asignatura);
        }
        return lista;
    }
    
    /*
    public ArrayList<String> mostrarAsignaturas ( Curso curso) {
    
    } */
    
    public void menuProfesor(Profesor profesor) {
        System.out.println("Bienvenido(a): " + profesor.getNombreApellido());
        System.out.println();
        System.out.println("Seleccione un curso para ver más detalles");
        ArrayList <Curso> lista = mostrarCursosProfesor(profesor);
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        Curso cursoSeleccionado = lista.get(opcion - 1);
        menuCursoProfesor(profesor, cursoSeleccionado);
    }
    
     // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    
    public void menuCursoProfesor(Profesor profesor, Curso curso) {
        System.out.println("Seleccione una asignatura para ver más detalles");
        ArrayList<String> lista = mostrarAsignaturas(profesor, curso);
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        String asignaturaSeleccionada = lista.get(opcion - 1);
        menuAsignaturaProfesor(curso, asignaturaSeleccionada);
    }
    
    public void menuAsignaturaProfesor(Curso curso, String asignatura) {
        int opcion;
        do{
            System.out.println("Asignatura: " + asignatura);
            System.out.println();
            System.out.println("Seleccione una opción");
            System.out.println("1. Ver material digital.");
            System.out.println("2. Agregar material digital.");
            System.out.println("3. Eliminar material digital.");
            System.out.println("4. Volver atrás.");
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
                case 4:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(opcion != 3);
    }
    
    
    // ------------------------------------------------------------- LOGIN -------------------------------------------------------------
    // ------------------------------------------------------------- LOGIN -------------------------------------------------------------
    // ------------------------------------------------------------- LOGIN -------------------------------------------------------------
    
    public void menuInicial () {
        System.out.println("Bienvenido");
        System.out.println("Ingrese su rut. Ej: 123456789");
        String rut = scanner.nextLine();
        
        Alumno alumno;
        alumno = buscarAlumnoSistema(rut);
        if (alumno != null)  {
            menuAlumno(alumno);
        }
        else {
            Profesor profesor;
            profesor = buscarProfesorSistema(rut);
            if (profesor != null) {
                menuProfesor(profesor);
            }
            else {
                System.out.println("Rut no encontrado");
            }
        }
    }
    
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    public static void main(String[] args) {
       ProyectoEscuela sistema = new ProyectoEscuela();
       sistema.llenarDatos();
       sistema.menuInicial();
       sistema.scanner.close();
    }
}
