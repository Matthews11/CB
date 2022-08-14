package com.app.main;

import com.app.servicio.AdministracionServicioImpl;
import com.app.servicio.IAdministracionServicio;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        IAdministracionServicio administracion = new AdministracionServicioImpl();
        administracion.listarR();
    }
}
