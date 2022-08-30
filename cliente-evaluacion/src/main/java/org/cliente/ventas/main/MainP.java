package org.cliente.ventas.main;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.cliente.ventas.models.Proveedor;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

import java.util.List;
import java.util.Scanner;

public class MainP {
    private static Scanner leer = new Scanner(System.in);
    private static int opcion=-1;
    public static void main(String[] args) {
        Client usuario = ClientBuilder.newClient();
        WebTarget rootUri = usuario.target("http://127.0.0.1:8081/tercera_evaluacion_jaredpineda/api")
                .path("/proveedor");
        rootUri.register(new BasicAuthentication("admin","12345"));
        //  rootUri.register(new BasicAuthentication("mateo","12345"));
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
        Proveedor proveedor = new Proveedor();
        System.out.println("nombre del proveedor");
        proveedor.setNombre(leer.nextLine());
        System.out.println("DUI del proveedor");
        proveedor.setDui(leer.nextLine());
        System.out.println("Telefono del proveedor");
        proveedor.setTelefono(Integer.parseInt(leer.nextLine()));

        Entity<Proveedor> entityHeader = Entity.entity(proveedor, MediaType.APPLICATION_JSON);
        Proveedor proveedor1 = rootUri.path("/crear").request(MediaType.APPLICATION_JSON).
                post(entityHeader,Proveedor.class);


    }

    public static void modificar(WebTarget rootUri){
        System.out.println("Modificar");
        listar(rootUri);
        Proveedor proveedor = new Proveedor();
        System.out.println("id del proveedor");
        proveedor.setId(Long.valueOf(leer.nextLine()));
        System.out.println("nombre del proveedor");
        proveedor.setNombre(leer.nextLine());
        System.out.println("DUI del proveedor");
        proveedor.setDui(leer.nextLine());
        System.out.println("Telefono del proveedor");
        proveedor.setTelefono(Integer.parseInt(leer.nextLine()));

        Entity<Proveedor> entityHeader = Entity.entity(proveedor, MediaType.APPLICATION_JSON);
        Proveedor proveedor1 = rootUri.path("/crear").request(MediaType.APPLICATION_JSON).
                post(entityHeader,Proveedor.class);

    }

    public static void obtener(WebTarget rootUri){
        System.out.println("obtener");
        listar(rootUri);
        int id ;
        System.out.println("id para obtener");
        id= Integer.parseInt(leer.nextLine());
        Response response = rootUri.path("/obtener/"+id).request(MediaType.APPLICATION_JSON_TYPE).get();

        Proveedor proveedor = response.readEntity(Proveedor.class);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatus()+" "+response.getStatusInfo()
                +" "+response.getMediaType()+"\n" );
        System.out.println(proveedor);



    }

    public static void listar(WebTarget rootUri){
        System.out.println("listar");
        Response response = rootUri.path("/listar").request(MediaType.APPLICATION_JSON)
                .get();
        List<Proveedor> proveedores = response.readEntity(new GenericType<List<Proveedor>>(){});
        proveedores.forEach(System.out::println);
    }


    public static void eliminar(WebTarget rootUri){
        System.out.println("=================Eliminar=============================================");
        listar(rootUri);
        int id ;
        System.out.println("id para eliminar");
        id= Integer.parseInt(leer.nextLine());
        rootUri.path("/eliminar/"+id).request().delete();
    }
}
