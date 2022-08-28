package org.usuarios.servicio;

import jakarta.ejb.Local;
import org.usuarios.entity.Rol;
import org.usuarios.entity.Usuario;

import java.util.List;
import java.util.Optional;

@Local
public interface IAdministracionService {
    List<Rol> listarRol ();

    Optional<Rol> obtenerRol(Long id);

    Rol crearRol(Rol rol);

    void eliminarRol(Long id);

    List<Usuario> listarUsuario ();

    Optional<Usuario> obtenerUsuario(Long id);

    Usuario crearUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

    Usuario logueo(Usuario usuario);
}
