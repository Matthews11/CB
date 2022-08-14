package com.app.usuario.dto;

import java.util.Date;

public class Usuario {

    private Long id;

    private String usuario;

    private String password;

    private Date fecha;


    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Usuario----> \n" +
                "id"  + id +
                ", usuario: " + usuario +
                ", password: " + password +
                ", fecha: " + fecha  ;
    }
}
