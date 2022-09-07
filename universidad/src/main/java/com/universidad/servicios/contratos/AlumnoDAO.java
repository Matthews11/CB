package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Persona;

public interface AlumnoDAO extends PersonaDAO{
	Iterable<Persona> buscarAlumnoPorNombreCarrera(String carrera);
}
