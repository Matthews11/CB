package com.webapp.jaxws.jaas;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityManager  {

    @PersistenceContext(name =  "wsjpa")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    protected EntityManager beanEntityManager(){
        return entityManager;
    }
}
