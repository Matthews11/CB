package com.app;

import com.app.entity.Cliente;
import com.app.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.Scanner;

public class Eliminar {
    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente a eliminar");
        Long id = l.nextLong();
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Cliente cliente = em.find(Cliente.class,id);
            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
