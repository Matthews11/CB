package com.poo.repositorios;

 
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository; 

import com.poo.entidades.Examen;
@Primary
public interface ExamenR extends CrudRepository<Examen, Integer>{

}
