package com.poo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="examenes")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Examen implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7744025135033542382L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fecha_examen")
	private LocalDateTime fecha;
	
	@OneToOne(mappedBy = "examen",cascade = CascadeType.ALL)
	private Alumno alumno;
	
	public Examen() {}

	public Examen(Integer id,Alumno alumno ) {
		super();
		this.id = id; 
		this.alumno=alumno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	@PrePersist
	public void fecha() {
		this.fecha = LocalDateTime.now();
	}

	@PreUpdate
	public void fechaa() {
		this.fecha = LocalDateTime.now();
	}
	@Override
	public String toString() {
		return "Examen [id=" + id + ", fecha=" + fecha + "]";
	}
	
	
	
}
