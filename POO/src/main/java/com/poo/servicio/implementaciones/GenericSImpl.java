package com.poo.servicio.implementaciones;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.poo.servicio.contratos.GenericS;

public class GenericSImpl <E, R extends CrudRepository<E, Integer>> implements GenericS<E>{
	
	private final R repo;
	
	public GenericSImpl(R repo) {
		this.repo=repo;
	}

	@Override
	public Iterable<E> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<E> obtener(Integer id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repo.findById(id)).orElse(null);
	}

	@Override
	public E crear(E e) {
		// TODO Auto-generated method stub
		return repo.save(e);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
