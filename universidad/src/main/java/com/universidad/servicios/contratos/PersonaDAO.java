package com.universidad.servicios.contratos;
 
 
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.universidad.modelo.entidades.Persona;

public interface PersonaDAO  extends GenericDAO<Persona>{ 
	@Query("select p from Persona p where p.nombre=?1 and p.apellido=?2")
	Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido);
	
	@Query("select p from Persona p where p.dni=?1")
	Optional<Persona> buscarPorNombreDni(String dni);
	
	@Query("select p from Persona p where p.apellido=?1")
	Iterable<Persona> buscarPorApellido(String apellido);

}
