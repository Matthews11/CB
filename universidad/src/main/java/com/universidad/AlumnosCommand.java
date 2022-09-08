package com.universidad;

import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicios.contratos.CarreraDAO;
import com.universidad.servicios.contratos.PersonaDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlumnosCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("alumnoDAOImpl")
    private PersonaDAO servicio;

    @Autowired
    private CarreraDAO servicio2;

    @Override
    public void run(String... args) throws Exception {
//        Optional<Carrera> sistemas = servicio2.obtener(2);
//        Iterable<Persona> alumnos = servicio.listar();
//
//        alumnos.forEach(alumno->{((Alumno) alumno).setCarrera(sistemas.get());
//        });
//        alumnos.forEach(persona -> servicio.crear(persona));
//
//        Optional<Persona>alumno1 =servicio.obtener(1);
//
//
//        Optional<Persona> consulta1 = servicio.buscarPorNombreYApellido(alumno1.get().getNombre(),alumno1.get().getApellido());
//        System.out.println(consulta1.toString());
//        Optional<Persona> consulta2 = servicio.buscarPorDni(alumno1.get().getDni());
//        System.out.println(consulta2.toString());
//        Iterable<Persona> consulta3 = servicio.buscarPersonaPorApellido(alumno1.get().getApellido());
//        System.out.println(consulta3.toString());

//        Optional<Carrera> sit = servicio2.obtener(4);
//        Iterable<Persona> consulta4 = ((AlumnoDAO)servicio).
//                buscarAlumnoPorNombreCarrera(sit.get().getNombre());
//        consulta4.forEach(System.out::println);
    }
}
