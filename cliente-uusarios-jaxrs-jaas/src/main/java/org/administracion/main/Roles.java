package org.administracion.main;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.administracion.models.Rol;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Scanner;

public class Roles {
    private static Scanner leer = new Scanner(System.in);
    private static int opcion=-1;
    public static void main(String[] args) {
        Client rol = ClientBuilder.newClient();
        WebTarget uri = rol.target("http://127.0.0.1:8080/usuarios-jaxrs-jaas/api")
                .path("/rol");
        uri.register(new BasicAuthentication("jared","12345"));
        while (opcion!=0){
            System.out.println("que deseas hacer\n" +
                    "1. crear\n" +
                    "2.modificar\n" +
                    "3.obtener\n" +
                    "4.listar\n" +
                    "5.eliminar\n" +
                    "0. salir\n");
            opcion= Integer.parseInt(leer.nextLine());
            switch (opcion){
                case 1:crear(uri);break;
                case 2: modificar(uri); break;
                case 3: obtener(uri); break;
                case 4: listar(uri); break;
                case 5: eliminar(uri); break;
                case 0:
                    System.out.println("salu"); break;
                default:
                    System.out.println("selecciona una opcion valida"); break;

            }
        }
    }

    public static void listar(WebTarget uri){
        System.out.println("listar");
        Response response = uri.path("/listar").request(MediaType.APPLICATION_JSON)
                .get();
        List<Rol> roles = response.readEntity(new GenericType<List<Rol>>(){});
        roles.forEach(System.out::println);

    }
    public static void obtener(WebTarget uri){
        System.out.println("obtener");
        Response response = uri.path("/obtener/9").request(MediaType.APPLICATION_JSON)
                .get();
        Rol rol = response.readEntity(Rol.class);
        System.out.println(rol);
    }

    public static void crear(WebTarget uri){
        Rol rol = new Rol();
        rol.setRol("asd");
        Entity<Rol> entityHeader = Entity.entity(rol, MediaType.APPLICATION_JSON);
        rol =  uri.path("/crear").request( MediaType.APPLICATION_JSON)
                .post(entityHeader,Rol.class);
        System.out.println(rol.toString());
    }

    public static void modificar(WebTarget uri){
        Rol rol = new Rol();
        rol.setId(9L);
        rol.setRol("cliente");
        Entity<Rol> entityHeader = Entity.entity(rol, MediaType.APPLICATION_JSON);
        rol =  uri.path("/crear").request( MediaType.APPLICATION_JSON)
                .post(entityHeader,Rol.class);
        System.out.println(rol.toString());
    }

    public static void eliminar(WebTarget uri){
        System.out.println("eliminar");
        uri.path("/eliminar/10").request(MediaType.APPLICATION_JSON).delete();
    }
}
