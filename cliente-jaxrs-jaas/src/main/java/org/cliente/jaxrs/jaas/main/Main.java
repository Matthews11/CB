package org.cliente.jaxrs.jaas.main;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.cliente.jaxrs.jaas.models.Curso;
import org.cliente.jaxrs.jaas.models.Instructor;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client cliente = ClientBuilder.newClient();
        WebTarget rootUri = cliente.target("http://127.0.0.1:8081/webapp-jaxrs-jaas/api").path("/cursos");
        rootUri.register(new BasicAuthentication("mateo","12345"));

        System.out.println("=====================Obtener============================================ ");
        Response response  = rootUri.path("/obtener/2").request(MediaType.APPLICATION_JSON).get();

        Curso curso = response.readEntity(Curso.class);
        System.out.println(response.getHeaders());
        System.out.println(response.getStatus()+" "+response.getStatusInfo()+" "+response.getMediaType()+"\n" );
        System.out.println(curso);

        System.out.println("listando");
        listar(rootUri);


        System.out.println("====================creando ==============================================");
        Curso cursoNuevo=new Curso();
        Instructor instructor = new Instructor();
        cursoNuevo.setNombre("PHP");
        cursoNuevo.setDescripcion("PHP con linux");
        cursoNuevo.setDuracion(99.9);
        instructor.setId(1L);
        cursoNuevo.setInstructor(instructor);

        Entity<Curso> entityHeader = Entity.entity(cursoNuevo,MediaType.APPLICATION_JSON);
        curso = rootUri.path("/crear").request(MediaType.APPLICATION_JSON).post(entityHeader,Curso.class);
        System.out.println(curso);
        listar(rootUri);

        System.out.println("===================Editando=========================================== ");

        Curso cursoEditado=curso ;
        cursoEditado.setNombre("microservicios con Linux");
        entityHeader = Entity.entity(cursoEditado,MediaType.APPLICATION_JSON);
        curso=rootUri.path("/editar/"+curso.getId()).request(MediaType.APPLICATION_JSON).put(entityHeader,Curso.class);
        System.out.println(curso);
        listar(rootUri);

        System.out.println("=================Eliminar=============================================");
        rootUri.path("/eliminar/"+curso.getId()).request().delete();listar(rootUri);
    }

    private static void listar(WebTarget rootUri) {
        System.out.println("=================== lista==========================================");
        Response response  = rootUri.path("/listar").request(MediaType.APPLICATION_JSON).get();

        List<Curso> cursos = response.readEntity(new GenericType<List<Curso>>(){});
        cursos.forEach(System.out::println);
    }
}

