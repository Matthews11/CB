package com.universidad.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;

@Repository
public interface AulaRepositorio extends CrudRepository<Aula,Integer>{
	   Iterable<Aula>findAulaByPizarron(Pizarron pizarron);

	    Iterable<Aula>findAulaByPabellonNombre(String nombre);

	    Iterable<Aula>findAulaByNroAula(Integer nro);

}
