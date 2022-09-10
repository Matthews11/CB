package com.universidad.servicio.contratos;

import com.universidad.modelo.entidades.Carrera;

import java.util.Optional;

public interface CarreraDAO extends GenericDAO<Carrera>{


    Iterable<Carrera> findCarreraByNombreContains(String nombre);

    Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre);

    Iterable<Carrera> findCarreraByCantidadAniosAfter(Integer anios);

    Iterable<Carrera> buscarCarreraPorProfesorNombreYApellido(String nombre, String apellido);


}
