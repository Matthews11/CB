package com.universidad.modelo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "pabellones")
public class Pabellon implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5165657148035373275L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "metros_cuadrados")
	private Double mts2;

	@Column(name = "nombres_pabellones", unique = true, nullable = false)
	private String nombre;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal")),
			@AttributeOverride(name = "dpto", column = @Column(name = "departamento")) })
	private Direccion direccion;

	@Column(name = "fecha_alta")
	private LocalDateTime fechaAlta;

	@Column(name = "fecha_modificada")
	private LocalDateTime fechaModificada;

	@OneToMany(mappedBy = "pabellon", fetch = FetchType.LAZY)
	private Set<Aula> aulas;

	public Pabellon() {

	}

	public Pabellon(Integer id, Double mts2, String nombre, Direccion direccion, Set<Aula> aulas) {

		this.id = id;
		this.mts2 = mts2;
		this.nombre = nombre;
		this.direccion = direccion;
		this.aulas = aulas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getMts2() {
		return mts2;
	}

	public void setMts2(Double mts2) {
		this.mts2 = mts2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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

	public Set<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(Set<Aula> aulas) {
		this.aulas = aulas;
	}

	@PrePersist
	private void antesDePersistir() {
		this.fechaAlta = LocalDateTime.now();
	}

	@PreUpdate
	private void antesDeUpdate() {
		this.fechaAlta = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return "Pabellon [id=" + id + ", mts2=" + mts2 + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", fechaAlta=" + fechaAlta + ", fechaModificada=" + fechaModificada + ", aulas=" + aulas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pabellon other = (Pabellon) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

}
