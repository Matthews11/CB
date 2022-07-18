package paso_por_referencia;

public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.cambiarNombre("Juan");
        imprimirNombre(persona);
        modificarPersona(persona);
        imprimirNombre(persona);
    }

    public static void modificarPersona(Persona arg){
        arg.cambiarNombre("Calo");
    }
    public static void imprimirNombre(Persona p){
        System.out.println("Valor recibido: "+p.obtenerNombre());
    }
}
