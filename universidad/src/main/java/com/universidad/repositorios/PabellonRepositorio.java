package com.universidad.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.universidad.modelo.entidades.Pabellon;

@Repository
public interface PabellonRepositorio extends CrudRepository<Pabellon, Integer>{
	 Iterable<Pabellon> findPabellonByDireccionLocalidad(String localidad);

	    Iterable<Pabellon> findPabellonByNombre(String nombre);

}
