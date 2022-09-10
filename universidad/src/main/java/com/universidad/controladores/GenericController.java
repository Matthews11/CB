package com.universidad.controladores;


import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicio.contratos.GenericDAO;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class GenericController <E,S extends GenericDAO<E>> {

    protected final S servicio;

    protected String nombreEntidad;


    public GenericController(S servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/listar")
    public List<E> listar() {
        List<E> lista = (List<E>) servicio.listar();
        if (lista.isEmpty()) {
            throw new BadRequestException(String.format("No se han encontrado %ss", nombreEntidad));
        } else {
            return lista;
        }
    }


    @GetMapping(value = "/obtener/{codigo}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public E obtener(@PathVariable(value = "codigo",required = false)Integer id){
        Optional<E> carreraOptional = servicio.obtener(id);
        if (!carreraOptional.isPresent()){
            throw new BadRequestException(String.format("La carrera con id %d no existe",id));
        }
        return carreraOptional.get();
    }

    @PostMapping(value = "/crear",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public E crear(@RequestBody @Valid E e, BindingResult validar){
        if (validar.hasErrors()) {
            throw new BadRequestException("Campos vacios");
        }
        return servicio.crear(e);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id){
        servicio.eliminar(id);
    }



}