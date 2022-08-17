package com.evaluacion2.main;

import com.evaluacion2.dto.Departamento;
import com.evaluacion2.dto.Empleado;
import com.evaluacion2.servicio.AdministracionServicioImpl;
import com.evaluacion2.servicio.IAdministracionServicio;

import java.sql.SQLException;
import java.util.Scanner;

public class MainEm {
    private static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        IAdministracionServicio admin = new AdministracionServicioImpl();
        listarEm(admin);
        insertarEm(admin);
        listarEm(admin);
        modificarEm(admin);
        listarEm(admin);
        obtenerEm(admin);
        listarEm(admin);
        eliminarEm(admin);
        listarEm(admin);

    }

    public static void listarEm (IAdministracionServicio ad)throws SQLException {
        ad.listarP().forEach(System.out::println);

    }
    public static void insertarEm (IAdministracionServicio ad)throws SQLException {
        Empleado empleado = new Empleado();
        System.out.println("nombre");
        empleado.setNombre(leer.nextLine());
        System.out.println("apellido");
        empleado.setApellido(leer.nextLine());
        System.out.println("direccion");
        empleado.setDireccion(leer.nextLine());
        System.out.println("correo");
        empleado.setDireccion(leer.nextLine());
        Departamento depa = new Departamento();
        System.out.println("departamento");
        ad.listarD().forEach(System.out::println);
        depa.setId(Long.valueOf(leer.nextLine()));
        empleado.setDepa(depa);
        ad.guardarP(empleado);

    }
    public static void modificarEm (IAdministracionServicio ad)throws SQLException {
        Empleado empleado = new Empleado();
        System.out.println("Ingrese el id del emplado");
        empleado.setId(Long.valueOf(leer.nextLine()));
        System.out.println("nombre");
        empleado.setNombre(leer.nextLine());
        System.out.println("apellido");
        empleado.setApellido(leer.nextLine());
        System.out.println("direccion");
        empleado.setDireccion(leer.nextLine());
        System.out.println("correo");
        empleado.setDireccion(leer.nextLine());
        Departamento depa = new Departamento();
        System.out.println("departamento");
        ad.listarD().forEach(System.out::println);
        depa.setId(Long.valueOf(leer.nextLine()));
        empleado.setDepa(depa);
        ad.guardarP(empleado);

    }
    public static void obtenerEm (IAdministracionServicio ad)throws SQLException {
        Empleado empleado = new Empleado();
        System.out.println("Ingresa el id para obetener el empleado");
        long id = Long.parseLong(leer.nextLine());
        empleado= ad.obtenerP(id);
        System.out.println(empleado+"\n");

    }
    public static void eliminarEm (IAdministracionServicio ad)throws SQLException {
        System.out.println("Ingresa el id para eliminar el empleado");
        long id = Long.parseLong(leer.nextLine());
        ad.eliminarP(id);

    }

}
