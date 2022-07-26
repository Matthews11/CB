package service;

import Exception.*;
import modelo.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaImpl implements PersonaService{

    private ArrayList<Persona> lista = new ArrayList<>();

    @Override
    public void ingresar(Persona persona) throws InsertarEx {
        Persona p = new Persona();
        if(persona.getApellido()==null && persona.getNombre()==null && persona.getEdad()==0){
             throw new InsertarEx("Error el Objeto esta nullo");
        }if(persona.getApellido()=="" && persona.getNombre()=="" && persona.getEdad()==0){
            throw new InsertarEx("Error el Objeto esta vacio");
        }else {
            lista.add(persona);
            //lista.add(p);
        }
    }

    @Override
    public List<Persona> listar() throws ListarEx {

        if (lista.isEmpty()){
            throw new ListarEx("La lista esta vacia");
        }//simulamos que no puede aceptar mas de 100 objetos
        if (lista.size()>100){
            throw new ListarEx("Solo se permite tener 100 objeto");
        }else{
            for (Persona l: lista){
            System.out.println("los objectos son: "+l);
            }
        }
        return lista;
    }
}
