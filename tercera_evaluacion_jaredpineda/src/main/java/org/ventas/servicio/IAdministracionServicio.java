package org.ventas.servicio;

import org.ventas.entity.Cliente;
import org.ventas.entity.Proveedor;

import java.util.List;
import java.util.Optional;

public interface IAdministracionServicio {

    List<Cliente> listarCliente();

    Optional<Cliente> obtenerCliente(Long id);

    Cliente crearCliente(Cliente cliente);

    void eliminarCliente(Long id);

    List<Proveedor> listarProveedor();

    Optional<Proveedor> obtenerProveedor(Long id);

    Proveedor crearProveedor(Proveedor proveedor);

    void eliminarProveedor(Long id);

}
