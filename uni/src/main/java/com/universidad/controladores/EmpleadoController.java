package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Empleado;
import com.universidad.modelo.entidades.Pabellon;
import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmplado;
import com.universidad.servicio.contratos.EmpleadoDAO;
import com.universidad.servicio.contratos.PabellonDAO;
import com.universidad.servicio.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController extends  PersonaController{


    @Autowired
    private PabellonDAO pabellonDAO;

    @Autowired
    public EmpleadoController(@Qualifier("empleadoDAOImpl") PersonaDAO servicio) {
        super(servicio);
        nombreEntidad ="empleado";
    }



    @PutMapping("/modificar/{idEmpleado}/{idPabellon}")
    public Persona asignarPabellonEmpleado(@PathVariable Integer idEmpleado , @PathVariable Integer idPabellon){

        Optional<Persona> personaOptional = servicio.obtener(idEmpleado);

        if (!personaOptional.isPresent() ){
            throw new BadRequestException(String.format("El empleado con el id %d no existe",idEmpleado));

        }
        Optional<Pabellon> pabellonOptional = pabellonDAO.obtener(idPabellon);

        if (!pabellonOptional.isPresent() ){
            throw new BadRequestException(String.format("El pabellon con el id %d no existe",idPabellon));

        }

        Persona empleado = personaOptional.get();
        ((Empleado)empleado).setPabellon(pabellonOptional.get());
        return  servicio.crear( empleado);
    }


    @GetMapping("/buscar-por-tipoempleado")
    public List<Persona> buscarEmpleadoPorTipoEmpleado(@RequestParam TipoEmplado tipoEmplado  ){
        List<Persona> personas = (List<Persona>) ((EmpleadoDAO)servicio).findEmpleadoByTipoEmpleado(tipoEmplado);
        if (personas.isEmpty()){
            throw new BadRequestException(String.format("No se encontro empledos por tipo empleado %s", tipoEmplado));
        }
        return personas;

    }


}
