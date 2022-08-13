package com.usuarios.dao;

import java.util.List;

public interface Repositorio<T> {
    List<T> listAll();

    T listById(Long id);

    void save(T t);

    void delete(Long id);
}
