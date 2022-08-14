package com.app.usuario.dao;

import com.app.usuario.dto.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IUsuarioRespositorio<T> {
    List<T> listar()throws SQLException;

    T guardar(T t)throws SQLException;

    T obtener (Long id)throws SQLException;

    void eliminar(Long id)throws SQLException;

    void setCon(Connection con);

    boolean sesion (Usuario usuario)throws  SQLException;
}
