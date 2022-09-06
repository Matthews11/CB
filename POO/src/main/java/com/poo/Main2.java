package com.poo;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.poo.entidades.Alumno;
import com.poo.entidades.Escrito;
import com.poo.entidades.Examen;
import com.poo.entidades.Oral;
import com.poo.entidades.Persona;
import com.poo.entidades.enumeradores.Satisfaccion;
import com.poo.servicio.implementaciones.AlumnoSImpl;
import com.poo.servicio.implementaciones.EscritoSImpl;
import com.poo.servicio.implementaciones.ExamenSImpl;
import com.poo.servicio.implementaciones.OralSImpl;
import com.poo.servicio.implementaciones.PersonaSImpl;
@Component
public class Main2 implements CommandLineRunner{

	@Autowired
	private PersonaSImpl ps;
	 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Alumno alumnos= new Alumno(null,"Jared","Pineda","MP200173");
//		ps.crear(alumnos);
//	 
//		
//		ps.eliminar(3);
//		ps.listar().forEach(System.out::println);

	}

}
