package com.servicio.usuarios.service;

import com.servicio.usuarios.clients.CursoClienteRest;
import com.servicio.usuarios.models.entity.Usuario;
import com.servicio.usuarios.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;


    @Autowired
    private CursoClienteRest cliente;


    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return Optional.ofNullable(repo.findById(id)).orElse(null);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
        cliente.eliminarCursoUsuarioPorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarPorIds(Iterable<Long> ids) {
        return (List<Usuario>) repo.findAllById(ids);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Usuario> findByMail(String mail) {
        return Optional.ofNullable(repo.findByMail(mail)).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public boolean existsByMail(String mail) {
        return repo.existsByMail(mail);
    }


}
