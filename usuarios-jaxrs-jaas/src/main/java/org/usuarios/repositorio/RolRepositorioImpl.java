package org.usuarios.repositorio;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.usuarios.entity.Rol;
import org.usuarios.entity.Usuario;

import java.util.List;
@DeclareRoles({"ADMIN","USER"})
@RequestScoped
public class RolRepositorioImpl implements IRepositorio<Rol>{
    @Inject
    private EntityManager em;

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public List<Rol> listar() {
        return em.createQuery("from Rol",Rol.class).getResultList();
    }

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public Rol obtener(Long id) {
        return em.find(Rol.class,id);
    }

    @RolesAllowed("ADMIN")
    @Override
    public Rol crear(Rol rol) {
        if (rol.getId()!=null && rol.getId()>0){
            em.merge(rol);
        }else {
            em.persist(rol);
        }

        return rol;
    }

    @RolesAllowed("ADMIN")
    @Override
    public void eliminar(Long id) {
        Rol rol = em.find(Rol.class,id);
        em.remove(rol);
    }

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public Usuario logueo(Usuario usuario){
        return  em.createQuery("select u from Usuario u left outer join fetch u.rol where u.nombre=:usuario and u.contra=:contra",Usuario.class)
                .setParameter("usuario",usuario.getNombre())
                .setParameter("contra",usuario.getContra())
                .getSingleResult();
    }

}
