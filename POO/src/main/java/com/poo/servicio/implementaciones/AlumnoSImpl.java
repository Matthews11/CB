package com.poo.servicio.implementaciones;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service; 
 
import com.poo.entidades.Persona; 
import com.poo.repositorios.PersonaR;
import com.poo.servicio.contratos.AlumnoS;
@Service
public class AlumnoSImpl extends GenericSImpl<Persona, PersonaR> implements AlumnoS{

	@Autowired
	
	public AlumnoSImpl(@Qualifier("repo_alumno")PersonaR repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	 

}
