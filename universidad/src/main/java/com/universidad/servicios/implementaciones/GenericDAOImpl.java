package com.universidad.servicios.implementaciones;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.universidad.servicios.contratos.GenericDAO;

public class GenericDAOImpl <E,R extends CrudRepository<E, Integer>> implements GenericDAO<E>{


	protected final R repo;
	
	public GenericDAOImpl(R repo) {
		this.repo=repo;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Optional<E> obtener(Integer id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.findById(id)).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<E> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT)
	public E crear(E e) {
		// TODO Auto-generated method stub
		return repo.save(e);
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	
	

}
