package com.webapp.jaxws.services;

import com.webapp.jaxws.models.Curso;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.Arrays;
import java.util.List;
//especifica ruta
@WebService(endpointInterface = "com.webapp.jaxws.services.ServicesWs")
public class ServicesWsImpl implements ServicesWs{

    private int contador;

    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println("Imprimiendo dentro del servicio web con instancia"+contador++);
        System.out.println("valor del contador en el metodo saludar es "+ contador);
        return "Hola, como estas pa ? "+persona;
    }

    @Override
    @WebMethod
    public List<Curso> listar() {

        return Arrays.asList(new Curso("java"), new Curso("spring "), new Curso("jakarta"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("curso guardado con exito "+curso.getNombre());
        Curso curso1 = new Curso(curso.getNombre());
        curso1.setNombre(curso.getNombre());
        return curso1;
    }
}
