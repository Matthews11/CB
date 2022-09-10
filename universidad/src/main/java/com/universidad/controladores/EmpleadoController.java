package com.universidad.controladores;

import com.universidad.exception.BadRequestException;
import com.universidad.modelo.entidades.Empleado;
import com.universidad.modelo.entidades.Pabellon;
import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmplado;
import com.universidad.servicio.contratos.EmpleadoDAO;
import com.universidad.servicio.contratos.PabellonDAO;
import com.universidad.servicio.contratos.PersonaDAO;
import com.universidad.servicio.contratos.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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



    @PutMapping("/modificar/{idProfesor}/{idPabellon}")
    public Persona asignarCarreraEmpleado(@PathVariable Integer idProfesor , @PathVariable Integer idPabellon){

        Optional<Persona> personaOptional = servicio.obtener(idProfesor);

        if (!personaOptional.isPresent() ){
            throw new BadRequestException(String.format("El profesor con el id %d no existe",idProfesor));

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
