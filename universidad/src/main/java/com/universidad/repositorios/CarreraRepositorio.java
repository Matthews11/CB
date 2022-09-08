package com.universidad.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.universidad.modelo.entidades.Carrera;

@Repository("repo_carrera")
public interface CarreraRepositorio extends CrudRepository<Carrera, Integer> {

	Iterable<Carrera>findByNombreContains(String nombre);
	
	Iterable<Carrera>findByNombreContainsIgnoreCase(String nombre);
	
	Iterable<Carrera>findByCantidadAniosAfter(Integer anios);
	
	 @Query("select c from Carrera c inner join fetch c.profesors p where p.nombre=?1 and p.apellido=?2")
	    Iterable<Carrera> buscarCarreraPorProfesorNombreYApellido(String nombre, String apellido);

}
