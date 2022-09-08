package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicios.contratos.CarreraDAO;
import com.universidad.servicios.contratos.PersonaDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {


    private final PersonaDAO alumnoDAO;
    private final CarreraDAO  carreraDAO;

    @Autowired
    public AlumnoController(@Qualifier("alumnoDAOImpl")PersonaDAO alumnoDAO, CarreraDAO carreraDAO) {
        this.alumnoDAO = alumnoDAO;
        this.carreraDAO = carreraDAO;
    }
    @PostMapping(value = "/crear",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Persona altoAlumno( @RequestBody Persona alumno){
        return  alumnoDAO.crear(alumno);
    }

    @GetMapping(value = "/listar",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> listar(){
        List<Persona> alumnos = (List<Persona>) alumnoDAO.listar();
        if (alumnos.size()>0){
            return alumnos;
        }else {
            throw new BadRequestException("no hay alumnos en la lista");
        }
    }

    @GetMapping(value = "/obtener/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Persona obtener(@PathVariable Integer id){
        Optional<Persona> alumnos =  alumnoDAO.obtener(id);
        if (alumnos.isPresent()){
            return alumnos.get();
        }else {
            throw new BadRequestException(String.format("El alumno con id %d no existe",id));
        }
    }
    @PutMapping(value = "modificar/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Persona actualizar(@PathVariable Integer id, @RequestBody Persona alumno){
        Persona alumno1 =null;
        Optional<Persona> obtener =alumnoDAO.obtener(id);

        if (obtener.isPresent()){
            alumno1 = obtener.get();
            alumno1.setNombre(alumno.getNombre());
            alumno1.setApellido(alumno.getApellido());
            alumno1.setDni(alumno.getDni());
            alumno1.setDireccion(alumno.getDireccion());
             alumnoDAO.crear(alumno1);

        }else {
            throw new BadRequestException(String.format("El alumno con el id %d no existe",id));
        }
        return alumno1;
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id){
        alumnoDAO.eliminar(id);
    }

    @PutMapping("/modificar/{idAlumno}/{idCarrera}")
    public Persona asignarCarreraAlumno(@PathVariable Integer idAlumno ,@PathVariable Integer idCarrera){
        Persona alumno1=null;
        Optional<Persona>personaOptional = alumnoDAO.obtener(idAlumno);

        if (!personaOptional.isPresent() ){
             throw new BadRequestException(String.format("El alumno con el id %d no existe",idAlumno));

        }
        Optional<Carrera> carreraOptional = carreraDAO.obtener(idCarrera);
        if (!carreraOptional.isPresent() ){
            throw new BadRequestException(String.format("El alumno con el id %d no existe",idCarrera));

        }
        Persona alumno = personaOptional.get();
        Carrera carrera = carreraOptional.get();
        ((Alumno)alumno).setCarrera(carrera);
        return alumnoDAO.crear( alumno);
    }







}
