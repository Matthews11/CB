package com.clientesws;

import com.webapp.jaxws.services.Curso;
import com.webapp.jaxws.services.ServicesWs;
import com.webapp.jaxws.services.ServicesWsImplService;

public class Main {
    public static void main(String[] args) {
        ServicesWs services = new ServicesWsImplService().getServicesWsImplPort();
        System.out.println("el saludo "+ services.saludar("Jared"));

        Curso curso = new Curso();
        curso.setNombre("python");
        Curso respuesta = services.crear(curso);
        System.out.println("Nuevo curso "+ curso.getNombre());

        services.listar().forEach(c-> System.out.println(c.getNombre()));
    }
}
