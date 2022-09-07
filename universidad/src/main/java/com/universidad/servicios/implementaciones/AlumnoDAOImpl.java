package com.universidad.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.modelo.entidades.Persona;
import com.universidad.repositorios.IAlumnoRepositorio;
import com.universidad.repositorios.PersonaRepositorio;
import com.universidad.servicios.contratos.AlumnoDAO;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO{

	@Autowired
	public AlumnoDAOImpl(@Qualifier("repo_alumno")PersonaRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> buscarAlumnoPorNombreCarrera(String carrera) {
		// TODO Auto-generated method stub
		return ((IAlumnoRepositorio)repo).buscarAlumnoPorNombreCarrera(carrera);
	}

}
