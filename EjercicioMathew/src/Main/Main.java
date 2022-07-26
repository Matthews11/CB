package Main;

import modelo.Persona;
import service.PersonaImpl;
import service.PersonaService;
import Exception.*;
import java.util.ArrayList;
import java.util.List;
/*excepciones= objeto nulo, inicializado pero vacio, edad menor 100 y mayor a 0,
 lista vacia y solo permite tener 100 objetos (simulacion, lista puede tener bastante pero queria probar)la lista*/
public class Main {
    public static void main(String[] args) throws DatosEx {
        Persona p = new Persona();
        PersonaService ps = new PersonaImpl();
        List<Persona> lista = new ArrayList<>();

         insertar(ps,p);
        listar(ps,lista);
        simultaneas(ps,p,lista);
    }
    public static void insertar(PersonaService ps, Persona p){
        try {
            ps.ingresar(p);

        } catch (InsertarEx ie){
            System.out.println("Ocurrio un error al insertar");
            ie.printStackTrace();
        }   catch (Exception e){
            e.printStackTrace();
            System.out.println("Ocurrio un error general");
        }
    }

    public static void listar(PersonaService ps, List<Persona> lista){
        try {

            lista = ps.listar();
        }  catch (ListarEx ie){
            System.out.println("Ocurrio un error al listar");
            ie.printStackTrace();
        }  catch (Exception e){
            e.printStackTrace();
            System.out.println("Ocurrio un error general");
        }
    }

    public static void simultaneas(PersonaService ps, Persona p, List<Persona> lista){
        try {
            ps.ingresar(p);
            lista = ps.listar();
        } catch (InsertarEx ie){
            System.out.println("Ocurrio un error al insertar");
            ie.printStackTrace();
        } catch (ListarEx ie){
            System.out.println("Ocurrio un error al listar");
            ie.printStackTrace();
        }  catch (Exception e){
            e.printStackTrace();
            System.out.println("Ocurrio un error general");
        }
    }
}
