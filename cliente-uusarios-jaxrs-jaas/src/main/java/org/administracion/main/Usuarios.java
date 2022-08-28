package org.administracion.main;

import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.administracion.models.Rol;
import org.administracion.models.Usuario;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

import javax.swing.event.ListDataEvent;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Usuarios {
    private static Scanner leer = new Scanner(System.in);
    private static int opcion=-1;
    public static void main(String[] args) {
        Client usuario = ClientBuilder.newClient();
        WebTarget rootUri = usuario.target("http://127.0.0.1:8080/usuarios-jaxrs-jaas/api")
                .path("/usuario");
        rootUri.register(new BasicAuthentication("admin","12345"));
      //  listar(rootUri);
      //  obtener(rootUri);
      //  insertar(rootUri);
      //  modificar(rootUri);
      //  eliminar(rootUri);
      //  listar(rootUri);
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
                case 1:insertar(rootUri);break;
                case 2: modificar(rootUri); break;
                case 3: obtener(rootUri); break;
                case 4: listar(rootUri); break;
                case 5: eliminar(rootUri); break;
                case 0:
                    System.out.println("salu"); break;
                default:
                    System.out.println("selecciona una opcion valida"); break;

            }
        }
    }

    public static void insertar(WebTarget rootUri){
        System.out.println("Insertar");
        Usuario usuario = new Usuario();
        usuario.setNombre("lll reich");
        usuario.setContra("12345");
        String f="T06:00:00Z[UTC]";
        usuario.setFecha("2022-02-01"+f);
        Rol rol = new Rol();
        rol.setId(1L);
        usuario.setRol(rol);
        Entity<Usuario> entityHeader = Entity.entity(usuario, MediaType.APPLICATION_JSON);
        Usuario usuario1 = rootUri.path("/crear").request(MediaType.APPLICATION_JSON).post(entityHeader,Usuario.class);
        System.out.println(usuario1.toString());
        listar(rootUri);
    }

    public static void modificar(WebTarget rootUri){
        System.out.println("Modificar");
        Usuario usuario = new Usuario();
        usuario.setId(11L);
        usuario.setNombre("llll reich");
        usuario.setContra("123");
        usuario.setFecha("2022-02-01");
        Rol rol = new Rol();
        rol.setId(1L);
        usuario.setRol(rol);
        Entity<Usuario> enityHeader = Entity.entity(usuario,MediaType.APPLICATION_JSON);
        usuario = rootUri.path("/crear").request(MediaType.APPLICATION_JSON)
                .post(enityHeader,Usuario.class);
        System.out.println(usuario);
    }

    public static void obtener(WebTarget rootUri){
        System.out.println("obtener");
        Response response = rootUri.path("/obtener/4").request(MediaType.APPLICATION_JSON_TYPE).get();
        Usuario usuario = response.readEntity(Usuario.class);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatus()+" "+response.getStatusInfo()
                +" "+response.getMediaType()+"\n" );
        System.out.println(usuario);



    }

    public static void listar(WebTarget rootUri){
        System.out.println("listar");
        Response response = rootUri.path("/listar").request(MediaType.APPLICATION_JSON)
                .get();
        List<Usuario> usuarios = response.readEntity(new GenericType<List<Usuario>>(){});
        usuarios.forEach(System.out::println);
    }


    public static void logueo(WebTarget rootUri){
        System.out.println("Logueo");
        Usuario usuario = new Usuario();
        usuario.setNombre("llll reich");
        usuario.setContra("123");
        Response response = rootUri.path("/logueo").request(MediaType.APPLICATION_JSON)
                .get();
        usuario=response.readEntity(Usuario.class);
        System.out.println(usuario);
        System.out.println(response.getStatus()+" "+ response.getStatusInfo());
    }
    public static void eliminar(WebTarget rootUri){
        System.out.println("=================Eliminar=============================================");
        int id ;
        System.out.println("id para eliminar");
        id= Integer.parseInt(leer.nextLine());
        rootUri.path("/eliminar/"+id).request().delete();
    }
}
