package com.app.dto;

import java.util.Date;

public class Usuario {
    private int id;
    private int usuario;
    private Date fecha;
    private Rol rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
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
        return "Usuario: \n" +
                "id: " + id +
                ", usuario: " + usuario +
                ", fecha: " + fecha +
                ", rol: " + rol;
    }
}
