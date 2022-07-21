package test;

import herencia.*;

import java.util.Date;

public class TestHerencia {
    public static void main(String[] args) {

        Empleado empleado1 = new Empleado("Jared",1000);
      //  System.out.println(empleado1);

        Empleado empleado2 = new Empleado("Calos",3271);
     //   System.out.println(empleado2);

      //  System.out.println( empleado2.obtenerDetalle());
        imprimir(empleado1);
        imprimir(empleado2);

        var fecha = new Date();
        Cliente cliente1 = new Cliente("Juan",'M',40,"Soya",fecha,true);
       // System.out.println(cliente1);

        Persona persona = new Persona("alfonso",'M',32,"ITA");


        imprimir(cliente1);

    }

    public static void imprimir(Persona persona){
        System.out.println(persona.obtenerDetalle());
    }
}
