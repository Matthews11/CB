package com.universidad.modelo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
 
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -521372643005319431L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 80)
	private String nombre;

	@Column(nullable = false, length = 80)
	private String apellido;

	@Column(nullable = false, unique = true, length = 80)
	private String dni;

	@Column(name = "fecha_alta")
	private LocalDateTime fechaAlta;

	@Column(name = "fecha_modificada")
	private LocalDateTime fechaModificada;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
			@AttributeOverride(name = "dpto", column = @Column(name = "departamento")) })
	private Direccion direccion;

	public Persona() {
		super();
	}

	public Persona(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.direccion = direccion;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDateTime getFechaModificada() {
		return fechaModificada;
	}

	public void setFechaModificada(LocalDateTime fechaModificada) {
		this.fechaModificada = fechaModificada;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaAlta="
				+ fechaAlta + ", fechaModificada=" + fechaModificada + ", direccion=" + direccion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(id, other.id);
	}

}
