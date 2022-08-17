package com.evaluacion2.main;

import com.evaluacion2.dto.Departamento;
import com.evaluacion2.servicio.AdministracionServicioImpl;
import com.evaluacion2.servicio.IAdministracionServicio;

import java.sql.SQLException;
import java.util.Scanner;

public class MainDepa {
    private static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        IAdministracionServicio admin = new AdministracionServicioImpl();
        listarDepa(admin);
        insertarDepa(admin);
        listarDepa(admin);
        modificarDepa(admin);
        listarDepa(admin);
        obtenerDepa(admin);
        eliminarDepa(admin);
        listarDepa(admin);

    }

    public static void listarDepa (IAdministracionServicio ad)throws SQLException {
        ad.listarD().forEach(System.out::println);

    }
    public static void insertarDepa (IAdministracionServicio ad)throws SQLException {
        Departamento departamento = new Departamento();
        System.out.println("Ingresa el nombre de un nuevo departamento");
        departamento.setDepa(leer.nextLine());
        ad.guardarD(departamento);


    }
    public static void modificarDepa (IAdministracionServicio ad)throws SQLException {
        Departamento departamento = new Departamento();
        System.out.println("Ingresa el id para modificar el departamento");
        departamento.setId(Long.valueOf(leer.nextLine()));
        System.out.println("Ingresa el nombre del departamento");
        departamento.setDepa(leer.nextLine());
        ad.guardarD(departamento);

    }
    public static void obtenerDepa (IAdministracionServicio ad)throws SQLException {
        Departamento departamento = new Departamento();
        System.out.println("Ingresa el id para obtener el departamento");
        long id = Long.parseLong(leer.nextLine());
        departamento= ad.obtenerD(id);
        System.out.println(departamento);

    }
    public static void eliminarDepa (IAdministracionServicio ad)throws SQLException {
        System.out.println("Ingresa el id para eliminar el departamento");
        long id = Long.parseLong(leer.nextLine());
        ad.eliminarD(id);

    }

}
