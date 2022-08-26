package com.webapp.jaxws.jaas.models;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name="cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private String descripcion;

    //@JsonbTransient quita la relacion de la tabla  @@XmlTransient
    //@JsonIgnore
    @Transient
    private String instructor;

    private Double duracion;

    public Curso() {
    }

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getDuracion() {
        return duracion;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

}
