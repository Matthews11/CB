package org.ventas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dui;

    @Column(name = "proveedor")

    private String nombre;

    private int telefono;

    public Proveedor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Proveedor: \n");
        sb.append("id=").append(id);
        sb.append(", dui='").append(dui).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }
}
