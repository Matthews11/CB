package com.webapp.jawrs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class PEM {
    @PersistenceContext(name = "rs")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    protected EntityManager beanEntityManager(){
        return entityManager;
    }
}
