package com.universidad.servicios.implementaciones;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
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
	 
}
