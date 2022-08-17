package com.app;

import com.app.entity.Cliente;
import com.app.util.JpaUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class Editar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Long id = Long.valueOf(JOptionPane.showInputDialog("ingrese el  id del pibe"));
            Cliente c = em.find(Cliente.class,id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre", c.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido", c.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrese el pago",c.getFormaPago());
            em.getTransaction().begin();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setFormaPago(pago);
            em.merge(c);
            em.getTransaction().commit();

            System.out.println(c);
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
    }
}
