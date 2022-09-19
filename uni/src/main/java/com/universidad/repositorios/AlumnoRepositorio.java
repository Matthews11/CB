package com.universidad.repositorios;

import com.universidad.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repo_alumno")
public interface AlumnoRepositorio extends PersonaRepositorio {

    @Override
    @Query("select p from Alumno p inner join Persona a on p.id=a.id")
    Iterable<Persona> findAll();

    @Query("select a from Alumno a  join fetch a.carrera where a.carrera.nombre=?1")
    Iterable<Persona> buscarAlumnosPorNombreCarrera(String nombre);
}
