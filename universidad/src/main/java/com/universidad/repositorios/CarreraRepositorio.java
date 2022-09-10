package com.universidad.repositorios;

import com.universidad.modelo.entidades.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepositorio extends CrudRepository<Carrera,Integer> {

    Iterable<Carrera> findCarreraByNombreContains(String nombre);

    Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre);

    Iterable<Carrera> findCarreraByCantidadAniosAfter(Integer anios);

    @Query("select c from Carrera c inner join fetch c.profesors p where p.nombre=?1 and p.apellido=?2")
    Iterable<Carrera> buscarCarreraPorProfesorNombreYApellido(String nombre, String apellido);
}
