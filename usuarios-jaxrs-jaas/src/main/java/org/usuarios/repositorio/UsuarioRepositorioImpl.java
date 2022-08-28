package org.usuarios.repositorio;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.usuarios.entity.Usuario;

import java.util.List;

@DeclareRoles({"ADMIN","USER"})
@RequestScoped
public class UsuarioRepositorioImpl implements IRepositorio<Usuario> {

    @Inject
    private EntityManager em;

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public List<Usuario> listar() {
        return em.createQuery("select u from Usuario u left outer join fetch u.rol",Usuario.class).getResultList();
    }

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public Usuario obtener(Long id) {
        return em.createQuery("select u from Usuario u left outer join fetch u.rol where u.id=:id",Usuario.class)
                .setParameter("id",id).getSingleResult();
    }

    @RolesAllowed({"ADMIN"})
    @Override
    public Usuario crear(Usuario usuario) {
        if (usuario.getId()!=null && usuario.getId()>0){
            em.merge(usuario);
        }else {
            em.persist(usuario);
        }
        return usuario;
    }

    @RolesAllowed("ADMIN")
    @Override
    public void eliminar(Long id) {
        Usuario usuario = em.find(Usuario.class,id);
        em.remove(usuario);
    }

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public Usuario logueo(Usuario usuario){
       return  em.createQuery("select u from Usuario u left outer join fetch u.rol where u.nombre=:nombre and u.contra=:contra",Usuario.class)
               .setParameter("nombre",usuario.getNombre())
               .setParameter("contra",usuario.getContra())
               .getSingleResult();
    }
}
