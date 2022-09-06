package com.poo.servicio.implementaciones;
 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 

import com.poo.entidades.Examen; 
import com.poo.repositorios.ExamenR; 
import com.poo.servicio.contratos.ExamenS;
@Service
public class ExamenSImpl extends GenericSImpl<Examen, ExamenR> implements ExamenS{

	@Autowired
	public ExamenSImpl( ExamenR repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	 

}
