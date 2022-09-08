package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Carrera;
import com.universidad.servicios.contratos.CarreraDAO;
import com.universidad.servicios.contratos.ProfesorDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

 
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private ProfesorDAO pd;
    private final CarreraDAO carreraDAO;

    @Autowired
    public CarreraController(CarreraDAO carreraDAO) {
        this.carreraDAO = carreraDAO;
    }

    @GetMapping(value = "/listar",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Carrera> obtenerTodos(){
        List<Carrera> carreras = (List<Carrera>) carreraDAO.listar();
        if (carreras.isEmpty()){
            throw new BadRequestException("No exiten carreras");
        }
        return carreras;
    }

    @GetMapping(value = "/obtener/{codigo}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrera obtener(@PathVariable(value = "codigo",required = false)Integer id){
        Optional<Carrera> carreraOptional = carreraDAO.obtener(id);
        if (!carreraOptional.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe",id));
        }
        return carreraOptional.get();
    }

    @PostMapping(value = "/crear",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Carrera altaCarrera(@RequestBody Carrera carrera){
        if (carrera.getCantidadAnios()<0){
            throw new BadRequestException("El campo cantidad de anios no puede ser negativo ");

        }
        if (carrera.getCantidadMaterias()<0){
            throw new BadRequestException("El campo cantidad de materias no puede ser negativo ");

        }

        return carreraDAO.crear(carrera);
    }

    @PutMapping(value = "modificar/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Carrera actualizar(@PathVariable Integer id, @RequestBody Carrera carrera){
        Carrera  carrera1 =null;
        Optional<Carrera> obtener =carreraDAO.obtener(id);

        if (obtener.isPresent()){
            carrera1 = obtener.get();
            carrera1.setNombre(carrera.getNombre());
            carrera1.setCantidadAnios(carrera.getCantidadAnios());
            carrera1.setCantidadMaterias(carrera.getCantidadMaterias());

             carreraDAO.crear(carrera1);

        }else {
            throw new BadRequestException(String.format("La carrera con el id %d no existe",id));
        }
        return carrera1;
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id){
        carreraDAO.eliminar(id);
    }


}
