package org.ventas.repositorio;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.ventas.entity.Cliente;

import java.util.List;

@DeclareRoles({"ADMIN","USER"})
@RequestScoped
public class ClienteRepositorioImpl implements IRepositorio<Cliente>{

    @Inject
    private EntityManager em;

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public List<Cliente> listar() {
        return em.createQuery("select c from Cliente c left outer join fetch c.proveedor"
                ,Cliente.class).getResultList();
    }

    @RolesAllowed({"ADMIN","USER"})
    @Override
    public Cliente obtener(Long id) {
        return em.createQuery("select c from Cliente c left outer join fetch c.proveedor where c.id=:id"
                ,Cliente.class).setParameter("id",id).getSingleResult();
    }

    @RolesAllowed("ADMIN")
    @Override
    public Cliente crear(Cliente cliente) {
        if (cliente.getId()!=null && cliente.getId()>0){
            em.merge(cliente);
        }else {
            em.persist(cliente);
        }
        return cliente;
    }

    @RolesAllowed("ADMIN")
    @Override
    public void eliminar(Long id) {
        Cliente cliente1 =em.find(Cliente.class,id);
        em.remove(cliente1);
    }
}
