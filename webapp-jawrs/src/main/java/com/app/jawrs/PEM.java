package com.app.jawrs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class PEM {
    @PersistenceContext(name =  "rsjpa")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    protected EntityManager beanEntityManager(){
        return entityManager;
    }
}
