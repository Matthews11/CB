package com.universidad.modelo.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
 

import com.universidad.modelo.entidades.enumeradores.Pizarron;
@Entity
@Table(name = "aulas")
public class Aula implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7532000974120174933L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "numero_aula",nullable = false)
	private Integer nroAula;
	
	@Column(name = "medidas_mtsxmts")
	private String medidad;
	
	@Column(name = "cantidad_pupitres")
	private Integer cantidad;
	
	@Column(name="tipo_pizarron")
	@Enumerated(EnumType.STRING)
	private Pizarron pizarron;
	
	@Column(name = "fecha_alta")
	private LocalDateTime fechaAlta;
	
	@Column(name = "fecha_modificada")
	private LocalDateTime fechaModificada;
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST,CascadeType.MERGE} )
	@JoinColumn(name = "pabellon_id",foreignKey = @ForeignKey(name="FK_PABELLON_ID"))
	private Pabellon pabellon;
	
	
	
	public Aula() {
		super();
	}
	public Aula(Integer id, Integer nroAula, String medidad, Integer cantidad, Pizarron pizarron,
			LocalDateTime fechaAlta, LocalDateTime fechaModificada, Pabellon pabellon) {
		super();
		this.id = id;
		this.nroAula = nroAula;
		this.medidad = medidad;
		this.cantidad = cantidad;
		this.pizarron = pizarron;
		this.fechaAlta = fechaAlta;
		this.fechaModificada = fechaModificada;
		this.pabellon = pabellon;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNroAula() {
		return nroAula;
	}
	public void setNroAula(Integer nroAula) {
		this.nroAula = nroAula;
	}
	public String getMedidad() {
		return medidad;
	}
	public void setMedidad(String medidad) {
		this.medidad = medidad;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Pizarron getPizarron() {
		return pizarron;
	}
	public void setPizarron(Pizarron pizarron) {
		this.pizarron = pizarron;
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
	public Pabellon getPabellon() {
		return pabellon;
	}
	public void setPabellon(Pabellon pabellon) {
		this.pabellon = pabellon;
	}
	
	@PrePersist
	public void antesDePersistir() {
		this.fechaAlta = LocalDateTime.now();
	}
	@PreUpdate
	public void antesDeUpdate() {
		this.fechaModificada= LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "Aula [id=" + id + ", nroAula=" + nroAula + ", medidad=" + medidad + ", cantidad=" + cantidad
				+ ", pizarron=" + pizarron + ", fechaAlta=" + fechaAlta + ", fechaModificada=" + fechaModificada
				+ ", pabellon=" + pabellon + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, nroAula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aula other = (Aula) obj;
		return Objects.equals(id, other.id) && Objects.equals(nroAula, other.nroAula);
	}
	
	

}
