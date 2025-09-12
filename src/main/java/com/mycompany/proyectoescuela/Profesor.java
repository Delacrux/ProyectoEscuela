package com.mycompany.proyectoescuela;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Profesor {
    // --------------- Atributos ---------------
    private String rut;
    private String nombreApellido;
    private String especialidad;
    private String correo;
    private String telefono;
    private HashMap<Curso, ArrayList<String>> asignaturasPorCurso;
    
    // --------------- Constructor ---------------
    public Profesor(String rut, String nombreApellido, String especialidad, String correo, String telefono) {
        this.rut = rut;
        this.nombreApellido = nombreApellido;
        this.especialidad = especialidad;
        this.correo = correo;
        this.telefono = telefono;
        this.asignaturasPorCurso = new HashMap< >();
    }
    // --------------- Getter y Setter  ---------------
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    // ---------------------- Métodos de HASHMAP ----------------------
    public HashMap< Curso , ArrayList<String>>  GetAsignaturasPorCurso (){
        return this.asignaturasPorCurso;
    }
    public void setAsignaturasPorCurso(HashMap< Curso , ArrayList<String>>  aux) {
        this.asignaturasPorCurso = aux;
    }
    
    // Coleccion de claves
    public Set<Curso> getCursosAsignados() {
        return this.asignaturasPorCurso.keySet();
    }
    
    public ArrayList<String> getAsignaturasEnCurso(Curso curso) {
        if (asignaturasPorCurso.containsKey(curso)) {
            return asignaturasPorCurso.get(curso);
        }
        return null;
    }
    
    
    
    public void informacionContactoProfesor(){
        System.out.println("Profesor: " + nombreApellido);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Correo: " + correo);
        System.out.println("Telefono:" + telefono);
        
    }
    
}
