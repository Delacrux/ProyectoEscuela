package com.mycompany.proyectoescuela;

public class Alumno extends Persona{
    // --------------- Atributos ---------------
    private Curso curso;
    
    // --------------- Constructor ---------------
    public Alumno(String rut, String nombre, String correo, String telefono, Curso curso) {
        super(rut, nombre, correo, telefono);
        this.curso = curso;
    }
    
    // --------------- Getter y Setter  ---------------
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    // --------------- Metodos ---------------
    @Override
    public void mostrarDatos()
    {
        System.out.println("Rut del alumno: " + rut);
        System.out.println("Nombre del alumno: " + nombreApellido);
        System.out.println("Curso del alumno: " + curso.getIdentificador());
        System.out.println("Correo del  alumno : " + correo);
        System.out.println("Telefono del alumno : " + telefono);
    }
    
}
