package manejopersonas;

import datos.PersonasJDBC;
import domain.Persona;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        PersonasJDBC jdbc = new PersonasJDBC();
      // jdbc.insert("Alberto","juarez");
       // jdbc.update(1,"mathew","pineda");
        jdbc.delete(10);


        List<Persona> personas = jdbc.select(2);
        for (Persona p : personas) {
            System.out.println(p);
        }

    }
}
