package com.universidad;

import com.universidad.servicio.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CarreraComandos implements CommandLineRunner {

    @Autowired
    private CarreraDAO servicio;


    @Override
    public void run(String... args) throws Exception {
//        Carrera ingSistemas = new Carrera(null,"Ing Sistemas",10,50);
//        Carrera ingIndustrial = new Carrera(null,"ing Industrial",20,30);
//        Carrera ingAlimentos = new Carrera(null,"ing Alimentos",40,60);
//        Carrera ingElectronica = new Carrera(null,"ing Electronica",70,80);
//        Carrera LicSistemas = new Carrera(null,"LicSistemas",90,100);
//        Carrera LicDataScience = new Carrera(null,"Lic ciencia de datos",110,120);
//        Carrera LicAdmminEmp = new Carrera(null,"Lic administracion de empresas",130,140);
//        Carrera LicIdiomas = new Carrera(null,"Lic Idiomas",70,150);
//
//
//
//        servicio.crear(ingSistemas);
//        servicio.crear(ingAlimentos);
//        servicio.crear(ingIndustrial);
//        servicio.crear(ingElectronica);
//        servicio.crear(LicSistemas);
//        servicio.crear(LicAdmminEmp);
//        servicio.crear(LicDataScience);
//        servicio.crear(LicIdiomas);

//servicio.listar().forEach(System.out::println);

//        List< Carrera> carreras = (List<Carrera>) servicio.findCarreraByNombreContains("sistemas");
//        carreras.forEach(System.out::println);
//
//        List< Carrera> carrerasICarreras1 = (List<Carrera>) servicio.findCarreraByNombreContainsIgnoreCase("SISTEMAS");
//        carrerasICarreras1.forEach(System.out::println);
//
//        List< Carrera> carrerasICarreras2 = (List<Carrera>) servicio.findCarreraByNombreContainsIgnoreCase("sistemas");
//        carrerasICarreras2.forEach(System.out::println);
//        List< Carrera> carreras = (List<Carrera>) servicio.findCarreraByCantidadAniosAfter(1);
//        carreras.forEach(System.out::println);

//        Iterable<Carrera> carreras= servicio.buscarCarreraPorProfesorNombreYApellido
//                ("Marlon","Ing");
//        carreras.forEach(System.out::println);
//                servicio.listar().forEach(System.out::println);

    }


}
