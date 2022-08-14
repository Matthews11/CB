package com.app.usuario.dao;

import com.app.usuario.dto.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements IUsuarioRespositorio<Usuario>{

    private Connection con;

    public UsuarioRepositorioImpl() throws SQLException{

    }

    @Override
    public void setCon(Connection con) {
        this.con=con;
    }

    @Override
    public boolean sesion(Usuario usuario) throws SQLException {
        Usuario s = null;
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE usuario=? AND password=?")){
            ps.setString(1,usuario.getUsuario());
            ps.setString(2,usuario.getPassword());
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    s=crearUsuario(rs);
                }
            }
            if (usuario.getUsuario().equals(s.getUsuario())&& usuario.getPassword().equals(s.getPassword())){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM usuarios")){
            while (rs.next()){
                usuarios.add(crearUsuario(rs));
            }
        }
        return usuarios;
    }


    @Override
    public Usuario guardar(Usuario usuario) throws SQLException {
        String sql;
        if (usuario.getId()!=null && usuario.getId()>0){
            sql="UPDATE usuarios SET usuario=?, password=?, fecha=? WHERE id=?";
        }else {
            sql="INSERT INTO usuarios (usuario,password,fecha) values (?,?,?)";
        }
        try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,usuario.getUsuario());
            ps.setString(2,usuario.getPassword());
            ps.setDate(3,new Date(usuario.getFecha().getTime()));
            if (usuario.getId()!=null && usuario.getId()>0){
                ps.setLong(4,usuario.getId());
            }
            ps.executeUpdate();
            if (usuario.getId()==null){
                try (ResultSet rs=ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        usuario.setId(rs.getLong(1));
                    }
                }
            }
        }
        return usuario;
    }

    @Override
    public Usuario obtener(Long id) throws SQLException {
        Usuario usuario=null;
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE id=?")){
            ps.setLong(1,id);
            try (ResultSet rs= ps.executeQuery()){
                if (rs.next()){
                    usuario=crearUsuario(rs);
                }
            }
        }
        return usuario;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE id=?")){
            ps.setLong(1,id);
            ps.executeUpdate();
        }
    }

    private Usuario crearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(rs.getLong("id"));
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setPassword(rs.getString("password"));
        usuario.setFecha(rs.getDate("fecha"));
        return usuario;
    }


}
