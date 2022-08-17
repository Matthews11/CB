package com.app;

import com.app.entity.Cliente;
import com.app.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class porId {
    private static final Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        System.out.println("Ingrese el id");
        long id= Long.parseLong(leer.nextLine());
        Cliente cliente = em.find(Cliente.class,id);
        System.out.println(cliente);
        em.close();
    }
}
