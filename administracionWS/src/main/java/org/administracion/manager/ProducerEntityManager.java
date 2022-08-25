package org.administracion.manager;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityManager {

    @PersistenceContext(name = "adminWS")
    private EntityManager em;

    @Produces
    @RequestScoped
    private EntityManager getEm(){
        return em;
    }


}
