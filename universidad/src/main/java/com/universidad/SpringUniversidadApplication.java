package com.universidad;

import com.universidad.modelo.entidades.Alumno;
import com.universidad.modelo.entidades.Direccion;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicio.contratos.AlumnoDAO;
import com.universidad.servicio.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringUniversidadApplication {
 //  private static  CarreraComandos carreraComandos = new CarreraComandos();

//   @Autowired
//   private AlumnoDAO ad;



    public static void main(String[] args) {
      SpringApplication.run(SpringUniversidadApplication.class, args) ;
//        for (String str: beanDefinitionNames){
//            System.out.println(str);
//        }
    }

//      String[] beanDefinitionNames = .getBeanDefinitionNames()

//    @Bean
//    public CommandLineRunner runner(){
//        return arg->{
////            Direccion direccion = new Direccion("aldea","#26","cp201","17","3","nejapa");
////            Persona alumno = new Alumno(null,"Jared","Pineda","JP211384",direccion);
////            Persona  save =ad.crear(alumno);
////            System.out.println(save.toString());
////
////            ad.listar().forEach(System.out::println);
//        };
//    }

}
