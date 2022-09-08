package com.universidad.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.modelo.entidades.Pabellon;
import com.universidad.repositorios.PabellonRepositorio; 
import com.universidad.servicios.contratos.PabellonDAO;

@Service
public class PabellonDAOImpl extends GenericDAOImpl<Pabellon,PabellonRepositorio> implements PabellonDAO{

	@Autowired
	public PabellonDAOImpl(PabellonRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pabellon> findPabellonByDireccionLocalidad(String localidad) {
		// TODO Auto-generated method stub
		return repo.findPabellonByDireccionLocalidad(localidad);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Pabellon> findPabellonByNombre(String nombre) {
		// TODO Auto-generated method stub
		return repo.findPabellonByNombre(nombre);
	}
	
}
