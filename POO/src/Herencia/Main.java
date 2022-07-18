package Herencia;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Empleado e1 = new Empleado("Calo",25000);
        System.out.println("Empleado 1");
        System.out.println(e1);

        Empleado e2 = new Empleado("Pedro",100);
        e2.setEdad(50);
        e2.setGenero('M');
        e2.setDireccion("Bogota, colombia");
        System.out.println("\n Empleado 2");
        System.out.println(e2);

        Cliente c1 = new Cliente(new Date(),false);
        System.out.println("\n Cliente 1");
        System.out.println(c1);
        c1.setNombre("Karla");
        c1.setGenero('F');
        c1.setEdad(22);
        c1.setDireccion("Mexico, DF");
        System.out.println("\n se vuelve a imprimir el cliente1");
        System.out.println(c1);
    }
}
