package com.universidad.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.universidad.modelo.entidades.Persona;
import com.universidad.repositorios.PersonaRepositorio;

@Service
public class AlumnoDAOImpl extends GenericDAOImpl<Persona,PersonaRepositorio>{

	@Autowired
	public AlumnoDAOImpl(@Qualifier("repo_alumno")PersonaRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

}
