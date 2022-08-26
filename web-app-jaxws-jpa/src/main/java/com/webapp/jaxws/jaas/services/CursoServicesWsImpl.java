package com.webapp.jaxws.jaas.services;

import com.webapp.jaxws.jaas.models.Curso;
import com.webapp.jaxws.jaas.repository.CursoRepositoryImpl;
import com.webapp.jaxws.jaas.repository.CursoRepository;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;


//especifica ruta
@Stateless
@DeclareRoles({"ADMIN","USER"})
@WebService(endpointInterface = "com.webapp.jaxws.jaas.services.CursoServicesWs")
public class CursoServicesWsImpl implements CursoServicesWs {
    @Inject
    private CursoRepository cursoC;

    public CursoServicesWsImpl(){
        this.cursoC=new CursoRepositoryImpl();
    }


    @Override
    @WebMethod
    @RolesAllowed({"ADMIN","USER"})
    public List<Curso> listar() {
        return cursoC.listar() ;
    }


    @Override
    @WebMethod
    @RolesAllowed("ADMIN")
    public Curso crear(Curso curso) {
       cursoC.guardar(curso);
        return curso;
    }
}
