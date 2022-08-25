package org.administracion.repositorio;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.administracion.entity.Rol;

import java.util.List;
@RequestScoped
public class RolRepositorioImpl implements IRepositorio<Rol>{

    @Inject
    private EntityManager em;

    @Override
    public List<Rol> listar() {
        return em.createQuery("from Rol",Rol.class).getResultList();
    }

    @Override
    public Rol guardar(Rol rol) {
        if (rol.getId()!=null && rol.getId()>0){

            em.merge(rol);
        }else {

            em.persist(rol);
        }
        return rol;
    }

    @Override
    public Rol obtener(Long id) {
        return em.find(Rol.class,id);
    }

    @Override
    public void eliminar(Long id) {
     Rol rol= em.find(Rol.class,id);
     em.remove(rol);
    }
}
