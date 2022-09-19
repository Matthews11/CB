package com.universidad.servicio.implementaciones;

import com.universidad.modelo.entidades.Carrera;
import com.universidad.repositorios.CarreraRepositorio;
import com.universidad.servicio.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarreraDAOImpl extends GenericDAOImpl<Carrera, CarreraRepositorio> implements CarreraDAO {

    @Autowired
    public CarreraDAOImpl(CarreraRepositorio rep) {
        super(rep);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByNombreContains(String nombre) {
        return rep.findCarreraByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByNombreContainsIgnoreCase(String nombre) {
        return rep.findCarreraByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarreraByCantidadAniosAfter(Integer anios) {
        return rep.findCarreraByCantidadAniosAfter(anios);
    }

    @Override
    public Iterable<Carrera> buscarCarreraPorProfesorNombreYApellido(String nombre, String apellido) {
        return rep.buscarCarreraPorProfesorNombreYApellido(nombre,apellido);
    }
}
