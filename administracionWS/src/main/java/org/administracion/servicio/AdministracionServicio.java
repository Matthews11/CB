package org.administracion.servicio;

import jakarta.jws.WebService;
import org.administracion.entity.Rol;
import org.administracion.entity.Usuario;

import java.util.List;

@WebService
public interface AdministracionServicio {

    List<Rol> listarRol();

    Rol guardarRol(Rol rol);

    Rol obtenerRol(Long id);

    void eliminarRol(Long id);

    List<Usuario> listarUsuario();

    Usuario guardarUsuario(Usuario usuario);

    Usuario obtenerUsuario(Long id);

    void eliminarUsuario(Long id);

}
