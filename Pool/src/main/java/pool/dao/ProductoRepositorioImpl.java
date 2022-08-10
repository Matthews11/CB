package pool.dao;

import pool.dto.Categorias;
import pool.dto.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto>{

    private Connection getConnection()throws SQLException {
            return Conexion.getConnection();

    }

    @Override
    public List listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try(Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT p.* , c.nombre as categoria" +
                    " from productos as p inner join categorias as c on (p.idc =c.id)")){

            while (rs.next()){
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto =null;
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT p.*, c.nombre as categoria" +
                     " from productos as p inner join categorias as c on (p.idc =c.id) WHERE p.idp=?")){
            ps.setLong(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    producto = crearProducto(rs);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {
        String sql;

        if (producto.getId() !=null && producto.getId()>0){
            sql="UPDATE productos SET nombre=?,precio=?, idc=? WHERE idp=?";
        }else {
            sql="INSERT INTO productos (nombre,precio,idc,fecha)values (?,?,?,?)";
        }
        try(Connection con =getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, producto.getNombre());
            ps.setLong(2,producto.getPrecio());
            ps.setLong(3,producto.getCategoria().getId());

            if(producto.getId()!=null && producto.getId()>0){
                ps.setLong(4,producto.getId());
            }else{
                ps.setDate(4, new Date(producto.getFecha().getTime()));
            }
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try (Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM productos WHERE idp=?") ){
        ps.setLong(1,id);
        ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private Producto crearProducto(ResultSet rs)throws SQLException{
        Producto p = new Producto();
        p.setId(rs.getLong("idp"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFecha(rs.getDate("fecha"));
        Categorias c = new Categorias();
        c.setId(rs.getLong("idc"));
        c.setNombre(rs.getString("nombre"));
        p.setCategoria(c);
        return p;
    }
}
