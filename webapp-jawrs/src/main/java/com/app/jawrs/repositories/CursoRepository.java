package com.app.jawrs.repositories;


import com.app.jawrs.models.Curso;

import java.util.List;

public interface CursoRepository {

    List<Curso> listar();

    Curso guardar(Curso curso);

    Curso obtener(Long id);

    void eliminar(Long id);
}
