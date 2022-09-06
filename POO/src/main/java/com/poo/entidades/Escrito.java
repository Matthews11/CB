package com.poo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "escritos")
@PrimaryKeyJoinColumn(name = "examenes_id")
public class Escrito extends Examen{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3044619498611022594L;

	@Column(name = "duracion_escrito")
	private Integer duracion;
	
	@Column(name = "nota_escrito")
	private Integer nota;

	public Escrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Escrito(Integer id, Integer duracion, Integer nota, Alumno alumno) {
		super(id,alumno);
		this.duracion = duracion;
		this.nota=nota;
	
		// TODO Auto-generated constructor stub
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
	
	
}
