package com.webapp.jawrs.jaas.services;

import com.webapp.jawrs.jaas.models.Curso;
import com.webapp.jawrs.jaas.repositories.CursoRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class CursoServiceImpl implements CursoService {

    @Inject
    private CursoRepository cr;

    @Override
    public List<Curso> listar() {
        return cr.listar();
    }

    @Override
    public Curso guardar(Curso curso) {
        return cr.guardar(curso);
    }

    @Override
    public Optional<Curso> obtener(Long id) {
        return Optional.ofNullable(cr.obtener(id));
    }

    @Override
    public void eliminar(Long id) {
        cr.eliminar(id);
    }
}
