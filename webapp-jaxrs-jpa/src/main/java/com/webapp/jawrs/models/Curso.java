package com.webapp.jawrs.models;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlTransient;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;

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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

}
