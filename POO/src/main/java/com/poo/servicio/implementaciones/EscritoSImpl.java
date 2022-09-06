package com.poo.servicio.implementaciones;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service; 
import com.poo.entidades.Examen; 
import com.poo.repositorios.ExamenR;
import com.poo.servicio.contratos.EscritoS;
@Service
public class EscritoSImpl extends GenericSImpl<Examen, ExamenR> implements EscritoS{

	@Autowired
	public EscritoSImpl(@Qualifier("repo_escrito") ExamenR repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}
	 

}
