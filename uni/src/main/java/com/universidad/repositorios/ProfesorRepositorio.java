package com.universidad.repositorios;

import com.universidad.modelo.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repo_profesor")
public interface ProfesorRepositorio extends PersonaRepositorio{
    @Override
    @Query("select p from Profesor p inner join Persona a on p.id=a.id")
    Iterable<Persona> findAll();
    @Query("select p from Profesor p  join fetch p.carreras c  where c.nombre=?1 ")
    Iterable<Persona> findProfesoresByCarrera(String carrera);

    @Query( value = "insert into profesor_carrera (profesor_id,carrera_id) values (?1,?2)", nativeQuery = true)
    void crearPC(Integer id_p, Integer id_c);
}
