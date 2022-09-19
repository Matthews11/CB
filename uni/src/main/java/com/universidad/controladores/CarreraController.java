package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.servicio.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera,CarreraDAO>{


  @Autowired
    public CarreraController(CarreraDAO servicio) {
        super(servicio);
        nombreEntidad ="Carreras";

    }

    @GetMapping("/buscar-por-nombre")
    public List<Carrera> buscarPorNombreContains(@RequestParam String nombre){
      List<Carrera> carreras = (List<Carrera>) servicio.findCarreraByNombreContains(nombre);
      if (carreras.isEmpty()){
          throw new BadRequestException(String.format("No se econtraron carreas con el nombre %s",nombre));
      }
      return carreras;

    }

    @GetMapping("/buscar-por-nombre-ignore")
    public List<Carrera> buscarPorNombreIgnorando(@RequestParam String nombre){
        List<Carrera> carreras = (List<Carrera>) servicio.findCarreraByNombreContainsIgnoreCase(nombre);
        if (carreras.isEmpty()){
            throw new BadRequestException(String.format("No se econtraron carreas con el nombre %s",nombre));
        }
        return carreras;
    }

    @GetMapping("/buscar-por-anios")
    public List<Carrera> buscarPorAnios(@RequestParam Integer anios){
        List<Carrera> carreras = (List<Carrera>) servicio.findCarreraByCantidadAniosAfter(anios);
        if (carreras.isEmpty()){
            throw new BadRequestException(String.format("No se econtraron carreas con el anio %s",anios));
        }
        return carreras;
    }

    @GetMapping("/buscar-por-nombre-apellido")
    public List<Carrera> buscarCarreraPorProfesorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        List<Carrera> carreras = (List<Carrera>) servicio.buscarCarreraPorProfesorNombreYApellido(nombre,apellido);
        if (carreras.isEmpty()){
            throw new BadRequestException(String.format("No se econtraron carreas con el nombre %s y con el %s",nombre,apellido));
        }
        return carreras;
    }

    @PutMapping(value = "modificar/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrera actualizar(@PathVariable Integer id, @RequestBody Carrera carrera){
        Carrera  carreraModificada =null;
        Optional<Carrera> obtener =servicio.obtener(id);

        if (obtener.isPresent()){
            carreraModificada = obtener.get();
            carreraModificada.setNombre(carrera.getNombre());
            carreraModificada.setCantidadAnios(carrera.getCantidadAnios());
            carreraModificada.setCantidadMaterias(carrera.getCantidadMaterias());
            carreraModificada.setAlumnos(carrera.getAlumnos());
            carreraModificada.setProfesors(carrera.getProfesors());
            servicio.crear(carreraModificada);

        }else {
            throw new BadRequestException(String.format("La carrera con el id %d no existe",id));
        }
        return carreraModificada;
    }

}
