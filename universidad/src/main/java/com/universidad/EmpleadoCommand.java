package com.universidad;

import com.universidad.modelo.entidades.Direccion;
import com.universidad.modelo.entidades.Empleado;
import com.universidad.modelo.entidades.Persona;
import com.universidad.servicios.contratos.PersonaDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class EmpleadoCommand implements CommandLineRunner {

    @Autowired
    @Qualifier("empleadoDAOImpl")
    private PersonaDAO servicio;



    @Override
    public void run(String... args) throws Exception {
//        Direccion direccion = new Direccion("123","456","789","101112","131415","161717");
//        BigDecimal sueldo= new BigDecimal("2.2");
//        Empleado empleado= new Empleado(null,"Mateo","Rodriguez","213-4",direccion,sueldo, TipoEmplado.MAMTENIMIENTO);
//        servicio.crear(empleado);
//        Iterable<Persona> empleado= ((EmpleadoDAO)servicio).findEmpleadoByTipoEmpleado(TipoEmplado.MAMTENIMIENTO);
//        empleado.forEach(System.out::println);

    }
}
