package com.universidad.servicios.implementaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;
import com.universidad.repositorios.AulaRepositorio;
import com.universidad.servicios.contratos.AulaDAO;

@Service
public class AulaDAOImpl extends GenericDAOImpl<Aula, AulaRepositorio> implements AulaDAO{

	@Autowired
	public AulaDAOImpl(AulaRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulaByPizarron(Pizarron pizarron) {
		// TODO Auto-generated method stub
		return repo.findAulaByPizarron(pizarron);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulaByPabellonNombre(String nombre) {
		// TODO Auto-generated method stub
		return repo.findAulaByPabellonNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Aula> findAulaByNroAula(Integer nro) {
		// TODO Auto-generated method stub
		return repo.findAulaByNroAula(nro);
	}
	

}
