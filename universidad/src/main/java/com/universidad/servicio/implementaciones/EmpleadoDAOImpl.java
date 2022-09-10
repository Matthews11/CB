package com.universidad.servicio.implementaciones;

import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmplado;
import com.universidad.repositorios.EmpleadoRepositorio;
import com.universidad.repositorios.PersonaRepositorio;
import com.universidad.servicio.contratos.EmpleadoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {
    @Autowired
    public EmpleadoDAOImpl(@Qualifier("repo_empleado") PersonaRepositorio rep) {
        super(rep);
    }

    @Override
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmplado tipoEmplado) {
        return ((EmpleadoRepositorio)rep).findEmpleadoByTipoEmpleado(tipoEmplado);
    }
}
