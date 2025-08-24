package com.mycompany.proyectoescuela;
import java.util.ArrayList;
public class Profesor {
    // --------------- Atributos ---------------
    private String rut;
    private String nombreApellido;
    private ArrayList <String> listaCursosDeProfe;
    private String especialidad;
    private String correo;
    private String telefono;
    
    // --------------- Constructor ---------------
    public Profesor(String rut, String nombreApellido, String especialidad, String correo, String telefono) {
        this.rut = rut;
        this.nombreApellido = nombreApellido;
        this.listaCursosDeProfe = new ArrayList<String>();
        this.especialidad = especialidad;
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
    public void agregarCurso(String curso){
        listaCursosDeProfe.add(curso);
    }
    public void quitarCurso(String curso){
        listaCursosDeProfe.remove(curso);
        
    }
    
    
}
