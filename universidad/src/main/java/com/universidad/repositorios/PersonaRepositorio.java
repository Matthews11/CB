package com.universidad.repositorios;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;

import com.universidad.modelo.entidades.Persona;
@Primary()
public interface PersonaRepositorio extends CrudRepository<Persona, Integer>{

}
