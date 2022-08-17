package com.app;

import com.app.entity.Cliente;
import com.app.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class SingleRW {
    private static final Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class);
        System.out.println("Ingrese una forma de pago\n" +
                "1. debito \n" +
                "2. credito \n" +
                "3. paypal \n");

        String pago=leer.nextLine();
        query.setParameter(1,pago);
        query.setMaxResults(1);

        Cliente c = (Cliente)query.getSingleResult();
        System.out.println(c);
        em.close();
    }
}
