package pool.dao;

import pool.dto.Categoria;
import pool.dto.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaImpl implements IRepositorio<Categoria> {

    private Connection con;

    public CategoriaImpl(Connection con) throws SQLException {
        this.con=con;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try(Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM categorias")){
            while (rs.next()){
                categorias.add(crearCategoria(rs));
            }
        }
        return categorias;
    }


    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria =null;
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM categorias WHERE id=?")){
            ps.setLong(1,id);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    categoria = crearCategoria(rs);
                }
            }
        }
        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String sql;

        if (categoria.getId() !=null && categoria.getId()>0){
            sql="UPDATE categorias SET nombre=? WHERE id=?";
        }else {
            sql="INSERT INTO categorias (nombre)values (?)";
        }
        try(PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, categoria.getNombre());
            if(categoria.getId()!=null && categoria.getId()>0){
                ps.setLong(2,categoria.getId());
            }
            ps.executeUpdate();
            if (categoria.getId()==null){
                try (ResultSet rs =ps.getGeneratedKeys()){
                    if (rs.next()){
                        categoria.setId(rs.getLong(1));
                    }
                }
            }
        }
        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM categorias WHERE id=?")){
            ps.setLong(1,id);
            ps.executeUpdate();
        }
    }
    private Categoria crearCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        return c;
    }

}
