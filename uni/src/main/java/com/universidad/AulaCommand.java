package com.universidad;

import com.universidad.servicio.contratos.AulaDAO;
import com.universidad.servicio.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AulaCommand implements CommandLineRunner {

    @Autowired
    private AulaDAO aulaDAO;

    @Autowired
    private PabellonDAO pabellonDAO;

    @Override
    public void run(String... args) throws Exception {
//        Optional<Pabellon> pabellonOptional = pabellonDAO.obtener(3);
//        Aula aula = new Aula(null,4,"4.4",40, Pizarron.PIZARRA_TIZA);
//        aulaDAO.crear(aula);
//        aula.setPabellon(pabellonOptional.get());
//        aulaDAO.crear(aula);
//
//
//        aulaDAO.listar().forEach(System.out::println);

//      Iterable<Aula> consulta1=  aulaDAO.findAulaByNroAula(2);
//        consulta1.forEach(System.out::println);
//      Iterable<Aula> consulta2= aulaDAO.findAulaByPizarron(Pizarron.PIZARRA_BLANCA);
//        consulta2.forEach(System.out::println);
//      Iterable<Aula> consulta3=  aulaDAO.findAulaByPabellonNombre("1C");
//        consulta3.forEach(System.out::println);
    }
}
