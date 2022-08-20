package com.app;

import com.webapp.jaxws.services.Curso;
import com.webapp.jaxws.services.CursoServicesWs;
import com.webapp.jaxws.services.CursoServicesWsImplService;

public class Main {
    public static void main(String[] args) {
        CursoServicesWs cw = new CursoServicesWsImplService().getCursoServicesWsImplPort();
        Curso c = new Curso();
        c.setNombre("angular");
        c.setDescripcion("angular3.0");
        c.setInstructor("melgar");
        c.setDuracion(100.2);
        cw.crear(c);
        System.out.println("curso registrado: "+c.getNombre());
        System.out.println("Lista de cursos registrados");
        cw.listar().forEach(curso -> {
            System.out.println(curso.getNombre());
        });
    }
}
