package com.app;

import com.app.entity.Cliente;
import com.app.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class Listar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select c from Cliente c",Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();
    }
}
