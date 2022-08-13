package pool.servicio;

import pool.dao.CategoriaImpl;
import pool.dao.Conexion;
import pool.dao.IRepositorio;
import pool.dao.ProductoIRepositorioImpl;
import pool.dto.Categoria;
import pool.dto.Producto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoImpl implements IServicio{

    private IRepositorio<Producto> productoIRepositorio;
    private IRepositorio<Categoria> categoriaIRepositorio;

   public CatalogoImpl() throws SQLException {
       this.productoIRepositorio=new ProductoIRepositorioImpl();
       this.categoriaIRepositorio=new CategoriaImpl();
   }

    @Override
    public List<Producto> listarP() throws SQLException {
       try (Connection con = Conexion.getConnection()){
           productoIRepositorio.setCon(con);
           return productoIRepositorio.listar();
       }
    }

    @Override
    public Producto porIdP(Long id) throws SQLException {
        try (Connection con = Conexion.getConnection()){
            productoIRepositorio.setCon(con);
          return productoIRepositorio.porId(id);
        }
    }

    @Override
    public Producto guardarP(Producto producto) throws SQLException {
        try(Connection con = Conexion.getConnection()){
            productoIRepositorio.setCon(con);

            if (con.getAutoCommit()){
                con.setAutoCommit(false);
            }
            Producto nuevoProducto = null;
            try {
                nuevoProducto =productoIRepositorio.guardar(producto);
                con.commit();
            }catch (SQLException e ){
                con.rollback();
                e.printStackTrace();
            }return nuevoProducto;
        }
    }

    @Override
    public void eliminarP(Long id) throws SQLException {
       try (Connection con = Conexion.getConnection()){
           productoIRepositorio.setCon(con);
           if (con.getAutoCommit()){
               con.setAutoCommit(false);
           }
           try {
               productoIRepositorio.eliminar(id);
               con.commit();
           }catch (SQLException e){
               con.rollback();
               e.printStackTrace();
           }

       }

    }

    @Override
    public List<Categoria> listarC() throws SQLException {
        try (Connection con = Conexion.getConnection()){
            categoriaIRepositorio.setCon(con);
            return categoriaIRepositorio.listar();
        }
    }

    @Override
    public Categoria porIdC(Long id) throws SQLException {
        try (Connection con = Conexion.getConnection()){
            categoriaIRepositorio.setCon(con);
            return categoriaIRepositorio.porId(id);
        }
    }

    @Override
    public Categoria guardarC(Categoria categoria) throws SQLException {
        try(Connection con = Conexion.getConnection()){
            categoriaIRepositorio.setCon(con);

            if (con.getAutoCommit()){
                con.setAutoCommit(false);
            }
            Categoria nuevaCategoria = null;
            try {
                nuevaCategoria =categoriaIRepositorio.guardar(categoria);
                con.commit();
            }catch (SQLException e ){
                con.rollback();
                e.printStackTrace();
            }return nuevaCategoria;
        }
    }

    @Override
    public void eliminarC(Long id) throws SQLException {
        try (Connection con = Conexion.getConnection()){
            categoriaIRepositorio.setCon(con);
            if (con.getAutoCommit()){
                con.setAutoCommit(false);
            }
            try {
                categoriaIRepositorio.eliminar(id);
                con.commit();
            }catch (SQLException e){
                con.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void guardarPC(Producto producto, Categoria categoria) throws SQLException {
       try(Connection con=Conexion.getConnection()){
           productoIRepositorio.setCon(con);
           categoriaIRepositorio.setCon(con);
        if (con.getAutoCommit()){
            con.setAutoCommit(false);
        }
        try {
            Categoria nuevac= categoriaIRepositorio.guardar(categoria);
            producto.setCategoria(nuevac);
            productoIRepositorio.guardar(producto);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            e.printStackTrace();
        }


       }



    }
}
