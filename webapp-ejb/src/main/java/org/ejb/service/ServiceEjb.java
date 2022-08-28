package org.ejb.service;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import org.ejb.models.Producto;
import jakarta.ejb.Singleton;
import jakarta.ejb.Stateful;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ServiceEjb implements ServiceEjbLocal{
    int contador;

    public String saludar(String nombre){
        System.out.println("imprimiendo dentro del ejb con instancia "+ this.contador++);
        return "Hola que tal pa: "+nombre;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("peras"));
        productos.add(new Producto("manzanas"));
        productos.add(new Producto("naranjas"));
        productos.add(new Producto(""));
        return productos;
    }

    @Override
    public Producto crear(Producto producto) {
        System.out.println("guardando producto"+ producto);
        Producto p = new Producto();
        p.setNombre(producto.getNombre());
        return p;
    }

}
