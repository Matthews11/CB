package com.universidad.servicio.contratos;

import com.universidad.modelo.entidades.Persona;


public interface ProfesorDAO extends PersonaDAO{
    Iterable<Persona> findProfesoresByCarrera(String carrera);

    void crearPC(Integer id_p, Integer id_c);
}
