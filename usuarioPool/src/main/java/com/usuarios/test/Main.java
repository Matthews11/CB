package com.usuarios.test;

import com.usuarios.dao.Repositorio;
import com.usuarios.dao.UsuarioImpl;
import com.usuarios.dto.User;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Repositorio<User> repositorio = new UsuarioImpl();
        System.out.println("listar ===========================");
        repositorio.listAll().forEach(System.out::println);

  /*      User user = new User();
        user.setUser("HASHI");
        user.setPassword("12345");
        user.setDate(new Date());
        System.out.println("insertar ===========================");
        repositorio.save(user);
         repositorio.listAll().forEach(System.out::println);
*/
       /* User user = new User();
        user.setId(2L);
        user.setUser("KRAUS");
        user.setPassword("123");
        user.setDate(new Date());
        System.out.println("actualizar ===========================");
        repositorio.save(user);
        repositorio.listAll().forEach(System.out::println);
        */
     /*   System.out.println("Obtener================");
        System.out.println(repositorio.listById(2l));
*/
        System.out.println("ELiminar ============================");
        repositorio.delete(2L);
        repositorio.listAll().forEach(System.out::println);

    }
}
