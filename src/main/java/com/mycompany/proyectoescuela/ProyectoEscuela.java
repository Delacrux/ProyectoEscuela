package com.mycompany.proyectoescuela;

import java.util.Set;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// ----------- Clase ProyectoEscuela -----------
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
    
    // ------------------------------  BUSQUEDA  ------------------------------ 
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
    
    // ------------------------------  AGREGAR  ------------------------------ 
    public Profesor crearYAgregarProfesor(String rut, String nombreApellido, String especialidad, String correo, String telefono) {
        if (buscarProfesorSistema(rut) == null ) {
            Profesor nuevoProfesor =new Profesor(rut, nombreApellido, especialidad, correo, telefono);
            listaProfesores.add(nuevoProfesor);
            return nuevoProfesor;
        }
        return null;
    }
   
    public Alumno crearYAgregarAlumno(String rut, String nombreApellido, String correo, String telefono, String curso) {
        Curso cursoAlumno = buscarCursoSistema(curso);
        if (buscarAlumnoSistema(rut) == null && cursoAlumno != null) {
            Alumno nuevoAlumno = new Alumno(rut, nombreApellido, correo, telefono, cursoAlumno);
            listaAlumnos.add(nuevoAlumno);
            return nuevoAlumno;
        }
        return null;
    }
    
    public Curso crearYAgregarCurso(String rutProfeJefe, String identificador) {
        Profesor profesorJefe = buscarProfesorSistema(rutProfeJefe);
        
        if (buscarCursoSistema(identificador) == null && profesorJefe != null) {
            Curso nuevoCurso = new Curso(profesorJefe, identificador);
            listaCursos.add(nuevoCurso);
            return nuevoCurso;
        }
        return null;
    }
    
    //----------------- GESTIONAR AGREGAR --------------------  
    public void gestionarCrearProfesor() {
        System.out.println("Rutprofe");
        String rut =  scanner.nextLine();
        System.out.println("nombre profe");
        String nombreApellido = scanner.nextLine();
        System.out.println("especialidad");
        String especialidad = scanner.nextLine();
        System.out.println("correoo");
        String correo = scanner.nextLine();
        System.out.println("telefono");
        String telefono = scanner.nextLine();
        
        if (crearYAgregarProfesor(rut, nombreApellido, especialidad, correo, telefono) == null) {
            System.out.println("falló");
        }
        else {
            System.out.println("profesor creado y agregado con exito");
        }
    }
    
    public void gestionarCrearAlumno() {
        System.out.println("rut alumno");
        String rut =  scanner.nextLine();
        System.out.println("nombre alumno");
        String nombreApellido = scanner.nextLine();
        System.out.println("correo  alumno");
        String correo = scanner.nextLine();
        System.out.println("telefono  alumno");
        String telefono = scanner.nextLine();
        System.out.println("curso del alumno");
        String curso = scanner.nextLine();
        
        if (crearYAgregarAlumno(rut, nombreApellido, correo, telefono, curso) == null) {
            System.out.println("falló");
        }
        else {
            System.out.println("Alumno creado y agregado con exito");
        }
    }
    
    public void gestionarCrearCurso() {
        System.out.println("Identificador del curso");
        String identificador = scanner.nextLine();
        System.out.println("nombre del profe jefe");
        String rutProfeJefe = scanner.nextLine();
        
        if (crearYAgregarCurso(rutProfeJefe, identificador) == null) {
            System.out.println("falló");
        }
        else {
            System.out.println("curso creado con exito");
        }
    }
    
    // ------------------------------  ELIMINAR  ------------------------------ 
    public Profesor eliminarProfesor(String rutProfesor) {
        Profesor profesor = buscarProfesorSistema(rutProfesor);
        if (profesor != null) {
            listaProfesores.remove(profesor);
            return profesor;
        }
        return null;
    }
    
    public Alumno eliminarAlumno(String rutAlumno) {
        Alumno alumno = buscarAlumnoSistema(rutAlumno);
        if (alumno != null) {
            listaAlumnos.remove(alumno);
            return alumno;
        }
        return null;
    }
    
    public Curso eliminarCurso(String identificador) {
        Curso curso = buscarCursoSistema(identificador);
        if (curso != null) {
            listaCursos.remove(curso);
            return curso;
        }
        return null;
    }
    
    //----------------- GESTIONAR ELIMINAR  --------------------  
    public void gestionarEliminarProfesor() {
        System.out.println("Rut del profe a eliminar");
        String rut = scanner.nextLine();
        
        if (eliminarProfesor(rut) == null) {
            System.out.println("falló");
        }
        else {
            System.out.println("Profesor eliminado con exito.");
        }
    }
    
    public void gestionarEliminarAlumno() {
        System.out.println("Rut del Alumno a eliminar");
        String rut = scanner.nextLine();
        
        if (eliminarAlumno(rut) == null) {
            System.out.println("falló");
        }
        else {
            System.out.println("Alumno eliminado con exito.");
        }
    }
    
    public void gestionarEliminarCurso() {
        System.out.println("Identificador del curso a eliminar");
        String identificador = scanner.nextLine();
        
        if (eliminarCurso(identificador) == null) {
            System.out.println("falló");
        }
        else {
            System.out.println("Curso eliminado con exito.");
        }
    }
    
    // ------------------------------  MOSTRAR   ------------------------------ 
    public void mostrarCursosMenu() {
        int i;
        for (i = 0 ; i < listaCursos.size() ; i++) {
            System.out.println((i+1) + ". " + listaCursos.get(i).getIdentificador());
        }
    }
    
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
    
    public ArrayList<String> mostrarAsignaturasProfesor(Profesor profesor, Curso curso) {
        ArrayList<String> lista = profesor.getAsignaturasEnCurso(curso);
        for (int i = 0 ; i < lista.size() ; i++) {
            String asignatura = lista.get(i);
            System.out.println((i + 1) + ". " + asignatura);
        }
        return lista;
    }
    
    // ------------------------------  MOSTRAR SISTEMA  ------------------------------ 
    
    public void mostrarCursosSistema() {
        System.out.println("Cantidad de cursos registrados en el sistema: " + listaCursos.size());
        for (int i = 0 ; i < listaCursos.size() ; i++) {
            System.out.println((i + 1) + ". " +listaCursos.get(i).getIdentificador());
        }
    }
    
    public void mostrarProfesoresSistema() {
        System.out.println("Cantidad de profesores registrados en el sistema: " + listaProfesores.size());
        for (int i = 0 ; i < listaProfesores.size() ; i++) {
            Profesor profesor = listaProfesores.get(i);
            System.out.println((i + 1) + ". " + profesor.nombreApellido + " - " + profesor.rut );
        }
    }
    
    public void mostrarAlumnosSistema() {
        System.out.println("Cantidad de alumnos registrados en el sistema: " + listaAlumnos.size());
        for (int i = 0 ; i < listaCursos.size() ; i++) {
            Alumno alumno = listaAlumnos.get(i);
            System.out.println((i + 1) + ". " + alumno.nombreApellido + " - " + alumno.rut );
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
   
       //------------------------------ DATOS INICIALES  ------------------------------
    public void llenarDatos() {
        System.out.println("Cargando datos...");
        llenadoDeProfesores();
        llenadoDeCursos();
        llenadoDeAlumnos();
        System.out.println("Datos cargados correctamente");
    }
    
    public void llenadoDeProfesores(){
        try(Scanner sc = new Scanner(new File("data/profesores.csv"))){
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
         try(Scanner sc = new Scanner(new File("data/Alumnos.csv"))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] campos = linea.split(",");
                if(campos.length == 5){
                    String rut = campos[0].trim();
                    String nombre = campos[1].trim();
                    String correo = campos[2].trim();
                    String telefono = campos[3].trim();
                    String cursoID = campos[4].trim();
                    
                    Curso curso = buscarCursoSistema(cursoID);
                    if(curso != null)
                    {
                        Alumno alumno = new Alumno(rut, nombre, correo, telefono, curso);
                        listaAlumnos.add(alumno);
                        try{
                        curso.agregarAlumno(alumno);
                        } 
                        catch(AlumnoException error){
                            System.out.println("Error al agregar alumno: " + error.getMessage());
                        }
                    }
                    else{
                        System.out.println("Curso no encontrado para Alumno  "  + nombre + "->" + cursoID);
                    }
                }
            
            }
        }
         catch(FileNotFoundException e){
            System.out.println("Error al leer Alumnos.csv: " + e.getMessage());
        }
    }
    
    public void llenadoDeCursos(){
        try(Scanner sc  = new  Scanner(new File("data/Curso.csv"))){
            while(sc.hasNextLine()){
            String linea = sc.nextLine();
            String [] campos = linea.split(",");
            if(campos.length == 2)
            {
                String rutProfe = campos[0].trim();
                String identificador = campos[1].trim();
                Profesor jefe = buscarProfesorSistema(rutProfe);
                if(jefe != null)
                {
                    Curso curso = new Curso(jefe, identificador);
                    listaCursos.add(curso);
                }
                else{
                    System.out.println("No se encontro el profesor Jefe " +  rutProfe);
                }
            }
            
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Error al leer cursos.csv: " + e.getMessage());
        }
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
  
    // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    // ------------------------------------------------------------- MENU PROFESOR -------------------------------------------------------------
    // ------------------------------------------------------------- MENU PROFESOR -----------------------------------------------------------
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
    */
    // ------------------------------------------------------------- LOGIN -------------------------------------------------------------
    // ------------------------------------------------------------- LOGIN -------------------------------------------------------------
    // ------------------------------------------------------------- LOGIN -------------------------------------------------------------
    
    public void menuInicial () {
        System.out.println("Bienvenido");
        System.out.println("Ingrese su rut. Ej: 123456789");
        String rut = scanner.nextLine();
        
        if (rut.equals("Admin")) {
            //menuAdministador();
        }
        else {
            Alumno alumno;
            alumno = buscarAlumnoSistema(rut);
            if (alumno != null) {
                //menuAlumno(alumno);
            }
            else {
                Profesor profesor;
                profesor = buscarProfesorSistema(rut);
                if (profesor != null) {
                    //menuProfesor(profesor);
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
       ProyectoEscuela sistema = new ProyectoEscuela();
       sistema.llenarDatos();
       sistema.menuInicial();
       sistema.scanner.close();
    }
}
