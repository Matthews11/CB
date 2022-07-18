package palabrathis;

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("Calo");
    }
}

class Persona{
    String nombre;

    Persona(String nombre){
        this.nombre=nombre;

        Imprimir i = new Imprimir ();
        i.imprimir(this);
    }
}

class Imprimir{

    public void imprimir(Object o){
        System.out.println("Imprimir parametros: "+o);
        System.out.println("Imprimir objeto actual: "+this);
    }
}