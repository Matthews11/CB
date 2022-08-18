package com.webapp.jaxws.services;

import com.webapp.jaxws.models.Curso;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface ServicesWs {
    String saludar(String persona);
    List<Curso> listar();
    Curso crear(Curso curso);

}