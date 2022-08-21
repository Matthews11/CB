package org.uws.servicio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.uws.Entity.Usuario;
import org.uws.repositorios.IRepositorio;

import java.util.List;

@Stateless
@WebService(endpointInterface = "org.uws.servicio.IServicio")
public class UsuarioServicioImpl implements IServicio{

    @Inject
    private IRepositorio<Usuario> ur;

    @Override
    @WebMethod
    public List<Usuario> listar() {
        return ur.listar();
    }

    @Override
    @WebMethod
    public Usuario obtener(Long id) {
        return ur.obtener(id);
    }

    @Override
    @WebMethod
    public Usuario crear(Usuario usuario) {

        return ur.crear(usuario);
    }

    @Override
    @WebMethod
    public void eliminar(Long id) {
        ur.eliminar(id);
    }
}
