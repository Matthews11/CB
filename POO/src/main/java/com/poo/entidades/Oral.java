package com.poo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
 

import com.poo.entidades.enumeradores.Satisfaccion;
@Entity
@Table(name = "orales")
@PrimaryKeyJoinColumn(name = "examen_id")
public class Oral extends Examen{

	/**
	 * 
	 */
	private static final long serialVersionUID = 14437533769100128L;
	
	@Column(name = "satisfaccion")
	@Enumerated(EnumType.STRING)
	private Satisfaccion satisfaccion;

	public Oral() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oral(Integer id, Alumno alumno, Satisfaccion satisfaccion) {
		super(id, alumno);
		this.satisfaccion = satisfaccion;
		// TODO Auto-generated constructor stub
	}

	public Satisfaccion getSatisfaccion() {
		return satisfaccion;
	}

	public void setSatisfaccion(Satisfaccion satisfaccion) {
		this.satisfaccion = satisfaccion;
	}

	@Override
	public String toString() {
		return "Oral [satisfaccion=" + satisfaccion + "]";
	}
	
	

}
