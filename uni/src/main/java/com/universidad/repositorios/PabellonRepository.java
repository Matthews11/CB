package com.universidad.repositorios;

import com.universidad.modelo.entidades.Pabellon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PabellonRepository extends CrudRepository<Pabellon,Integer> {

    Iterable<Pabellon> findPabellonByDireccionLocalidad(String localidad);

    Iterable<Pabellon> findPabellonByNombreIgnoreCase(String nombre);

}
