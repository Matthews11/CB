package org.ejb.service;

import jakarta.ejb.Local;
import org.ejb.models.Producto;

import java.util.List;

@Local
public interface ServiceEjbLocal {
    String saludar(String mensaje);

    List<Producto> listar();

    Producto crear(Producto producto);

}
