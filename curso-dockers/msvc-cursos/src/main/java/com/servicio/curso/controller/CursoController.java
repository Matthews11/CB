package com.servicio.curso.controller;

import com.servicio.curso.models.Usuario;
import com.servicio.curso.models.entity.Curso;
import com.servicio.curso.service.CursoService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService servicio;

    private List<String> errores = new ArrayList<String>();

    private  Map<String,Object> response = new HashMap<>();

    @GetMapping("/listar")
    public ResponseEntity<?> findAll(){
        extracted();
        List<Curso> cursoList = servicio.findAll();
        if (cursoList.isEmpty()){
            response.put("respuesta","No hay cursos ");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }else {
            return new ResponseEntity<List<Curso>>(cursoList, HttpStatus.OK);
        }
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id")Long id){
        extracted();
        Optional<Curso> cursoOptional = servicio.findByIdUsuario(id);
        if (cursoOptional.isPresent()){
            return new ResponseEntity<Curso>(cursoOptional.get(),HttpStatus.ACCEPTED);
        }else {
            response.put("respuesta","No hay curso con el id "+id);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody @Valid Curso curso, BindingResult validar){
        extracted();
        if (validar.hasErrors()){
            return validacion(validar, response);
        }else {
            return new ResponseEntity<Curso>(servicio.save(curso),HttpStatus.CREATED);
        }
    }



    @PutMapping("/modificar/{id}")
    public ResponseEntity< ?> editar(@RequestBody @Valid Curso curso, BindingResult validar,
                                     @PathVariable(name = "id") Long id){
        extracted();
        Optional<Curso> obtener =servicio.findById(id);
        if (validar.hasErrors()){
            return validacion(validar, response);
        }

        if (obtener.isPresent()){
            Curso curso1 = obtener.get();
            curso1.setNombre(curso.getNombre());
            return new ResponseEntity<Curso>(servicio.save(curso1),HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable(name = "id")Long id){
        Optional<Curso> obtener =servicio.findById(id);
        extracted();
        if (obtener.isPresent()){
            servicio.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            response.put("respuesta","no se encontro curso con el id "+id);
            return  new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/asignar-usuario/{id}")
    public ResponseEntity<?> asignarUsuario(@RequestBody Usuario usuario, @PathVariable(name = "id") Long id){
        Optional<Usuario> o;
        extracted();
        try {
           o= servicio.asignarUsuario(usuario, id);
        }catch (FeignException fc){
            response.put("respuesta", "No existe el usuario con el id " + id);
            response.put("error", "Error en la comunicacion "+fc.getMessage()+" "+fc.status()+" "+fc.responseHeaders());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

        if (o.isPresent()){
            return new ResponseEntity<Usuario>(o.get(),HttpStatus.CREATED);
        }
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

    }


    @PostMapping("/crear-usuario/{id}")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario, @PathVariable(name = "id") Long id){
        Optional<Usuario> o;
        extracted();

        try {
            o= servicio.crearUsuario(usuario, id);
        }catch (FeignException fc){
            response.put("respuesta", "No se creo el usuario"+usuario.getNombre());
            response.put("error", "Error en la comunicacion"+fc.getMessage() +" "+fc.status() );
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        if (o.isPresent()){
            return new ResponseEntity<Usuario>(o.get(),HttpStatus.CREATED);
        }
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/eliminar-curso-usuario/{id}")
    public ResponseEntity<?> eliminarCursoPorId(@PathVariable Long id ){
        servicio.eliminarCursoUsuarioPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/eliminar-usuario/{cursoId}")
    public ResponseEntity<?> eliminarUsuario(@RequestBody Usuario usuario, @PathVariable Long cursoId){
        Optional<Usuario> o;
        extracted();
        try {
            o= servicio.eliminarUsuario(usuario, cursoId);
        }catch (FeignException fc){
            response.put("respuesta", "No existe el usuario con el id " + cursoId);
            response.put("error", "Error en la comunicacion"+fc.getMessage() +" "+fc.status() );
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }

        if (o.isPresent()){
            return new ResponseEntity<Usuario>(o.get(),HttpStatus.OK);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

    }




    private ResponseEntity<Map<String, Object>> validacion(BindingResult validar, Map<String, Object> response) {
        extracted();
        for (FieldError errorCampos: validar.getFieldErrors()) {
            errores.add("El campo '"+errorCampos.getField()+"' "+errorCampos.getDefaultMessage());
        }
        response.put("error",errores);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void extracted() {
        response.clear();
        errores.clear();
    }

}
