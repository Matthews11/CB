package com.universidad.servicios.implementaciones;

 

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.modelo.entidades.Persona;
import com.universidad.repositorios.PersonaRepositorio;
import com.universidad.servicios.contratos.PersonaDAO;
@Service
public class PersonaDAOImpl extends GenericDAOImpl<Persona, PersonaRepositorio> implements PersonaDAO{

	@Autowired
	public PersonaDAOImpl( PersonaRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.buscarPorNombreYApellido(nombre, apellido)).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Persona> buscarPorNombreDni(String dni) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.buscarPorNombreDni(dni)).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return  repo.buscarPorApellido(apellido);
	}
	 
}
