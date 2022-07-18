package palabra_static;

public class Main {

    public static void main(String[] args) {
        Persona p = new Persona("juan");
        System.out.println("Persona 1: "+ p);
        Persona p2 = new Persona("juancito");
        System.out.println("Persona 2: "+ p2);

        System.out.println("Numeros de personas: "+Persona.getContador());

    }
}
