package org.administracion.models;


import jdk.jfr.Timestamp;

import java.util.Date;

public class Usuario {


    private Long id;

    private String nombre;


    private String contra;


    private String fecha;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
