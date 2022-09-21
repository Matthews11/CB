package com.servicio.curso.service;

import com.servicio.curso.clients.UsuarioClienteRest;
import com.servicio.curso.models.Usuario;
import com.servicio.curso.models.entity.Curso;
import com.servicio.curso.models.entity.CursoUsuario;
import com.servicio.curso.repositories.CursoRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository repo;

    @Autowired
    private UsuarioClienteRest clienteRest;

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id) {
        return Optional.ofNullable(repo.findById(id)).orElse(null);
    }

    @Override
    @Transactional
    public Optional<Curso> findByIdUsuario(Long id) {
        Optional<Curso> obtenerCurso = repo.findById(id);
        if (obtenerCurso.isPresent()){
            Curso curso = obtenerCurso.get();
            if (!curso.getCursoUsuarios().isEmpty()){
                List<Long> ids = curso.getCursoUsuarios().stream().map(cursoUsuario -> cursoUsuario.getId()).collect(Collectors.toList());
                List<Usuario> usuarios=clienteRest.obtenerUsuarioPorCurso(ids);

                curso.setUsuarios(usuarios);
            }
            return  Optional.of(curso);
        }
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return (List<Curso>) repo.findAll();
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return repo.save(curso);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    @Transactional
    public void eliminarCursoUsuarioPorId(Long id) {
        repo.eliminarCursoUsuarioPorId(id);
    }

    @Override
    @Transactional
    public Optional<Usuario> asignarUsuario(Usuario usuario, Long id) {
        Optional<Curso> o = repo.findById(id);
        if(o.isPresent()){
            Usuario usuarioMsvc = clienteRest.detalle(usuario.getId());

            Curso curso = o.get();
            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMsvc.getId());

            curso.addCursoUsuario(cursoUsuario);
            repo.save(curso);
            return Optional.ofNullable(usuarioMsvc);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuario> crearUsuario(Usuario usuario, Long id) {
        Optional<Curso> o = repo.findById(id);
        if(o.isPresent()){
            Usuario usuarioNuevoMsvc = clienteRest.crear(usuario);

            Curso curso = o.get();
            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioNuevoMsvc.getId());

            curso.addCursoUsuario(cursoUsuario);
            repo.save(curso);
            return Optional.ofNullable(usuarioNuevoMsvc);
        }
        return Optional.empty();

    }

    @Override
    @Transactional
    public Optional<Usuario> eliminarUsuario(Usuario usuario, Long id) {
        Optional<Curso> o = repo.findById(id);
        if(o.isPresent()){
            Usuario usuarioMsvc = clienteRest.detalle(usuario.getId());

            Curso curso = o.get();
            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMsvc.getId());

            curso.removeCursoUsuario(cursoUsuario);
            repo.save(curso);
            return Optional.ofNullable(usuarioMsvc);
        }
        return Optional.empty();
    }
}
