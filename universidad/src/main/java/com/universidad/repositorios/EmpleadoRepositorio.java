package com.universidad.repositorios;

import org.springframework.data.jpa.repository.Query; 
import org.springframework.stereotype.Repository;

import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmpleado;

@Repository("repo_empleado")
public interface EmpleadoRepositorio extends PersonaRepositorio {

	 @Query("select e from Empleado e where e.tipoEmplado=?1")
	    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmplado);

}
