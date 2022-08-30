package org.ventas.servicio;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.ventas.entity.Cliente;
import org.ventas.entity.Proveedor;
import org.ventas.repositorio.IRepositorio;

import java.util.List;
import java.util.Optional;

@Stateless
public class AdministracionServicioImpl implements IAdministracionServicio{

    @Inject
    private IRepositorio<Cliente>clienteIRepositorio;
    @Inject
    private IRepositorio<Proveedor>proveedorIRepositorio;


    @Override
    public List<Cliente> listarCliente() {
        return clienteIRepositorio.listar();
    }

    @Override
    public Optional<Cliente> obtenerCliente(Long id) {
        return Optional.ofNullable(clienteIRepositorio.obtener(id));
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteIRepositorio.crear(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteIRepositorio.eliminar(id);
    }

    @Override
    public List<Proveedor> listarProveedor() {
        return proveedorIRepositorio.listar();
    }

    @Override
    public Optional<Proveedor> obtenerProveedor(Long id) {
        return Optional.ofNullable(proveedorIRepositorio.obtener(id));
    }

    @Override
    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorIRepositorio.crear(proveedor);
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorIRepositorio.eliminar(id);
    }
}
