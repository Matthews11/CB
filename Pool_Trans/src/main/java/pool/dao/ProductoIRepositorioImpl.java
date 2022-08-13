package pool.dao;

import pool.dto.Categoria;
import pool.dto.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoIRepositorioImpl implements IRepositorio<Producto> {

    private Connection con;

    public ProductoIRepositorioImpl(Connection con) throws SQLException {
        this.con=con;
    }

    @Override
    public List listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try(Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT p.* , c.id, c.nombre as ca  " +
                    " from productos as p inner join categorias as c on (p.idc =c.id)")){

            while (rs.next()){
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto =null;
        try (PreparedStatement ps = con.prepareStatement("SELECT p.*, c.nombre as categoria " +
                     " from productos as p inner join categorias as c on (p.idc =c.id) WHERE p.idp=?")){
            ps.setLong(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    producto = crearProducto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        String sql;

        if (producto.getId() !=null && producto.getId()>0){
            sql="UPDATE productos SET nombre=?,precio=?, idc=?, sku=? WHERE idp=?";
        }else {
            sql="INSERT INTO productos (nombre,precio,idc,sku,fecha)values (?,?,?,?,?)";
        }
        try(PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, producto.getNombre());
            ps.setLong(2,producto.getPrecio());
            ps.setLong(3,producto.getCategoria().getId());
            ps.setString(4, producto.getSku());

            if(producto.getId()!=null && producto.getId()>0){
                ps.setLong(5,producto.getId());
            }else{

                ps.setDate(5, new Date(producto.getFecha().getTime()));
            }
            ps.executeUpdate();
            if (producto.getId()==null){
                try (ResultSet rs =ps.getGeneratedKeys()){
                    if (rs.next()){
                        producto.setId(rs.getLong(1));
                    }
                }
            }
        }
        return producto;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM productos WHERE idp=?") ){
        ps.setLong(1,id);
        ps.executeUpdate();
        }
    }

    private Producto crearProducto(ResultSet rs)throws SQLException{
        Producto p = new Producto();
        p.setId(rs.getLong("idp"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFecha(rs.getDate("fecha"));
        p.setSku(rs.getString("sku"));
        Categoria c = new Categoria();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("ca"));
        p.setCategoria(c);
        return p;
    }
}
