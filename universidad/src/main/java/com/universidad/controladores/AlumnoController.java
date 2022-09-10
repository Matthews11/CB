package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicio.contratos.CarreraDAO;
import com.universidad.servicio.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController extends PersonaController{

    @Autowired
    private CarreraDAO carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl")PersonaDAO servicio, CarreraDAO carreraDAO) {
        super(servicio);
        nombreEntidad="Alumno";
    }


    @PutMapping("/modificar/{idAlumno}/{idCarrera}")
    public Persona asignarCarreraAlumno(@PathVariable Integer idAlumno ,@PathVariable Integer idCarrera){
        Persona alumno1=null;
        Optional<Persona>personaOptional = servicio.obtener(idAlumno);

        if (!personaOptional.isPresent() ){
            throw new BadRequestException(String.format("El alumno con el id %d no existe",idAlumno));

        }
        Optional<Carrera> carreraOptional = carreraDAO.obtener(idCarrera);
        if (!carreraOptional.isPresent() ){
            throw new BadRequestException(String.format("La carrera con el id %d no existe",idCarrera));

        }
        Persona alumno = personaOptional.get();
        Carrera carrera = carreraOptional.get();
        ((Alumno)alumno).setCarrera(carrera);
        return servicio.crear( alumno);
    }




}
