package com.universidad.servicio.implementaciones;

import com.universidad.modelo.entidades.Persona;
import com.universidad.repositorios.PersonaRepositorio;
import com.universidad.servicio.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
public class PersonaDAOImpl extends GenericDAOImpl<Persona, PersonaRepositorio> implements PersonaDAO {

    @Autowired
    public PersonaDAOImpl( PersonaRepositorio rep) {
        super(rep);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorNombreYApellido(String nombre, String apellido) {
        return Optional.ofNullable(rep.buscarPorNombreYApellido(nombre, apellido)).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarPorDni(String dni) {
        return Optional.ofNullable(rep.buscarPorDni(dni)).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaPorApellido(String apellido) {
        return rep.buscarPersonaPorApellido(apellido);
    }
}
