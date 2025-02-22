package com.app.jawrs.repositories;

import com.app.jawrs.models.Curso;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;
@RequestScoped
public class CursoRepositoryImpl implements CursoRepository{

    @Inject
    private EntityManager em;

    @Override
    public List<Curso> listar() {
        return em.createQuery("from Curso ",Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        if (curso.getId()!=null && curso.getId()>0){
            em.merge(curso);
        }else {
            em.persist(curso);
        }
        return curso;
    }

    @Override
    public Curso obtener(Long id) {
        return em.find(Curso.class,id);
    }

    @Override
    public void eliminar(Long id) {
        Curso c = em.find(Curso.class,id);
        em.remove(c);
    }
}
