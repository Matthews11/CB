package pool.util;

import pool.dao.ProductoRepositorioImpl;
import pool.dao.Repositorio;
import pool.dto.Categorias;
import pool.dto.Producto;

import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {

        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
        System.out.println("Listar");
        repositorio.listar().forEach(System.out::println);
        System.out.println("===========================================================");
        System.out.println("Obtener por id");
        System.out.println(repositorio.porId(1L));

     /*   System.out.println("=======================insertar======================");
        Producto producto = new Producto();
        producto.setNombre("monitor");
        producto.setPrecio(200);
        producto.setFecha(new Date());
        Categorias categoria= new Categorias();
        categoria.setId(1L);
        producto.setCategoria(categoria);
        repositorio.guardar(producto);
        System.out.println("Producto guardado con exito");
        repositorio.listar().forEach(System.out::println);
       */

     /*   System.out.println("=========eliminar=============");
        repositorio.eliminar(3L);
        repositorio.listar().forEach(System.out::println);
*/
            System.out.println("=======================insertar======================");
        Producto producto = new Producto();
        producto.setId(4L);
        producto.setNombre("PS5");
        producto.setPrecio(1000);
        producto.setFecha(new Date());
        Categorias categoria= new Categorias();
        categoria.setId(1L);
        producto.setCategoria(categoria);
        repositorio.guardar(producto);
        System.out.println("Producto actualizado con exito");
        repositorio.listar().forEach(System.out::println);

    }
}
