package com.webapp.jaxws.jaas.repository;

import com.webapp.jaxws.jaas.models.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> listar();
    Curso guardar(Curso curso);
}
