package com.universidad.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.modelo.entidades.Persona;
import com.universidad.repositorios.PersonaRepositorio;
import com.universidad.repositorios.ProfesorRepositorio;
import com.universidad.servicios.contratos.ProfesorDAO;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO{

	@Autowired
	public ProfesorDAOImpl(PersonaRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> findProfesoresByCarrera(String carrera) {
		// TODO Auto-generated method stub
		return ((ProfesorRepositorio)repo).findProfesoresByCarrera(carrera);
	}

	@Override
	@Transactional
	public void crearPC(Integer id_p, Integer id_c) {
		// TODO Auto-generated method stub
		((ProfesorRepositorio)repo).crearPC(id_p, id_c);
	}

}
