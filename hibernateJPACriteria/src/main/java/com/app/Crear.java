package com.app;

import com.app.entity.Cliente;
import com.app.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.sql.SQLException;

public class Crear {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido");
            String pago = JOptionPane.showInputDialog("Ingrese el pago");

            em.getTransaction().begin();

            Cliente c = new Cliente();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.persist(c);
            em.getTransaction().commit();
            System.out.println("El id cliente registrado es: "+c.getId());
            c=em.find(Cliente.class,c.getId());
            System.out.println(c);
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
