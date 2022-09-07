package com.universidad.repositorios;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.universidad.modelo.entidades.Persona;
@Primary()
public interface PersonaRepositorio extends CrudRepository<Persona, Integer>{

	@Query("select p from Persona p where p.nombre=?1 and p.apellido=?2")
	Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
	
	@Query("select p from Persona p where p.dni=?1")
	Optional<Persona> buscarPorNombreDni(String dni);
	
	@Query("select p from Persona p where p.apellido=?1")
	Iterable<Persona> buscarPorApellido(String apellido);
	
}
