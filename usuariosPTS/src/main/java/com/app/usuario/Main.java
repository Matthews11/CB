package com.app.usuario;

import com.app.usuario.dto.Usuario;
import com.app.usuario.service.AdministracionServiceImpl;
import com.app.usuario.service.IAdministracionService;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner l = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        IAdministracionService a = new AdministracionServiceImpl();
        System.out.println("-================listar=========");
        listar(a);
        System.out.println("-================Sesion=========");
        sesion(a);
    }

    public static void listar(IAdministracionService ia) throws SQLException {
        ia.listar().forEach(System.out::println);
    }
    public static void insertar(IAdministracionService ia) throws SQLException {
        Date fecha = new Date();
        Usuario usuario = new Usuario();
        System.out.println("Usuario");
        usuario.setUsuario(l.nextLine());
        System.out.println("password");
        usuario.setPassword(l.nextLine());
        usuario.setFecha(fecha);
        ia.guardar(usuario);
    }

    public static void sesion(IAdministracionService ia) throws SQLException {

        Usuario usuario = new Usuario();
        System.out.println("Usuario");
        usuario.setUsuario(l.nextLine());
        System.out.println("password");
        usuario.setPassword(l.nextLine());
        ia.comprobar(usuario);
    }

    public static void modificar(IAdministracionService ia) throws SQLException {
        Date fecha1 = new Date();
        Usuario usuario = new Usuario();
        System.out.println("id");
        usuario.setId(Long.valueOf(l.nextLine()));
        System.out.println("Usuario");
        usuario.setUsuario(l.nextLine());
        System.out.println("password");
        usuario.setPassword(l.nextLine());
        usuario.setFecha(fecha1);
        ia.guardar(usuario);
    }

    public static void eliminar(IAdministracionService ia) throws SQLException {
        System.out.println("Ingrese el id a eliminar");
        Long id = Long.valueOf(l.nextLine());
        ia.eliminar(id);
    }
}
