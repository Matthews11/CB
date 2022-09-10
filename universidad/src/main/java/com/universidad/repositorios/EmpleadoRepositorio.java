package com.universidad.repositorios;

import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmplado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repo_empleado")
public interface EmpleadoRepositorio extends PersonaRepositorio{
    @Override
    @Query("select p from Empleado p inner join Persona a on p.id=a.id")
    Iterable<Persona> findAll();
    @Query("select e from Empleado e where e.tipoEmplado=?1")
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmplado tipoEmplado);
}
