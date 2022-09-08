package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Persona;

public interface ProfesorDAO {
	  Iterable<Persona> findProfesoresByCarrera(String carrera);

	    void crearPC(Integer id_p, Integer id_c);
}
