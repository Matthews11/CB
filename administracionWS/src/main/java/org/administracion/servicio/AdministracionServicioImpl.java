package org.administracion.servicio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.administracion.entity.Rol;
import org.administracion.entity.Usuario;
import org.administracion.repositorio.IRepositorio;
import org.administracion.repositorio.RolRepositorioImpl;
import org.administracion.repositorio.UsuarioRepositorioImpl;

import java.util.List;
@Stateless
@WebService(endpointInterface = "org.administracion.servicio.AdministracionServicio")
public class AdministracionServicioImpl implements AdministracionServicio{

    @Inject
    IRepositorio<Usuario> ur;
    @Inject
    IRepositorio<Rol> rr;

    public AdministracionServicioImpl(){
        this.rr = new RolRepositorioImpl();
        this.ur= new UsuarioRepositorioImpl();
    }

    @Override
    @WebMethod
    public List<Rol> listarRol() {
        return rr.listar();
    }

    @Override
    @WebMethod
    public Rol guardarRol(Rol rol) {
        return rr.guardar(rol);
    }

    @Override
    @WebMethod
    public Rol obtenerRol(Long id) {
        return rr.obtener(id);
    }

    @Override
    @WebMethod
    public void eliminarRol(Long id) {
        rr.eliminar(id);
    }

    @Override
    @WebMethod
    public List<Usuario> listarUsuario() {
        return ur.listar();
    }

    @Override
    @WebMethod
    public Usuario guardarUsuario(Usuario usuario) {
        return ur.guardar(usuario);
    }

    @Override
    @WebMethod
    public Usuario obtenerUsuario(Long id) {
        return ur.obtener(id);
    }

    @Override
    @WebMethod
    public void eliminarUsuario(Long id) {
        ur.eliminar(id);
    }
}
