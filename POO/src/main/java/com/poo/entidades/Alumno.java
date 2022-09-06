package com.poo.entidades;
  

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "personas_id")
public class Alumno extends Persona{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7777289712710633899L;
	
	@OneToOne(optional = true, cascade  = CascadeType.ALL)
	@JoinColumn(name = "examen_id",foreignKey = @ForeignKey(name="FK_EXA_ID"))
	private Examen examen;

	public Alumno() {
		super();
		 
	}

	public Alumno(Integer id, String nombre, String apellido, String carnet) {
		super(id, nombre, apellido, carnet);
		// TODO Auto-generated constructor stub
	}
	
	

}
