package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicio.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//@RestController
public class PersonaController extends GenericController<Persona, PersonaDAO>{

    public PersonaController(@Qualifier("personaDAOImpl") PersonaDAO servicio) {
        super(servicio);
    }

    @GetMapping("/buscarna")
    public Persona buscarPorNombreYApellido(@RequestParam String nombre, @RequestParam String apellido){
        Optional<Persona>personaOptional = servicio.buscarPorNombreYApellido(nombre,apellido);
        if (!personaOptional.isPresent()){
            throw new BadRequestException(String.
                    format("no se econtraron Personas con el nombre %s y apellido %s ",nombre,apellido));
        }else {
            return personaOptional.get();
        }
    }
    @GetMapping("/buscardni")
    public Persona buscarPorDni(@RequestParam String dni){
        Optional<Persona>personaOptional = servicio.buscarPorDni(dni);
        if (!personaOptional.isPresent()){
            throw new BadRequestException(String.
                    format("no se econtraron Personas con el dni %s ",dni));
        }else {
            return personaOptional.get();
        }
    }
    @GetMapping("/buscarapellido")
    public List<Persona> buscarPorApellido(@RequestParam String apellido){
        List<Persona> personas = (List<Persona>) servicio.buscarPersonaPorApellido(apellido);
        if (personas.isEmpty()){
            throw new BadRequestException(String.format("No se encontraron personas con el apellido %s",apellido));
        }else {
            return personas;
        }
    }


    @PutMapping(value = "modificar/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Persona actualizar(@PathVariable Integer id, @RequestBody Persona persona){
        Persona personaModificada =null;
        Optional<Persona> obtener =servicio.obtener(id);

        if (obtener.isPresent()){
            personaModificada = obtener.get();
            personaModificada.setNombre(persona.getNombre());
            personaModificada.setApellido(persona.getApellido());
            personaModificada.setDni(persona.getDni());
            personaModificada.setDireccion(persona.getDireccion());
            servicio.crear(personaModificada);

        }else {
            throw new BadRequestException(String.format("La persona con el id %d no existe",id));
        }
        return personaModificada;
    }
}
