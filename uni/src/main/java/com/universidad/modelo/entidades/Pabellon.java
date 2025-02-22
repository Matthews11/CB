package com.universidad.modelo.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pabellones")
public class Pabellon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "metros_cuadrados")
    @NotNull
    private Double mts2;

    @Column(name = "nombre_pabellones",unique = true,nullable = false)
    @NotEmpty
    private String nombre;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name ="codigoPostal",column = @Column(name = "codigo_postal")),
            @AttributeOverride(name = "dpto",column = @Column(name = "departamento"))
    })
    private Direccion direccion;

    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;

    @Column(name = "fecha_modificada")
    private LocalDateTime fechaModificada;

    @OneToMany(mappedBy = "pabellon",fetch = FetchType.EAGER)
    private Set<Aula> aulas;

    public Pabellon() {
    }

    public Pabellon(Integer id, Double mts2, String nombre, Direccion direccion) {
        this.id = id;
        this.mts2 = mts2;
        this.nombre = nombre;
        this.direccion = direccion;
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

    public void setFechaModificada(LocalDateTime fechaUltimaModificacion) {
        this.fechaModificada = fechaUltimaModificacion;
    }

    @PrePersist
    private void antesDePersistir(){this.fechaAlta=LocalDateTime.now();}
    @PreUpdate
    private void antesDeUpdate(){this.fechaAlta=LocalDateTime.now();}

    @Override
    public String toString() {
        return "Pabellon{" +
                "id=" + id +
                ", mts2=" + mts2 +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", fechaAlta=" + fechaAlta +
                ", fechaUltimaModificacion=" + fechaModificada +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return id.equals(pabellon.id) && nombre.equals(pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
