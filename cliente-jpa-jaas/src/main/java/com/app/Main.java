package com.app;

import com.webapp.jaxws.jaas.services.Curso;
import com.webapp.jaxws.jaas.services.CursoServicesWs;
import com.webapp.jaxws.jaas.services.CursoServicesWsImplService;
import jakarta.xml.ws.BindingProvider;

import javax.naming.Binding;

public class Main {
    public static void main(String[] args) {
        CursoServicesWs cw = new CursoServicesWsImplService().getCursoServicesWsImplPort();

        ((BindingProvider)cw).getRequestContext().put(BindingProvider.USERNAME_PROPERTY,"mateo");
        ((BindingProvider)cw).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,"12345");

        Curso c = new Curso();
        c.setNombre("DOCKER");
        c.setDescripcion("DOCKER");
        c.setInstructor("melgar");
        c.setDuracion(100.1);
        cw.crear(c);
        cw.listar().forEach(ag->{
            System.out.println( ag.getNombre());
        });
    }
}
