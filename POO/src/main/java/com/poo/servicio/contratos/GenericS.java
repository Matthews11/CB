package com.poo.servicio.contratos;

import java.util.Optional;
 

public interface GenericS <E>{

	Iterable<E> listar();
	
	Optional<E> obtener(Integer id);
	
	E crear(E e);
	
	void eliminar(Integer id);
}
