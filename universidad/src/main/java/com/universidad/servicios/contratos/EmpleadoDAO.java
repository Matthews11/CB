package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmpleado;

public interface EmpleadoDAO extends PersonaDAO{
    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmplado);

}
