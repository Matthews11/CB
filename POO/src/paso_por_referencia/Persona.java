package paso_por_referencia;

public class Persona {
    String nombre;

    public void cambiarNombre(String nuevoNombre){
        this.nombre = nuevoNombre;
    }

    public String obtenerNombre(){
        return nombre;
    }
}
