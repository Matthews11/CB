package app.service;

import app.entity.Usuarios;
import app.repository.CrudRepository;
import app.repository.UsuarioRepositoryImpl;
import app.util.EMF;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class AdministracionServiceImpl implements AdministracionService{
    private EntityManager em;
    private CrudRepository<Usuarios> usuarioCrudRepository;

    public AdministracionServiceImpl(){
        this.em =EMF.getEntityManager();
        this.usuarioCrudRepository = new UsuarioRepositoryImpl(em);
    }

    @Override
    public List<Usuarios> listar() {

        return usuarioCrudRepository.listar();
    }

    @Override
    public Optional<Usuarios> obtener(Long id) {
        return Optional.ofNullable(usuarioCrudRepository.obtener(id));
    }

    @Override
    public void guardarU(Usuarios usuarios) {
        try {
            em.getTransaction().begin();
            usuarioCrudRepository.guardar(usuarios);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarU(Long id) {
        try {
            em.getTransaction().begin();
            usuarioCrudRepository.eliminar(id);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
