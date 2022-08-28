package org.usuarios.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.usuarios.entity.Rol;
import org.usuarios.servicio.IAdministracionService;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/rol")
public class RolController {

    @Inject
    private IAdministracionService ias;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Rol> listar(){
        return ias.listarRol();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/obtener/{id}")
    public Response obtener(@PathParam("id") Long  id){
        Optional<Rol>optionalRol = ias.obtenerRol(id);
        if (optionalRol.isPresent()) {

            return Response.ok(optionalRol).build();
        }else {
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crear")
    public Response crear(Rol rol){
        try {
            Rol rol1 = ias.crearRol(rol);
            return Response.ok(rol1).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminar/{id}")
    public Response eliminar(@PathParam("id")Long id){
        Optional<Rol> rol = ias.obtenerRol(id);
        if (rol.isPresent()){
           try {
               ias.eliminarRol(id);
               return Response.ok().build();
        } catch (Exception e ){
               e.printStackTrace();
               return Response.serverError().build();
           }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
