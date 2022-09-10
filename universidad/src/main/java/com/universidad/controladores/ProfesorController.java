package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.Profesor;
import com.universidad.repositorios.ProfesorRepositorio;
import com.universidad.servicio.contratos.CarreraDAO;
import com.universidad.servicio.contratos.PersonaDAO;
import com.universidad.servicio.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/profesor")
public class ProfesorController extends PersonaController{

    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    public ProfesorController(@Qualifier("profesorDAOImpl") PersonaDAO servicio) {
        super(servicio);
        nombreEntidad="profesor";
    }


    @GetMapping("/buscar-por-carrera")
    public List<Persona> buscarPorCarrera(@RequestParam String carrera){
        List<Persona> personas = (List<Persona>) ((ProfesorDAO)servicio).findProfesoresByCarrera(carrera);
        if (personas.isEmpty()){
            throw new BadRequestException(String.format("No se encontrar personas por carrera %s",carrera));
        }
        return personas;

    }

    @PutMapping("/modificar/{idProfesor}/{idCarrera}")
    public Persona asignarCarreraProfesor(@PathVariable Integer idProfesor ,@PathVariable Integer idCarrera){

        Optional<Persona> personaOptional = servicio.obtener(idProfesor);

        if (!personaOptional.isPresent() ){
            throw new BadRequestException(String.format("El profesor con el id %d no existe",idProfesor));

        }
        Optional<Carrera> carreraOptional = carreraDAO.obtener(idCarrera);

        if (!carreraOptional.isPresent() ){
            throw new BadRequestException(String.format("La carrera con el id %d no existe",idCarrera));

        }

        Persona profesor = personaOptional.get();
        Set<Carrera>  carreras = new HashSet<>();
        carreras.add(carreraOptional.get());
        ((Profesor)profesor).setCarreras(carreras);
        return  servicio.crear( profesor);
    }


}
