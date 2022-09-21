package com.servicio.curso.models.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="curso_usuarios")

public class CursoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursoUsuario) ) return false;
        CursoUsuario that = (CursoUsuario) o;
        return usuarioId.equals(that.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId);
    }
}
