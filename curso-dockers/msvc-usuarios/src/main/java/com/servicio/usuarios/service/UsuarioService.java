package com.servicio.usuarios.service;

import com.servicio.usuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    void delete(Long id);

    List<Usuario> listarPorIds(Iterable<Long> ids);


    Optional<Usuario> findByMail(String mail);

    boolean existsByMail(String mail);

}
