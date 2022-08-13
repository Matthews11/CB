package pool.servicio;

import pool.dto.Categoria;
import pool.dto.Producto;

import java.sql.SQLException;
import java.util.List;

public interface IServicio {
    List<Producto> listarP ()throws SQLException;

    Producto porIdP(Long id)throws SQLException;

    Producto guardarP(Producto producto)throws SQLException;

    void eliminarP (Long id) throws SQLException;

    List<Categoria> listarC ()throws SQLException;

    Categoria porIdC(Long id)throws SQLException;

    Categoria guardarC(Categoria categoria)throws SQLException;

    void eliminarC (Long id) throws SQLException;

    void guardarPC(Producto producto, Categoria categoria)throws SQLException;

}
