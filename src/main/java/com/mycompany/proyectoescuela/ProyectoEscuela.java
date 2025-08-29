package com.mycompany.proyectoescuela;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    public void mostrarAsignaturasMenu(ArrayList<Asignatura> lista){
        int i;
        System.out.println("Asignaturas en Curso:");
        for(i = 0; i<lista.size(); i++){
            System.out.println((i+1) + ") "+ lista.get(i).getNombreAsignatura());
        }
        
    }
    
    // ------------------------------  Métodos menú ------------------------------ 
    public Asignatura getAsignaturaPorMenu(ArrayList<Asignatura> lista, int opcion) {
        if( opcion > lista.size() || opcion < 0){
            System.out.println("Indice fuera de rango: 0-"+lista.size());
            return null;
        }
        return lista.get((opcion-1));
    }
    
    public Curso getCursoPorMenu(ArrayList<Curso> lista, int opcion) {
        if( opcion > lista.size() || opcion < 0){
            System.out.println("Indice fuera de rango: 0-"+lista.size());
            return null;
        }
        return lista.get((opcion-1));
    }
    
    public void gestionarAgregarNota(Asignatura materia) {
        System.out.println("Rut del alumno al que desea agregar la nota");
        String rutAlumno = scanner.nextLine();
        Alumno student = buscarAlumnoSistema(rutAlumno);
        
        if(student==null){
            System.out.println("Alumno no encontrado");
            return;
        }
        
        System.out.println("Ingresar la calificación.");
        String notaString = scanner.nextLine();
        
        float nota = Float.parseFloat(notaString);
        
        System.out.println("Ingresar el detalle de la nota");
        String detalle = scanner.nextLine();
        
        Nota notaAlumno = new Nota(nota, detalle);
        materia.agregarNotaAlumno(buscarAlumnoSistema(rutAlumno), notaAlumno);
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
   
       //------------------------------Datos Iniciales ------------------------------
    public void llenarDatos() {
    // ---------------------- 1. Crear y Conectar Profesores y Asignaturas ----------------------
    // Se crean los objetos 'Profesor'
        Profesor prof1 = new Profesor("123456789", "María González", "Licenciatura en Matemáticas", "maria.gonzalez@pucv.cl", "+56 9 1234 5678");
        Profesor prof2 = new Profesor("156782345", "Jorge Ramírez", "Educación Física", "jorge.ramirez@pucv.cl", "+56 9 2345 6789");
        Profesor prof3 = new Profesor("184567890", "Camila Soto", "Lenguaje", "camila.soto@pucv.cl", "+56 9 3456 7890");

    // Se añaden los profesores a la lista maestra del Sistema
        listaProfesores.add(prof1);
        listaProfesores.add(prof2);
        listaProfesores.add(prof3);

    // Se crean las asignaturas. El profesor se asigna en el constructor.
        Asignatura a1 = new Asignatura(prof1, "Matemáticas");
        Asignatura a2 = new Asignatura(prof2, "Educación Física y Salud");
        Asignatura a3 = new Asignatura(prof3, "Lenguaje y Comunicación");

    // Se añaden las asignaturas a la lista de cada profesor
        prof1.agregarAsignatura(a1);
        prof2.agregarAsignatura(a2);
        prof3.agregarAsignatura(a3);

    // ---------------------- 2. Crear y Conectar el Curso y sus Asignaturas ----------------------
    // Se crea el curso
        Curso curso1 = new Curso(prof1, "1° Básico");

    // Se añaden las mismas instancias de asignaturas al curso
        curso1.agregarAsignatura(a1);
        curso1.agregarAsignatura(a2);
        curso1.agregarAsignatura(a3);

    // Se añade el curso a la lista maestra del Sistema
        listaCursos.add(curso1);
    
    // ---------------------- 3. Crear y Conectar Alumnos al Curso y Asignaturas ----------------------
    // Se crean los alumnos
    // Asegúrate de que este constructor de Alumno (rut, curso, nombre, correo, telefono)
    // coincide con la definición de tu clase Alumno.
        Alumno alumno1 = new Alumno("201234567", "1° Básico", "Pedro Rojas", "pedro.rojas@mail.com", "+56 9 12345678");
        Alumno alumno2 = new Alumno("212345678", "1° Básico", "Ana Perez", "ana.perez@mail.com", "+56 9 23456789");
    
    // Se añaden los alumnos a la lista maestra del Sistema
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);

    // Se matriculan los alumnos en el curso
        curso1.agregarAlumno(alumno1);
        curso1.agregarAlumno(alumno2);
    
    // Y lo más importante: se enlazan los alumnos a cada asignatura del curso
    // Esto asegura que sus datos de notas se puedan guardar y mostrar
        for(Asignatura asignatura : curso1.getListaAsignaturas()){
            asignatura.agregarNotaAlumno(alumno1, null);
            asignatura.agregarNotaAlumno(alumno2, null);
        }

    // ---------------------- 4. Agregar Datos de Prueba para Comprobar la Conexión ----------------------
    // Agregar notas al alumno1 en Matemáticas
        Nota nota1 = new Nota(6.5f, "Evaluación de la unidad 1");
        Nota nota2 = new Nota(5.8f, "Prueba de la unidad 2");
        a1.agregarNotaAlumno(alumno1, nota1);
        a1.agregarNotaAlumno(alumno1, nota2);

    // Agregar un recurso digital a la asignatura de Lenguaje
        RecursosDigitales recurso1 = new RecursosDigitales("Guía de Comprensión Lectora", "https://ejemplo.com/guia", "Material de apoyo para la prueba.");
        a3.agregarRecursoDigital(recurso1);
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
                    materia.mostrarAlumnos();
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
       ProyectoEscuela sistema = new ProyectoEscuela();
       sistema.llenarDatos();
       sistema.menuInicial();
       sistema.scanner.close();
    }
}
