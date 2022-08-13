package pool.util;

import pool.dao.CategoriaImpl;
import pool.dao.Conexion;
import pool.dao.ProductoIRepositorioImpl;
import pool.dao.IRepositorio;
import pool.dto.Categoria;
import pool.dto.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection con = Conexion.getConnection()){
            if (con.getAutoCommit()) {
                con.setAutoCommit(false);
            }
            try {
                IRepositorio<Categoria> repo = new CategoriaImpl(con);
                IRepositorio<Producto> repop = new ProductoIRepositorioImpl(con);
                System.out.println("Listar");
                repo.listar().forEach(System.out::println);

          //      System.out.println("===========================================================");
         //       System.out.println("Obtener por id");
            //    System.out.println(repo.porId(1L));


       //         System.out.println("=======================insertar======================");

         //       Categoria categoria= new Categoria();
          //      categoria.setNombre("Electrohogar");
         //       Categoria categoria1 = repo.guardar(categoria);
         //       System.out.println("Categoria guradada"+categoria1.getId());

            //    Producto producto = new Producto();
           //     producto.setNombre("monitor");
            //    producto.setPrecio(200);
             //   producto.setFecha(new Date());
              //  producto.setSku("asd5");

             //   producto.setCategoria(categoria1);
             //   repop.guardar(producto);
            //    System.out.println("Producto guardado con exito");
                repop.listar().forEach(System.out::println);

                con.commit();
            } catch (SQLException e) {
                System.out.println("Entrando al rollback");
                con.rollback();
                e.printStackTrace();
            }
        }
    }
}
    /*  System.out.println("===========================================================");
        System.out.println("Obtener por id");
        System.out.println(repositorio.porId(1L));
*/
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
  /*          System.out.println("=======================insertar======================");
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

*/
