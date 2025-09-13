package com.mycompany.proyectoescuela;

public class Persona {
    protected String rut;
    protected String nombreApellido;
    protected String correo;
    protected String telefono;
    
    public Persona(String rut, String nombreApellido, String correo, String telefono) {
        this.rut = rut;
        this.nombreApellido = nombreApellido;
        this.correo = correo;
        this.telefono = telefono;
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
    public void mostrarDatos()
    {
        System.out.println("Rut: " + rut);
        System.out.println("Nombre " + nombreApellido);
        System.out.println("Correo: " + correo);
        System.out.println("Telefono: " + telefono);
    }
    
}