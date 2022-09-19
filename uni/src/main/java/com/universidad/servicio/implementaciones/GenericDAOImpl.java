package com.universidad.servicio.implementaciones;

import com.universidad.servicio.contratos.GenericDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public class GenericDAOImpl<E,R extends CrudRepository<E,Integer > > implements GenericDAO<E> {

    protected final R rep;

    public GenericDAOImpl(R rep) {
        this.rep = rep;
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<E> obtener(Integer id) {
        return Optional.ofNullable(rep.findById(id)).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> listar() {
        return rep.findAll();
    }

    @Override
    @Transactional
    public E crear(E e) {
        return rep.save(e);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        rep.deleteById(id);
    }
}
