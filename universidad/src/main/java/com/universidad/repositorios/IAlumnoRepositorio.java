package com.universidad.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.universidad.modelo.entidades.Alumno;
import com.universidad.servicios.contratos.PersonaDAO;
@Repository("repo_alumno")
public interface IAlumnoRepositorio extends PersonaRepositorio{

}
