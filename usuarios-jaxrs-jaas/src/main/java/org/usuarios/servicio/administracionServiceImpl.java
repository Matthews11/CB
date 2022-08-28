package org.usuarios.servicio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.usuarios.entity.Rol;
import org.usuarios.entity.Usuario;
import org.usuarios.repositorio.IRepositorio;

import java.util.List;
import java.util.Optional;

@Stateless
public class administracionServiceImpl implements IAdministracionService{

    @Inject
    private IRepositorio<Rol> rolIRepositorio;
    @Inject
    private IRepositorio<Usuario> usuarioIRepositorio;

    @Override
    public List<Rol> listarRol() {
        return rolIRepositorio.listar();
    }

    @Override
    public Optional<Rol> obtenerRol(Long id) {
        return Optional.ofNullable( rolIRepositorio.obtener(id));
    }

    @Override
    public Rol crearRol(Rol rol) {
        return rolIRepositorio.crear(rol);
    }

    @Override
    public void eliminarRol(Long id) {
        rolIRepositorio.eliminar(id);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioIRepositorio.listar();
    }

    @Override
    public Optional<Usuario> obtenerUsuario(Long id) {
        return Optional.ofNullable( usuarioIRepositorio.obtener(id));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioIRepositorio.crear(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioIRepositorio.eliminar(id);
    }

    @Override
    public Usuario logueo(Usuario usuario) {
        return usuarioIRepositorio.logueo(usuario);
    }
}
