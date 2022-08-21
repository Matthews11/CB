package org.uws.repositorios;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.uws.Entity.Usuario;

import java.util.List;

@RequestScoped
public class UsuarioRepositorioImpl implements IRepositorio<Usuario>{

    @Inject
    private EntityManager em;

    @Override
    public List<Usuario> listar() {
        return em.createQuery("from Usuario ", Usuario.class).getResultList();
    }

    @Override
    public Usuario obtener(Long id) {
        return em.find(Usuario.class,id);
    }

    @Override
    public Usuario crear(Usuario usuario) {
        if (usuario.getId()!=null && usuario.getId()>0){
            em.merge(usuario);
        }else {
            em.persist(usuario);
        }
        return usuario;
    }

    @Override
    public void eliminar(Long id) {
       Usuario usuario= em.find(Usuario.class,id);
        em.remove(usuario);
    }
}
