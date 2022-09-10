package com.universidad.servicio.contratos;

import com.universidad.modelo.entidades.Pabellon;

public interface PabellonDAO extends GenericDAO<Pabellon>{

    Iterable<Pabellon> findPabellonByDireccionLocalidad(String localidad);

    Iterable<Pabellon> findPabellonByNombreIgnoreCase(String nombre);
}
