package com.universidad.servicios.implementaciones;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmpleado;
import com.universidad.repositorios.EmpleadoRepositorio;
import com.universidad.repositorios.PersonaRepositorio;
import com.universidad.servicios.contratos.EmpleadoDAO;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {

	@Autowired
	public EmpleadoDAOImpl(@Qualifier("repo_empleado") PersonaRepositorio repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmplado) {
		// TODO Auto-generated method stub
		return ((EmpleadoRepositorio)repo).findEmpleadoByTipoEmpleado(tipoEmplado);
		
	}

}
