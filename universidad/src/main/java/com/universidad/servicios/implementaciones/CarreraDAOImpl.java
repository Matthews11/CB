package com.universidad.servicios.implementaciones;

 

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

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findByNombreContains(String nombre) {
		// TODO Auto-generated method stub
		return repo.findByNombreContains(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findByNombreContainsIgnoreCase(String nombre) {
		// TODO Auto-generated method stub
		return repo.findByNombreContainsIgnoreCase(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> findByCantidadAniosAfter(Integer anios) {
		// TODO Auto-generated method stub
		return repo.findByCantidadAniosAfter(anios);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Carrera> buscarCarreraPorProfesorNombreYApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return repo.buscarCarreraPorProfesorNombreYApellido(nombre, apellido);
	}
	
	 
}
