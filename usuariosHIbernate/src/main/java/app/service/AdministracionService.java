package app.service;

import app.entity.Usuarios;

import java.util.List;
import java.util.Optional;

public interface AdministracionService  {

    List<Usuarios> listar();

    Optional<Usuarios> obtener(Long id);

    void guardarU(Usuarios usuarios);

    void eliminarU(Long id);

}
