package com.universidad;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.universidad.modelo.entidades.Carrera;
import com.universidad.servicios.contratos.CarreraDAO;
@Component
public class CommandRun implements CommandLineRunner {

	@Autowired
	private CarreraDAO cd;
	
	@Override
	public void run(String... args) throws Exception {
//	Carrera carrera = new Carrera(null,"Ing",20,30);
	 
	Carrera carry = null;
	
	Optional<Carrera> carreraOptional=cd.obtener(1);
	
	if (carreraOptional.isPresent()) {
		carry=carreraOptional.get();
		System.out.println(carry);
	}else {
		System.out.println("Carrera no encontrada");
	}
	 
	carry.setCantidadMaterias(100);
	carry.setCantidadAnios(200);
	
	cd.crear(carry);	
	System.out.println(cd.obtener(1).orElse(new Carrera()).toString());
	cd.eliminar(1);
	System.out.println(cd.obtener(1).orElse(new Carrera()).toString());
	
	
	
	
	}

}
