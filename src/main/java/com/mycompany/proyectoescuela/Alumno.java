package com.mycompany.proyectoescuela;

public class Alumno {
    // --------------- Atributos ---------------
    private String rut;
    private String nombreApellido;
    private String correo;
    private String telefono;
    private Curso curso;
    
    // --------------- Constructor ---------------
    public Alumno(String rut, String nombre, String correo, String telefono, Curso curso) {
        this.rut = rut;
        this.nombreApellido = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.curso = curso;
    }
    
    // --------------- Getter y Setter  ---------------
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
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
    // --------------- Metodos ---------------
    public void mostrarDatosAlumno()
    {
        System.out.println("Rut del alumno: " + rut);
        System.out.println("Nombre del alumno: " + nombreApellido);
        System.out.println("Curso del alumno: " + curso.getIdentificador());
        System.out.println("Correo del  alumno : " + correo);
        System.out.println("Telefono del alumno : " + telefono);
        
        
    }
    
    
    
    
}
