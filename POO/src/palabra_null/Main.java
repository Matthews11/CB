package palabra_null;

public class Main {

    public static void main(String[] args) {
        Persona p1 = new Persona("Calo");
        System.out.println(p1.obtenerNombre());
    }
}

class Persona{

    private String nombre;

    public Persona(String nombre){
        this.nombre=nombre;
    }

    public String obtenerNombre(){
        return this.nombre;
    }


}
