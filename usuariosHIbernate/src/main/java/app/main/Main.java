package app.main;

import app.entity.Usuarios;
import app.service.AdministracionService;
import app.service.AdministracionServiceImpl;

import java.util.Date;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        AdministracionService admin = new AdministracionServiceImpl();
        Usuarios usuario =new Usuarios();
       // usuario.setId(6L);
        usuario.setUsuario("gg");
        usuario.setPassword("123");
        Date fecha = new Date();
        usuario.setFecha(fecha);
        System.out.println("listando");
        admin.listar().forEach(System.out::println);
        System.out.println("obtener");
        Optional<Usuarios> usuarios= admin.obtener(1L);
        System.out.println(usuarios);

       // System.out.println("guardar");
      //  admin.guardarU(usuario);
     //   admin.listar().forEach(System.out::println);
       //  System.out.println("eliminar");
       // admin.eliminarU(6l);
      //  admin.listar().forEach(System.out::println);
    }
}
