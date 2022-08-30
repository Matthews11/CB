package org.ventas.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ventas.entity.Cliente;
import org.ventas.servicio.IAdministracionServicio;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/cliente")
public class ClienteController {

    @Inject
    private IAdministracionServicio ias;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Cliente> listar(){
        return ias.listarCliente();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtener/{id}")
    public Response obtener(@PathParam("id")Long id){
        Optional<Cliente> clienteOptional = ias.obtenerCliente(id);
        if (clienteOptional.isPresent()){
            return Response.ok(clienteOptional).build();
        }else {
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crear")
    public Response crear(Cliente cliente){
        try {
            Cliente cliente1 = ias.crearCliente(cliente);
            return Response.ok(cliente1).build();
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
        Optional<Cliente>  clienteOptional= ias.obtenerCliente(id);
        if (clienteOptional.isPresent()){
            try {
                ias.eliminarCliente(id);
                return Response.ok().build();
            }catch (Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
