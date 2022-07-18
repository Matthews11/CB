package palabra_static;

public class Persona {

    private String nombre;

    private int id;

    private static int contador;

    public Persona(String nombre){
        contador++;
        id=contador;
        this.nombre=nombre;
    }

    @Override
    public String toString(){
        return "Persona [ id: "+id+", nombre: "+nombre+"]";
    }

    public static int getContador(){
        return contador;
    }

}
