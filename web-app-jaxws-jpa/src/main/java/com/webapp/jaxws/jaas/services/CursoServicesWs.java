package com.webapp.jaxws.jaas.services;

import com.webapp.jaxws.jaas.models.Curso;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface CursoServicesWs {

    List<Curso> listar();
    Curso crear(Curso curso);

}