package app.repository;

import app.entity.Usuarios;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UsuarioRepositoryImpl implements CrudRepository<Usuarios>{

    private EntityManager em;
    public UsuarioRepositoryImpl(EntityManager em){
        this.em= em;
    }

    @Override
    public List<Usuarios> listar() {
        List<Usuarios> usuarios = em.createQuery("select u from Usuarios u", Usuarios.class).getResultList();
        return usuarios;
    }

    @Override
    public Usuarios obtener(Long id) {
        Usuarios usuarios = em.find(Usuarios.class,id);
        return usuarios;
    }

    @Override
    public void guardar(Usuarios usuarios) {
        if (usuarios.getId()!=null && usuarios.getId()>0){
            em.merge(usuarios);
        }else{
            em.persist(usuarios);

        }
    }

    @Override
    public void eliminar(Long id) {
        Usuarios usuarios = em.find(Usuarios.class,id);
        em.remove(usuarios);
    }
}
