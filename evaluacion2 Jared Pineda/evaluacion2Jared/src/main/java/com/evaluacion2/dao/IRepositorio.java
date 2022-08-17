package com.evaluacion2.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IRepositorio <T>{
    void setCon(Connection con);
    List<T> listar() throws SQLException;
    T guardar(T t)throws SQLException;
    T obtener (Long id)throws SQLException;
    void eliminar(Long id)throws SQLException;
}
