package com.universidad.repositorios;
 
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.universidad.modelo.entidades.Persona;
 
@Repository("repo_alumno")
public interface IAlumnoRepositorio extends PersonaRepositorio{

	@Query("select a from Alumno a join fetch a.carrera where a.carrera.nombre=?1")
	Iterable<Persona> buscarAlumnoPorNombreCarrera(String carrera);
}
