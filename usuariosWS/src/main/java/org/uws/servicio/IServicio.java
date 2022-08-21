package org.uws.servicio;

import jakarta.jws.WebService;
import org.uws.Entity.Usuario;

import java.util.List;
@WebService
public interface IServicio {
    List<Usuario> listar();

    Usuario obtener(Long id);

    Usuario crear(Usuario usuario );

    void eliminar(Long id);
}
