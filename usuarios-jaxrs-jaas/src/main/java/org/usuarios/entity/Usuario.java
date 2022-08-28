package org.usuarios.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "password")
    private String contra;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rol rol;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuarios: \n" +
                "id=" + id +
                ", nombre='" + nombre  +
                ", contra='" + contra  +
                ", fecha=" + fecha +
                ", rol=" + rol +
                '}';
    }
}
