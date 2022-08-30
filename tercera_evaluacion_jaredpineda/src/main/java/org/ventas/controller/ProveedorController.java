package org.ventas.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.ventas.entity.Cliente;
import org.ventas.entity.Proveedor;
import org.ventas.servicio.IAdministracionServicio;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/proveedor")
public class ProveedorController {
    @Inject
    private IAdministracionServicio ias;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Proveedor> listar(){
        return ias.listarProveedor();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/obtener/{id}")
    public Response obtener(@PathParam("id")Long id){
        Optional<Proveedor> proveedorOptional = ias.obtenerProveedor(id);
        if (proveedorOptional.isPresent()){
            return Response.ok(proveedorOptional).build();
        }else {
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/crear")
    public Response crear(Proveedor proveedor){
        try {
            Proveedor proveedor1 = ias.crearProveedor(proveedor);
            return Response.ok(proveedor1).build();
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
        Optional<Proveedor> proveedorOptional = ias.obtenerProveedor(id);
        if (proveedorOptional.isPresent()){
            try {
                ias.eliminarProveedor(id);
                return Response.ok().build();
            }catch (Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
