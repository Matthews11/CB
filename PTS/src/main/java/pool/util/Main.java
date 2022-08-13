package pool.util;

import pool.dto.Categoria;
import pool.dto.Producto;
import pool.servicio.CatalogoImpl;
import pool.servicio.IServicio;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {

        IServicio servicio = new CatalogoImpl();
        System.out.println("=============listar =============");
        servicio.listarP().forEach(System.out::println);

        Categoria categoria = new Categoria();
        categoria.setNombre("Ilumninacion");

        Producto producto = new Producto();
        producto.setNombre("Lampara led ");
        producto.setPrecio(1000);
        producto.setFecha(new Date());
        producto.setSku("asd6");
        servicio.guardarPC(producto,categoria);
        System.out.println("Producto y la categoria se guardo con exito"+ producto.getId()+ "" + categoria.getId());
        servicio.listarP().forEach(System.out::println);

    }
}
