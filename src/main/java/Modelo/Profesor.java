package Modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Profesor extends Persona{
    // --------------- Atributos ---------------
    private String especialidad;
    private HashMap<Curso, ArrayList<String>> asignaturasPorCurso;
    
    // --------------- Constructor ---------------
    public Profesor(String rut, String nombreApellido, String especialidad, String correo, String telefono) {
        super(rut, nombreApellido, correo, telefono);
        this.especialidad = especialidad;
        this.asignaturasPorCurso = new HashMap< >();
    }
    
    // --------------- Getter y Setter  ---------------
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    // ---------------------- Métodos de HASHMAP ----------------------
    public HashMap< Curso , ArrayList<String>>  getAsignaturasPorCurso (){
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
    
    @Override
    public String mostrarDatos()
    {
        String mensaje = "Nombre: " + nombreApellido + "\n"
               + "Rut: " + rut + "\n"
               + "Especialidad: " + especialidad + "\n"
               + "Correo: " + correo + "\n"
               + "Numero de Telefono: " + telefono + "\n";
        return mensaje;
    }
    
}
