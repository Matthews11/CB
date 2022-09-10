package com.universidad.servicio.implementaciones;

import com.universidad.modelo.entidades.Pabellon;
import com.universidad.repositorios.PabellonRepository;
import com.universidad.servicio.contratos.GenericDAO;
import com.universidad.servicio.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PabellonDAOImpl extends GenericDAOImpl<Pabellon, PabellonRepository> implements PabellonDAO {

    @Autowired
    public PabellonDAOImpl(PabellonRepository rep) {
        super(rep);
    }

    @Override
    public Iterable<Pabellon> findPabellonByDireccionLocalidad(String localidad) {
        return rep.findPabellonByDireccionLocalidad(localidad);
    }

    @Override
    public Iterable<Pabellon> findPabellonByNombreIgnoreCase(String nombre) {
        return rep.findPabellonByNombreIgnoreCase(nombre);
    }
}
