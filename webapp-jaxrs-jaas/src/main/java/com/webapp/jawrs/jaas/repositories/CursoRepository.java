package com.webapp.jawrs.jaas.repositories;
import com.webapp.jawrs.jaas.models.Curso;

import java.util.List;

public interface CursoRepository {

    List<Curso> listar();

    Curso guardar(Curso curso);

    Curso obtener(Long id);

    void eliminar(Long id);
}
