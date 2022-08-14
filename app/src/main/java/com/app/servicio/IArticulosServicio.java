package com.app.servicio;

import com.app.dto.Categoria;
import com.app.dto.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IArticulosServicio {
    List<Categoria> listarC() throws SQLException;

    Categoria porIdC(Long id)throws SQLException;

    Categoria guardarC(Categoria categoria)throws SQLException;

    void eliminarC(Long id)throws SQLException;

    List<Producto> listarP() throws SQLException;

    Producto porIdP(Long id)throws SQLException;

    Producto guardarP(Producto producto)throws SQLException;

    void eliminarP(Long id)throws SQLException;
}
