package com.poo.servicio.implementaciones;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
 
import com.poo.entidades.Persona; 
import com.poo.repositorios.PersonaR;
import com.poo.servicio.contratos.PersonaS;
@Service
public class PersonaSImpl extends GenericSImpl<Persona, PersonaR> implements PersonaS{

	@Autowired
	public PersonaSImpl(PersonaR repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
 
}
