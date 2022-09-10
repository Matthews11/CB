package com.universidad.servicio.contratos;

import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Persona;

import java.util.List;
import java.util.Optional;

public interface AlumnoDAO extends PersonaDAO{

        Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);

}
