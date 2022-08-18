package app.repository;

import app.entity.Usuarios;

import java.util.List;

public interface CrudRepository<T> {
    List<T> listar();
    T obtener(Long id);
    void guardar(Usuarios usuarios);
    void eliminar(Long id);
}
