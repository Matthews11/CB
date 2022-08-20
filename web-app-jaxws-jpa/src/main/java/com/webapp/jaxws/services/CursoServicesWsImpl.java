package com.webapp.jaxws.services;

import com.webapp.jaxws.models.Curso;
import com.webapp.jaxws.repository.CursoRepository;
import com.webapp.jaxws.repository.CursoRepositoryImpl;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;

import java.util.List;
//especifica ruta
@Stateless
@WebService(endpointInterface = "com.webapp.jaxws.services.CursoServicesWs")
public class CursoServicesWsImpl implements CursoServicesWs {

    @Inject
    private CursoRepository cursoC;

    public CursoServicesWsImpl(){
        this.cursoC=new CursoRepositoryImpl();
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        return cursoC.listar() ;
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
       cursoC.guardar(curso);
        return curso;
    }
}
