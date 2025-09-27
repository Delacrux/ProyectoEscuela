package Modelo;

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
    public String mostrarDatos()
    {
        String mensaje = "Nombre: " + nombreApellido + "\n"
               + "Rut: " + rut + "\n"
               + "Curso: " + curso.getIdentificador() + "\n"
               + "Correo: " + correo + "\n"
               + "Numero de telefono: " + telefono + "\n";
        return mensaje;
    }
    
}