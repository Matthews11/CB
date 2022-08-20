package com.webapp.jaxws.repository;

import com.webapp.jaxws.ProducerEntityManager;
import com.webapp.jaxws.models.Curso;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import jakarta.persistence.EntityManager;
import org.hibernate.service.spi.InjectService;

import java.util.List;

@RequestScoped
public class CursoRepositoryImpl implements CursoRepository{

    @Inject
    private EntityManager em;

    @Override
    public List<Curso> listar() {
        return em.createQuery("select c from Curso c",Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        em.persist(curso);
        return curso;
    }
}
