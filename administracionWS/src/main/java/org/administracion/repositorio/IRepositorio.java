package org.administracion.repositorio;

import java.util.List;

public interface IRepositorio<T>{

    List<T> listar();

    T guardar(T t);

    T obtener(Long id);

    void eliminar(Long id);

}
