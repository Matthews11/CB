package com.app.usuario.service;

import com.app.usuario.dto.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IAdministracionService {
    List<Usuario> listar()throws SQLException;

    Usuario guardar(Usuario usuario)throws SQLException;

    Usuario obtener (Long id)throws SQLException;

    void eliminar(Long id)throws SQLException;

    boolean comprobar(Usuario usuario)throws  SQLException;
}
