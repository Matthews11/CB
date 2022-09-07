package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Carrera;

public interface CarreraDAO extends GenericDAO<Carrera> {
	Iterable<Carrera> findByNombreContains(String nombre);

	Iterable<Carrera> findByNombreContainsIgnoreCase(String nombre);

	Iterable<Carrera> findByCantidadAniosAfter(Integer anios);
}
