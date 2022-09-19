package com.universidad;

import com.universidad.servicio.contratos.CarreraDAO;
import com.universidad.servicio.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfesoresCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("profesorDAOImpl")
    private PersonaDAO servicio;

    @Autowired
    private CarreraDAO servicio2;

    @Override
    public void run(String... args) throws Exception {
//      Optional<Carrera> carreras = servicio2.obtener(6);
//      Set<Carrera> ca = Collections.singleton(carreras.get());
////    Optional<Persona> profesores = servicio.obtener(1);

//        Direccion direccion = new Direccion("123","456","789","101112","131415","161717");
//        BigDecimal sueldo= new BigDecimal("2.2");
//        Profesor profesor = new Profesor(null,"Mario","cerritos","1234-4", direccion,sueldo);
//        Optional<Persona> profesor = servicio.obtener(4);
//        Profesor profesor1 = (Profesor) profesor.get();
//        profesor1.setCarreras( ca);
//          servicio.crear(profesor);

//
//         ((ProfesorDAO)servicio).crearPC(3,5);


//        Iterable<Persona> consulta1 = ((ProfesorDAO)servicio).findProfesoresByCarrera("ing Electronica");
//        consulta1.forEach(System.out::println);




//        servicio.listar().forEach(System.out::println);
    }
}
