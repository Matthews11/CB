package com.universidad;

import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.Direccion;
import com.universidad.modelo.entidades.Pabellon;
import com.universidad.modelo.entidades.enumeradores.Pizarron;
import com.universidad.servicios.contratos.PabellonDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PabellonCommand implements CommandLineRunner {

    @Autowired
    private PabellonDAO pabellonDAO;

    @Override
    public void run(String... args) throws Exception {
//        Direccion direccion = new Direccion("123","456","789","101112","131415","3");
//        Pabellon pabellon = new Pabellon(null,3.3,"3C",direccion);
//        pabellonDAO.crear(pabellon);
//
//        pabellonDAO.listar().forEach(System.out::println);
//
//        Iterable<Pabellon> consulta1=pabellonDAO.findPabellonByDireccionLocalidad("3");
//        consulta1.forEach(System.out::println);
//       Iterable<Pabellon> consulta2= pabellonDAO.findPabellonByNombre("2C");
//       consulta2.forEach(System.out::println);
    }
}
