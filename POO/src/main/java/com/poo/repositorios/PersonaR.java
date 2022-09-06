package com.poo.repositorios;

import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository; 

import com.poo.entidades.Persona;
@Primary
public interface PersonaR extends CrudRepository<Persona, Integer> {

}
