package com.app.dto;

import java.util.Date;

public class Producto {
    private int id;
    private String nombre;
    private int precio;
    private Date fecha;
    private int cantidad;
    private Categoria categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto: \n" +
                "id: " + id +
                ", nombre=: " + nombre  +
                ", precio: " + precio +
                ", fecha: " + fecha +
                ", cantidad: " + cantidad +
                ", categoria: " + categoria;
    }
}
