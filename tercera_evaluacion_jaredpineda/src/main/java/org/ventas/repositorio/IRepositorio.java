package org.ventas.repositorio;

import java.util.List;

public interface IRepositorio <T>{

    List<T> listar();

    T obtener(Long id);

    T crear(T t);

    void eliminar(Long id);
}
