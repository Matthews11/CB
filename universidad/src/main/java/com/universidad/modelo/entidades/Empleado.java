package com.universidad.modelo.entidades;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn; 
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.universidad.modelo.entidades.enumeradores.TipoEmpleado;
@Entity
@Table(name="empleados")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3336565782832421547L;

	private BigDecimal sueldo;

	@Column(name = "tipo_empleado")
	@Enumerated(EnumType.STRING)
    private TipoEmpleado tipoEmplado;
	
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name="pabellon_id",foreignKey = @ForeignKey(name="FK_PABELLON_ID"))
	private Pabellon pabellon;

	public Empleado() {
		super();
		 
	}

	public Empleado(Integer id, String nombre, String apellido, String dni, Direccion direccion
			, BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
		super(id, nombre, apellido, dni, direccion);
		this.sueldo=sueldo;
		this.tipoEmplado=tipoEmpleado;
		 
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public TipoEmpleado getTipoEmplado() {
		return tipoEmplado;
	}

	public void setTipoEmplado(TipoEmpleado tipoEmplado) {
		this.tipoEmplado = tipoEmplado;
	}

	public Pabellon getPabellon() {
		return pabellon;
	}

	public void setPabellon(Pabellon pabellon) {
		this.pabellon = pabellon;
	}

	@Override
	public String toString() {
		return "Empleado [sueldo=" + sueldo + ", tipoEmplado=" + tipoEmplado + ", pabellon=" + pabellon + "]";
	}
	
	
	
	
    
    
}
