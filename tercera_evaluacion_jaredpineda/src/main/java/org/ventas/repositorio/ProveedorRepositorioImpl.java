package org.ventas.repositorio;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.ventas.entity.Proveedor;

import java.util.List;
@DeclareRoles({"ADMIN","USER"})
@RequestScoped
public class ProveedorRepositorioImpl implements IRepositorio<Proveedor>{
    @Inject
    private EntityManager em;

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public List<Proveedor> listar() {
        return em.createQuery("from Proveedor ",Proveedor.class).getResultList();
    }

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public Proveedor obtener(Long id) {
        return em.find(Proveedor.class,id);
    }

    @RolesAllowed("ADMIN")
    @Override
    public Proveedor crear(Proveedor proveedor) {
        if (proveedor.getId()!=null && proveedor.getId()>0){
            em.merge(proveedor);
        }else {
            em.persist(proveedor);
        }
        return proveedor;
    }

    @RolesAllowed("ADMIN")
    @Override
    public void eliminar(Long id) {
       Proveedor proveedor= em.find(Proveedor.class,id);
       em.remove(proveedor);
    }
}
