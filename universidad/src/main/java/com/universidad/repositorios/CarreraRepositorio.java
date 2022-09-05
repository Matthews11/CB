package com.universidad.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.universidad.modelo.entidades.Carrera;

@Repository("repo_carrera")
public interface CarreraRepositorio extends CrudRepository<Carrera, Integer> {

}
