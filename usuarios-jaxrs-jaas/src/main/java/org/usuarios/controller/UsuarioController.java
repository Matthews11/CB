package org.usuarios.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.usuarios.entity.Usuario;
import org.usuarios.servicio.IAdministracionService;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/usuario")
public class UsuarioController {

    @Inject
    private IAdministracionService ias;

    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Usuario> listar(){
        return ias.listarUsuario();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/obtener/{id}")
    public Response obtener(@PathParam("id") Long id){
        Optional<Usuario> usuario = ias.obtenerUsuario(id);
        if (usuario.isPresent()){
            return Response.ok(usuario).build();
        }else {
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crear")
    public Response crear(Usuario usuario){
        try {
            Usuario usuario1 = ias.crearUsuario(usuario);
            return Response.ok(usuario1).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminar/{id}")
    public Response eliminar(@PathParam("id") Long id){
        Optional<Usuario>  usuario= ias.obtenerUsuario(id);
        if (usuario.isPresent()){
        try {
            ias.eliminarUsuario(id);
            return Response.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
        return Response.status(Response.Status.NOT_FOUND).build();
  }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(Usuario usuario){
        try {
           Usuario usuario1= ias.logueo(usuario);
           return Response.accepted(usuario1).build();
        }catch (Exception e ){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
