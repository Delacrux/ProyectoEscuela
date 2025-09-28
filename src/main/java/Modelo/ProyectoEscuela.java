package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Set;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

// ----------- Clase ProyectoEscuela -----------
public class ProyectoEscuela {
    // ------------------------------------------------------------- Atributos  -------------------------------------------------------------
    private ArrayList<Profesor> listaProfesores;
    private ArrayList<Alumno> listaAlumnos;
    private ArrayList<Curso> listaCursos;
    private Scanner scanner;
    private static int totalProfesores = 0;
    private static int totalAlumnos= 0;
    private static int totalCursos = 0;
    private static int totalAsignaturas = 0;
    
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
    
    // ------------------------------ FUNCIONALIDAD PARA EL NEGOCIO + SOBRECARGA DE METODO ------------------------------
    
    public HashMap < String , Curso > asignaturaConMasRecursos() {
        HashMap <String, Curso> asignaturasMayores = new HashMap<>();
        int cantMayorRecursos = -1;
        
        for (int i = 0 ; i < listaCursos.size() ; i++ ) {
            Curso curso = listaCursos.get(i);
            ArrayList <String> asignaturasCurso = new ArrayList<>(curso.getRecursosPorAsignatura().keySet());
            
            for (int k = 0 ; k < asignaturasCurso.size() ; k ++) {
                String asignatura = asignaturasCurso.get(k);
                int cantRecAsignatura = curso.getRecursosPorAsignatura().get(asignatura).size();
                
                if ( cantRecAsignatura > cantMayorRecursos ) {
                    cantMayorRecursos = cantRecAsignatura;
                    asignaturasMayores.clear();
                    asignaturasMayores.put(asignatura, curso);
                }
                else if ( cantRecAsignatura == cantMayorRecursos ) {
                    asignaturasMayores.put(asignatura, curso);
                }
            }
        }
        return asignaturasMayores;
    }
    
    public HashMap < String , Curso > asignaturaConMasRecursos(int umbral) {
        HashMap <String, Curso> asignaturasMayores = new HashMap<>();
        
        for (int i = 0 ; i < listaCursos.size() ; i++ ) {
            Curso curso = listaCursos.get(i);
            ArrayList <String> listaAsignaturas = new ArrayList<>(curso.getRecursosPorAsignatura().keySet());
            
            for (int k = 0 ; k < listaAsignaturas.size() ; k++ ) {
                String asignatura = listaAsignaturas.get(k);
                if ( curso.getRecursosPorAsignatura().get(asignatura).size() >= umbral) {
                    asignaturasMayores.put(asignatura, curso);
                }
            }
        }
        return asignaturasMayores;
    }
    
    // ------------------------------ Métodos listas de asignaturas  ------------------------------
    
    public ArrayList<String> listaAsignaturasDisponibles() {
        Set<String> listaAsigOcupadas = listaAsignaturasDeProfesores();
        
        ArrayList<String> listaTodasLasAsignaturas = listaAsignaturasTotales();
        Set<String> todasLasAsignaturasSet = new HashSet<>(listaTodasLasAsignaturas);
         
        todasLasAsignaturasSet.removeAll(listaAsigOcupadas);
        
        ArrayList<String> listaAsigDisponibles = new ArrayList<>( todasLasAsignaturasSet );
        return listaAsigDisponibles;
    }
    
    public Set<String> listaAsignaturasDeProfesores() {
        Set<String> lista = new HashSet<>();
        
        for ( Profesor profesor : listaProfesores ) {
            for (ArrayList <String> listaAsignaturas : profesor.getAsignaturasPorCurso().values()) {
                    lista.addAll(listaAsignaturas);
            }
        }
        return lista;
    }
    
    public ArrayList<String> listaAsignaturasTotales() {
        Set<String> listaTodasLasAsignaturas = new HashSet<>();
        for ( Curso curso : listaCursos ) {
            listaTodasLasAsignaturas.addAll(curso.getRecursosPorAsignatura().keySet());
        }
        ArrayList<String> lista = new ArrayList<>( listaTodasLasAsignaturas );
        return lista;
    }
    
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
    
    // ------------------------------  ELIMINAR  ------------------------------ 
    public Alumno eliminarAlumno(String rutAlumno) throws AlumnoException {
        Alumno alumno = buscarAlumnoSistema(rutAlumno);
        if (alumno != null) {
            Curso cursoAlumno = alumno.getCurso();
            if (cursoAlumno != null) {
                cursoAlumno.eliminarAlumno(alumno);
                listaAlumnos.remove(alumno);
                return alumno;
            }
        }
        return null;
    }
    
    public Curso eliminarCurso(String identificador) {
        Curso curso = buscarCursoSistema(identificador);
        if (curso != null) {
            for ( Alumno alumno : listaAlumnos) {
                if ( alumno.getCurso() != null && alumno.getCurso().equals(curso)) {
                    alumno.setCurso(null);
                }
            }
            for ( Profesor profesor : listaProfesores) {
                profesor.getAsignaturasPorCurso().remove(curso);
            }
            listaCursos.remove(curso);
            return curso;
        }
        return null;
    }
   
       //------------------------------ DATOS INICIALES  ------------------------------
    public void llenarDatos() {
        System.out.println("Cargando datos...");
        llenadoDeCursos();
        llenadoDeProfesores();
        llenadoDeAlumnos();
        System.out.println("Datos cargados correctamente");
    }

    //------------------------------ Llenado de Datos  ------------------------------
    private ArrayList <String []> leerLineasProfesores(String rutaArchivo ){
        ArrayList<String[]> registros = new ArrayList<>();
        try (Scanner sc  = new Scanner (new File(rutaArchivo))){
            boolean primeraLinea = true; 
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                if(primeraLinea)
                {
                    primeraLinea = false;
                    continue; 
                }
                String [] campos  = linea.split(",");
                if(campos.length != 5)
                {
                    System.out.println("Línea invalida en profesores.csv:  " + linea);
                    continue;
                }
                registros.add(campos);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error al leer profesores.csv:  " + e.getMessage());
        }
        return registros; 

    }
    private Profesor crearProfesor(String [] campos){
        return new Profesor(campos[0].trim(), campos[1].trim(),campos[2].trim(), campos[3].trim(),campos[4].trim());
        
    }
    private ArrayList <String []> leerLineasProfesorCurso(String rutaArchivo ){
        ArrayList<String[]> registros = new ArrayList<>();
        try (Scanner sc  = new Scanner (new File(rutaArchivo))){
            boolean primeraLinea = true; 
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                if(primeraLinea)
                {
                    primeraLinea = false;
                    continue; 
                }
                String [] campos  = linea.split(",");
                registros.add(campos);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error al leer Profesor_Curso.csv:  " + e.getMessage());
        }
        return registros; 

    }
    private boolean asignarCursoJefe(Profesor profesor){
        for(Curso c : listaCursos){
            if(c.getProfesorJefe() == null){
                c.setProfesorJefe(profesor);
            }
                
                ArrayList<String[]> registros = leerLineasProfesorCurso ("data/Profesor_Curso.csv");
                HashMap<Curso,ArrayList<String>>  mapa;
                
                for(String[] campos :  registros){
                    mapa = new HashMap<>();
                    String rut = campos[0].trim();
                    String id = campos[1].trim();
                    
                    if(c.getIdentificador().equals(id) && profesor.getRut().equals(rut))
                    {
                         ArrayList<String>asig = new ArrayList<>();
                         for(int  i = 2; i < campos.length; i++){
                             asig.add(campos[i]);
                         }
                         mapa.put(c,asig);
                         profesor.setAsignaturasPorCurso(mapa);
                    }
                   
                }
                
        }
        System.out.println("No hay cursos disponibles para asignar al profesor  " + profesor.getNombreApellido());
        return false;
    }
    
    public void llenadoDeProfesores(){
        ArrayList<String[]> registros = leerLineasProfesores ("data/profesores.csv");
        for(String[] campos :  registros){
            Profesor profesor = crearProfesor (campos);
            asignarCursoJefe(profesor);
            listaProfesores.add(profesor); 
        }
    }
 
 
  public void llenadoDeAlumnos() {
    try (Scanner sc = new Scanner(new File("data/Alumnos.csv"))) {
        boolean primeraLinea = true;
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            if (primeraLinea) {
                primeraLinea = false;
                continue;
            }

            String[] campos = linea.split(",");
            if (campos.length != 5) {
                System.out.println("Línea inválida en Alumnos.csv: " + linea);
                continue;
            }

            String rut = campos[0].trim();
            String nombreApellido = campos[1].trim();
            String correo = campos[2].trim();
            String telefono = campos[3].trim();
            String cursoID = campos[4].trim();

            
            Curso cursoAsignado = null;
            for (Curso c : listaCursos) {
                if (c.getIdentificador().equalsIgnoreCase(cursoID)) {
                    cursoAsignado = c;
                    break;
                }
            }

            if (cursoAsignado != null) {
                try {
                    Alumno alumno = new Alumno(rut, nombreApellido, correo, telefono, cursoAsignado);
                    cursoAsignado.agregarAlumno(alumno);
                    System.out.println("Alumno " + nombreApellido + " asignado al curso " + cursoID);
                    listaAlumnos.add(alumno);
                } catch (AlumnoException e) {
                    System.out.println("Error al agregar alumno " + nombreApellido + ": " + e.getMessage());
                }
            }
            
            else {
                System.out.println("Curso no encontrado para alumno " + nombreApellido + ": " + cursoID);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Error al leer Alumnos.csv: " + e.getMessage());
    }
}
    public void llenadoDeAsignaturas(Curso curso) {
        try (Scanner sc = new Scanner(new File("data/Asignaturas.csv"))) {
            boolean primeraLinea = true;
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                String[] campos = linea.split(",");
                if (campos.length >= 5) {
                    String cursoCSV = campos[0].trim();
                    if (curso.getIdentificador().equals(cursoCSV)) {
                        String asignatura = campos[1].trim();

                        String titulo = campos[2].trim();
                        String url = campos[3].trim();
                        String detalle = campos[4].trim();

                        if (!curso.getRecursosPorAsignatura().containsKey(asignatura)) {
                            try {
                                curso.agregarAsignatura(asignatura);
                                System.out.println("Asignatura " + asignatura + " agregada correctamente al curso " + curso.getIdentificador());
                            } catch (AsignaturaException e) {
                                System.out.println("Error al agregar Asignatura: " + e.getMessage());
                            }
                        }

                        try {
                            curso.agregarRecursoDigital(asignatura, new RecursoDigital(titulo, url, detalle));
                        } catch (AsignaturaException error) {
                            System.out.println("Error al agregar recurso: " + error);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer Asignaturas.csv: " + e.getMessage());
        }
    }



    public void llenadoDeCursos(){
        try(Scanner sc  = new  Scanner(new File("data/Curso.csv"))){
            boolean  primeraLinea = true; 
            while(sc.hasNextLine()){
            String linea = sc.nextLine();
            if(primeraLinea){
            primeraLinea = false;
            continue; // salta  el encabezado
            }
            String identificador = linea.trim();
            Curso curso = new Curso (null,identificador); 
            
            llenadoDeAsignaturas(curso);
            
            listaCursos.add(curso);
            }
        }catch(FileNotFoundException e){
            System.out.println("Error al leer cursos.csv: " + e.getMessage());
        }
    }
  //------------------------------ Generación de reporte  ------------------------------
    
    public void actualizarEstadisticas( ){
        totalProfesores = listaProfesores.size();
        totalAlumnos = listaAlumnos.size();
        totalCursos = listaCursos.size();
        totalAsignaturas = listaAsignaturasTotales().size();
    }
    private String encabezadoReporte(){
        StringBuilder sb = new StringBuilder();
        sb.append("Reporte de Gestión Escolar\n");
        sb.append("=========================\n\n");
        sb.append("Estadísticas Generales:\n");
        sb.append("Total Profesores: ").append(totalProfesores).append("\n");
        sb.append("Total Alumnos: ").append(totalAlumnos).append("\n");
        sb.append("Total Cursos: ").append(totalCursos).append("\n");
        sb.append("Total Asignaturas: ").append(totalAsignaturas).append("\n\n");
        return sb.toString();
    }
    
    private String  reporteProfesores(){
        StringBuilder sb = new StringBuilder();
        sb.append("Profesores:\n");
        for (Profesor p : listaProfesores ){
            sb.append("- ").append(p.getRut()).append(" | ").append(p.getNombreApellido()).append(" | ").append(p.getEspecialidad()).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
    private String reporteCursos (){
        StringBuilder sb = new StringBuilder();
        sb.append("Cursos:\n");
        for (Curso c : listaCursos){
            sb.append("- ").append(c.getIdentificador()).append("\n"); 
        }
        sb.append("\n");
        return sb.toString();
    }
    private String reporteAsignaturas(){
        StringBuilder sb = new StringBuilder();
        sb.append("Asignaturas:\n");
        for (String a : listaAsignaturasTotales()){
            sb.append("- ").append(a).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
    
    
    public void generarReporte(){
        actualizarEstadisticas();
        File carpeta  = new File("data"); 
        if(!carpeta.exists()) carpeta.mkdir();
        try(BufferedWriter bw  = new BufferedWriter (new FileWriter("data/reporte.txt"))){
            bw.write(encabezadoReporte());
            bw.write(reporteProfesores());
            bw.write(reporteCursos());
            bw.write(reporteAsignaturas());
            System.out.println("Reporte generado correctamente en 'data/reporte.txt'.");
        }catch (IOException e){
            System.out.println("error al generar reporte: " + e.getMessage());
        }
        
        
    }
    //------------------------------ Guardado de datos  ------------------------------
    public void guardarCursos() {
    File carpeta = new File("data");
    if (!carpeta.exists()) {
        carpeta.mkdir();
    }
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/Curso.csv"))) {
        bw.write("Identificador");
        bw.newLine();

        for (Curso curso : listaCursos) {
            bw.write(curso.getIdentificador());
            bw.newLine();
        }
        System.out.println("Cursos guardados correctamente.");
    } catch (IOException e) {
        System.out.println("Error al guardar cursos: " + e.getMessage());
    }
}

    public void guardarAlumnos() {
        File carpeta = new File("data");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/Alumnos.csv"))) {
            bw.write("Rut,NombreApellido,Correo,Telefono,Curso");
            bw.newLine();

            for (Alumno alumno : listaAlumnos) {
                String linea = String.join(",",
                    alumno.getRut(),
                    alumno.getNombreApellido(),
                    alumno.getCorreo(),
                    alumno.getTelefono(),
                    alumno.getCurso().getIdentificador()
                );
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Alumnos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar alumnos: " + e.getMessage());
        }
    }

    public void guardarAsignaturas() {
        File carpeta = new File("data");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/Asignaturas.csv"))) {
            // Escribir encabezado del CSV
            bw.write("Curso,Asignatura,Titulo,URL,Detalle");
            bw.newLine();

            // Recorrer todos los cursos y escribir sus asignaturas
            for (Curso curso : listaCursos) {
                escribirAsignaturasCurso(bw, curso);
            }
            System.out.println("Asignaturas guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar asignaturas: " + e.getMessage());
        }
    }

    private void escribirAsignaturasCurso(BufferedWriter bw, Curso curso) throws IOException {
        String idCurso = curso.getIdentificador();

        // Recorrer asignaturas y recursos digitales
        for (String asignatura : curso.getRecursosPorAsignatura().keySet()) {
            ArrayList<RecursoDigital> recursos = curso.getRecursosPorAsignatura().get(asignatura);

            for (RecursoDigital recurso : recursos) {
                String linea = crearLineaCSV(idCurso, asignatura, recurso);
                bw.write(linea);
                bw.newLine();
            }
        }
    }

    private String crearLineaCSV(String curso, String asignatura, RecursoDigital recurso) {
        // Crear línea del CSV con valores separados por coma
        return String.join(",",curso,asignatura,recurso.getTituloMaterial(),recurso.getUrl(),recurso.getDetalles());
    }


    public void leerAsignaturasGuardadas() {
        File carpeta = new File("data");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    try (BufferedReader br = new BufferedReader(new FileReader("data/asignaturas.csv"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
    } catch (IOException e) {
        System.out.println("Error al leer asignaturas guardadas: " + e.getMessage());
    }
}

    public void guardarProfesores(){
        File carpeta = new File("data");
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
        try(BufferedWriter bw  = new BufferedWriter(new FileWriter ("data/profesores.csv"))){
            bw.write("Rut,NombreApellido,Especialidad,Correo,Telefono");
            bw.newLine();
            
            for (Profesor profe: listaProfesores){
            String linea = String.join(",",profe.getRut(), profe.getNombreApellido(),profe.getEspecialidad(),
                    profe.getCorreo(), profe.getTelefono()
            );
            bw.write(linea);
            bw.newLine();
            }
        }catch(IOException e ){
            System.out.println("Error al guardar profesores:  " + e.getMessage());
        }
        
        try(BufferedWriter bw  = new BufferedWriter(new FileWriter ("data/Profesor_Curso.csv"))){
            bw.write("RutProfesor,IdCurso,Asignaturas");
            bw.newLine();
            
            for (Profesor profe: listaProfesores){
                Curso cursoSeleccionado = profe.getAsignaturasPorCurso().keySet().iterator().next();
                String linea = String.join(",",profe.getRut(),cursoSeleccionado.getIdentificador() ,String.join(",", profe.getAsignaturasEnCurso(cursoSeleccionado)));
                bw.write(linea);
                bw.newLine();
            }
        }catch(IOException e ){
            System.out.println("Error al guardar profesores:  " + e.getMessage());
        }
        
    }
    public void guardadoDeDatos()
    {
        guardarProfesores();
        guardarAlumnos();
        guardarCursos();
        guardarAsignaturas();
        leerAsignaturasGuardadas();
    }
    
    // ------------------------------------------------------------- MAIN  -------------------------------------------------------------
    public static void main(String[] args) {
       ProyectoEscuela sistema = new ProyectoEscuela();
       sistema.llenarDatos();
       sistema.generarReporte();
       sistema.guardadoDeDatos();
       sistema.scanner.close();
    }
}
