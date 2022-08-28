package org.usuarios.repositorio;

import jakarta.ejb.Local;
import org.usuarios.entity.Usuario;

import java.util.List;
@Local
public interface IRepositorio<T>{

    List<T> listar ();

    T obtener(Long id);

    T crear(T t);

    void eliminar(Long id);

    Usuario logueo(Usuario usuario);
}
