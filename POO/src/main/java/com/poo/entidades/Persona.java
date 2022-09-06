package com.poo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4280404204645349877L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre_p", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "apellido_p", nullable = false, length = 50 )
	private String apellido;
	
	@Column(name = "carnet_p", nullable = false, length = 20 )
	private String carnet;
	
	@Column(name = "fecha_registro_p", nullable = false)
	private LocalDateTime fecha;
	
	
	
	
	public Persona() {}

	
	
	public Persona(Integer id, String nombre, String apellido, String carnet   ) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.carnet = carnet; 
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	
	

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	
	@PrePersist
	private void persistirFecha() {
		this.fecha = LocalDateTime.now();
	}
	@PreUpdate
	private void persistirFechaa() {
		this.fecha = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", carnet=" + carnet + ", fecha= "+fecha+"]";
	}
	
	

}
