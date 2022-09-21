package com.servicio.curso.service;

import com.servicio.curso.models.Usuario;
import com.servicio.curso.models.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    Optional<Curso> findById(Long id);

    Optional<Curso> findByIdUsuario(Long id);

    List<Curso> findAll();

    Curso save(Curso curso);

    void delete(Long id);

    void eliminarCursoUsuarioPorId(Long id );

    Optional<Usuario> asignarUsuario(Usuario usuario,Long id);
    Optional<Usuario> crearUsuario(Usuario usuario,Long id);
    Optional<Usuario> eliminarUsuario(Usuario usuario,Long id);
}
