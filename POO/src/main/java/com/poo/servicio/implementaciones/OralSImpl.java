package com.poo.servicio.implementaciones;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service; 

import com.poo.entidades.Examen; 
import com.poo.repositorios.ExamenR; 
import com.poo.servicio.contratos.OralS;
@Service
public class OralSImpl extends GenericSImpl<Examen, ExamenR> implements OralS{

	@Autowired
	public OralSImpl(@Qualifier("repo_oral") ExamenR repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	
	 

}
