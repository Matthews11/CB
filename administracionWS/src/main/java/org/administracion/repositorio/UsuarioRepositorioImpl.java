package org.administracion.repositorio;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.administracion.entity.Usuario;

import java.util.List;

@RequestScoped
public class UsuarioRepositorioImpl implements IRepositorio<Usuario>{

    @Inject
    private EntityManager em;

    @Override
    public List<Usuario> listar() {
        return em.createQuery("select u from Usuario as u left outer join fetch u.role",Usuario.class).getResultList();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        if (usuario.getId()!=null && usuario.getId()>0){
            em.merge(usuario);
        }else {
            em.persist(usuario);
        }
        return usuario;
    }

    @Override
    public Usuario obtener(Long id) {
        return em.createQuery("select u from Usuario as u left outer join fetch u.role where u.id=:id",Usuario.class)
                .setParameter( "id",id)
                .getSingleResult();
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = em.find(Usuario.class,id);
        em.remove(usuario);
    }
}
