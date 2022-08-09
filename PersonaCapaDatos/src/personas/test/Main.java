package personas.test;

import personas.datos.PersonaDAO;
import personas.datos.PersonasDAOJDBC;
import personas.domain.PersonaDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Connection con = null;
        PersonaDAO dao = new PersonasDAOJDBC(con);
        PersonaDTO persona = new PersonaDTO();
        persona.setNombre("Jared");
        persona.setApellido("Pineda");

        try{
            //insertar
            dao.insert(persona);
            dao.insert(persona);
            //eliminar
            dao.delete(new PersonaDTO(2));
            //actualizar
            PersonaDTO personaUp = new PersonaDTO();
            personaUp.setId(1);
            personaUp.setNombre("Mathew");
            personaUp.setApellido("Molina");
            dao.update(personaUp);
            //listar
            List<PersonaDTO> personas=dao.select();
            for (PersonaDTO dtos: personas){
                System.out.println(dtos);
                System.out.println();
            }

        }catch (SQLException e){
            System.out.println("Excepcion en la capa de prueba");
            e.printStackTrace();
        }

    }
}
