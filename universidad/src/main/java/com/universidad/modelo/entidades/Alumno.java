package com.universidad.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "alumno")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona   {
    @ManyToOne(optional = true,
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE}
    )
    @JoinColumn(name = "carrera_id")
    @JsonIgnoreProperties({"alumnos","profesors"})

    private Carrera carrera;

    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellido, String dni, Direccion direccion,Carrera carrera) {
        super(id, nombre, apellido, dni, direccion);
        this.carrera=carrera;
    }

//    @JsonBackReference
    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return super.toString()+"Alumno{" +
                "carrera=" + carrera +
                '}';
    }
}
