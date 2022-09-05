package com.universidad.servicios.implementaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.modelo.entidades.Carrera;
import com.universidad.repositorios.CarreraRepositorio;
import com.universidad.servicios.contratos.CarreraDAO;
@Service
public class CarreraDAOImpl extends GenericDAOImpl<Carrera,CarreraRepositorio> implements CarreraDAO{

	@Autowired
	public CarreraDAOImpl(CarreraRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	 
}
