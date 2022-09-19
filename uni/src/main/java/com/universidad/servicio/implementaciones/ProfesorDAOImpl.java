package com.universidad.servicio.implementaciones;

import com.universidad.modelo.entidades.Persona;
import com.universidad.repositorios.PersonaRepositorio;
import com.universidad.repositorios.ProfesorRepositorio;
import com.universidad.servicio.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO {
    @Autowired
    public ProfesorDAOImpl(@Qualifier("repo_profesor") PersonaRepositorio rep) {
        super(rep);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> findProfesoresByCarrera(String carrera) {
        return ((ProfesorRepositorio)rep).findProfesoresByCarrera(carrera);
    }

    @Override
    @Transactional
    public void crearPC(Integer id_p, Integer id_c) {
        ((ProfesorRepositorio)rep).crearPC(id_p,id_c);
    }
}
