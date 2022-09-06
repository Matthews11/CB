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
public class Main implements CommandLineRunner{

	@Autowired
	private PersonaSImpl ps;
	
	@Autowired
	private AlumnoSImpl as;
	
	@Autowired
	public ExamenSImpl ess;
	
	@Autowired
	
	public OralSImpl os;
	@Autowired
	private EscritoSImpl es;
	
	
	@Override
	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		Alumno alumnos= new Alumno(null,"Jared","Pineda","MP200173");
//	//	as.crear(alumnos);
//		
//		Escrito escrito = new Escrito(null,20,10, alumnos);
////		Oral oral = new Oral(null, alumnos,Satisfaccion.EXCELENTE);
//		
//		es.crear((Escrito) escrito);
//
//		
////		os.crear((Oral) oral);
//		
//		
//		as.listar().forEach(System.out::println);
//		es.listar().forEach(System.out::println); 
//		
		
//		ps.eliminar(3);
//		ps.listar().forEach(System.out::println);

	}

}
