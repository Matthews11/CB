package com.universidad.modelo.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7216118567814036952L;

	@ManyToOne(optional = true,fetch =FetchType.EAGER,cascade ={
			 CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
	
	public Alumno() {
		super();
		 
	}

	public Alumno(Integer id, String nombre, String apellido, String dni,  Direccion direccion,Carrera carrera) {
		super(id, nombre, apellido, dni,  direccion);
		this.carrera=carrera;
	}
	
	

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	

	@Override
	public String toString() {
		return super.toString()+"Alumno [carrera=" + carrera + "]";
	}

	 
	
	

}
