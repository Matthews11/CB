package com.universidad.servicio.contratos;

import com.universidad.modelo.entidades.Persona;
import org.springframework.stereotype.Repository;


public interface ProfesorDAO extends PersonaDAO{
    Iterable<Persona> findProfesoresByCarrera(String carrera);

    void crearPC(Integer id_p, Integer id_c);
}
