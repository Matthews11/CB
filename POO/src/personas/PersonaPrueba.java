package personas;

public class PersonaPrueba {

    public static void main(String[] args) {

        Persona p1 = new Persona();

        System.out.println("valores por defecto");
        p1.desplegarNombre();

        p1.nombre="Juan";
        p1.apellidoPaterno="Esparza";
        p1.apellidoMaterno="Lara";

        System.out.println("\n Nuevos valores del objeto persona");
        p1.desplegarNombre();
    }


}
