package com.universidad;

import com.universidad.servicio.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("empleadoDAOImpl")
    private PersonaDAO servicio;



    @Override
    public void run(String... args) throws Exception {
//        Direccion direccion = new Direccion("123","456","789","101112","131415","3");
//        BigDecimal sueldo= new BigDecimal("2.2");
//        Empleado empleado= new Empleado(null,"Mathew","Pineda","123-5",direccion,sueldo, TipoEmplado.ADMINITRATIVO);
//        servicio.crear(empleado);
//        Iterable<Persona> empleado= ((EmpleadoDAO)servicio).findEmpleadoByTipoEmpleado(TipoEmplado.MAMTENIMIENTO);
//        empleado.forEach(System.out::println);
//        servicio.listar().forEach(System.out::println);
//        servicio.listar().forEach(System.out::println);
    }
}
