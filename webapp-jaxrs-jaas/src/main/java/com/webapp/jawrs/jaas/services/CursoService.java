package com.webapp.jawrs.jaas.services;

import com.webapp.jawrs.jaas.models.Curso;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface CursoService {

    List<Curso> listar();

    Curso guardar(Curso curso);

    Optional<Curso> obtener(Long id);

    void eliminar(Long id);
}
