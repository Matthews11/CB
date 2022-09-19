package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Aula;
import com.universidad.modelo.entidades.enumeradores.Pizarron;
import com.universidad.servicio.contratos.AulaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aula")
public class AulaController extends GenericController<Aula, AulaDAO>{

    @Autowired
    public AulaController(AulaDAO servicio) {
        super(servicio);
    }
//    Iterable<Aula>findAulaByPizarron(Pizarron pizarron);
//
//    Iterable<Aula>findAulaByPabellonNombre(String nombre);
//
//    Iterable<Aula>findAulaByNroAula(Integer nro);

    @GetMapping("/buscar-por-pizarron")
    public List<Aula> buscarAulaPorPizarron(@RequestParam Pizarron pizarron) {
        List<Aula> aulas = (List<Aula>) servicio.findAulaByPizarron(pizarron);
        if (aulas.isEmpty()){
            throw new BadRequestException(String.format("No se encontraron aulas por el tipo pizzaron %s",pizarron));
        }
        return aulas;
    }

    @GetMapping("/buscar-por-pabellon")
    public List<Aula> buscarAulaPorPabellon(@RequestParam String nombre) {
        List<Aula> aulas = (List<Aula>) servicio.findAulaByPabellonNombre(nombre);
        if (aulas.isEmpty()){
            throw new BadRequestException(String.format("No se encontraron aulas por pabellon nombre %s",nombre));
        }
        return aulas;
    }


    @GetMapping("/buscar-por-nro")
    public List<Aula> buscarAulaPorNumero(@RequestParam Integer nro) {
        List<Aula> aulas = (List<Aula>) servicio.findAulaByNroAula(nro);
        if (aulas.isEmpty()){
            throw new BadRequestException(String.format("No se encontraron aulas por numero %s",nro));
        }
        return aulas;
    }

    @PutMapping(value = "modificar/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Aula actualizar(@PathVariable Integer id, @RequestBody Aula aula){
        Aula aulaModificada =null;
        Optional<Aula> obtener =servicio.obtener(id);

        if (obtener.isPresent()){
            aulaModificada = obtener.get();
            aulaModificada.setNroAula(aula.getNroAula());
            aulaModificada.setPabellon(aula.getPabellon());
            aulaModificada.setCantidad(aula.getCantidad());
            aulaModificada.setMedidas(aula.getMedidas());
            aulaModificada.setPizarron(aula.getPizarron());
            servicio.crear(aulaModificada);

        }else {
            throw new BadRequestException(String.format("El aula con el id %d no existe",id));
        }
        return aulaModificada;
    }


}
