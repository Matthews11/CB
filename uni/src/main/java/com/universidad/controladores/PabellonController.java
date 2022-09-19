package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Pabellon;
import com.universidad.servicio.contratos.PabellonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pabellon")
public class PabellonController extends GenericController<Pabellon, PabellonDAO>{

    @Autowired
    public PabellonController(PabellonDAO servicio) {
        super(servicio);
    }

    @GetMapping("/buscar-por-direccion")
    public List<Pabellon> buscarPorDireccionLocalidad(@RequestParam String localidad){
        List<Pabellon> pabellons = (List<Pabellon>) servicio.findPabellonByDireccionLocalidad(localidad);
        if (pabellons.isEmpty()){
            throw new BadRequestException(String.format("No hay pabellones asignados a una localidad %s",localidad));
        }
        return pabellons;
    }

    @GetMapping("/buscar-por-nombre")
    public List<Pabellon> buscarPorNombre(@RequestParam String nombre){
        List<Pabellon> pabellons = (List<Pabellon>) servicio.findPabellonByNombreIgnoreCase(nombre);
        if (pabellons.isEmpty()){
            throw new BadRequestException(String.format("No hay pabellones por nombre %s",nombre));
        }
        return pabellons;
    }

    @PutMapping(value = "modificar/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Pabellon actualizar(@PathVariable Integer id, @RequestBody Pabellon pabellon){
        Pabellon pabellonModificado =null;
        Optional<Pabellon> obtener =servicio.obtener(id);

        if (obtener.isPresent()){
            pabellonModificado = obtener.get();
            pabellonModificado.setNombre(pabellon.getNombre());
            pabellonModificado.setMts2(pabellon.getMts2());
            pabellonModificado.setDireccion(pabellon.getDireccion());
            servicio.crear(pabellonModificado);

        }else {
            throw new BadRequestException(String.format("El aula con el id %d no existe",id));
        }
        return pabellonModificado;
    }
}
