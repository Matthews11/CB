package com.universidad.servicio.contratos;

import java.util.Optional;

public interface GenericDAO<E> {

    Optional<E> obtener(Integer id);

    Iterable<E> listar();

    E crear(E e);

    void eliminar(Integer id);
}
