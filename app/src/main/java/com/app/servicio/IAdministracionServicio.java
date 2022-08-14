package com.app.servicio;

import com.app.dto.Rol;
import com.app.dto.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface IAdministracionServicio {
    List<Rol> listarR() throws SQLException;

    Rol porIdR(Long id)throws SQLException;

    Rol guardarR(Rol rol)throws SQLException;

    void eliminarR(Long id)throws SQLException;

    List<Usuario> listarU() throws SQLException;

    Usuario porIdU(Long id)throws SQLException;

    Usuario guardarU(Usuario usuario)throws SQLException;

    void eliminarU(Long id)throws SQLException;
}
