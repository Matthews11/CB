package personas.datos;

import personas.domain.PersonaDTO;
import java.sql.SQLException;
import java.util.List;

public interface PersonaDAO {

    int insert(PersonaDTO personaDTO) throws SQLException;

    int update(PersonaDTO personaDTO) throws SQLException;

    int delete(PersonaDTO personaDTO) throws SQLException;

    List<PersonaDTO> select ()throws SQLException;

}
