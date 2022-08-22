package com.app.jawrs.controllers;

import com.app.jawrs.models.Curso;
import com.app.jawrs.services.CursoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestScoped
@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
public class CursoController {

    @Inject
    private CursoService cs;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Curso> listar(){
        return cs.listar();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtener/{id}")
    public Response obtener(@PathParam("id") Long id){
        Optional<Curso> cursoOptional = cs.obtener(id);
        if (cursoOptional.isPresent()){
            return Response.ok(cursoOptional.get()).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/crear")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Curso curso){
        try {
            Curso nuevo = cs.guardar(curso);
            return  Response.ok(nuevo).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/editar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") int id,Curso curso){

        Optional<Curso> cursoOptional = cs.obtener((long) id);
        if (cursoOptional.isPresent()){
            Curso nuevoCurso = new Curso();
            nuevoCurso.setNombre(curso.getNombre());
            nuevoCurso.setDescripcion(curso.getDescripcion());
            nuevoCurso.setInstructor(curso.getInstructor());
            nuevoCurso.setDuracion(curso.getDuracion());
            try {
                cs.guardar(nuevoCurso);
                return Response.ok(nuevoCurso).build();
            }catch (Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
       return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") Long id){

        Optional<Curso> cursoOptional = cs.obtener(id);
        if (cursoOptional.isPresent()){
        try {
            cs.eliminar(id);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();

            return Response.serverError().build();
        }
    }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}