package com.usuarios.dao;

import com.usuarios.dto.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.usuarios.dao.*;

public class UsuarioImpl implements Repositorio<User>{

    private Connection getConnection() throws SQLException {
        return Conexion.getConnection();

    }

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM usuarios");){
            while(rs.next()){
                User user = createUser(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("ocurrio un error");
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User listById(Long id) {
        User user =null;
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM usuarios WHERE id=?")){
            ps.setLong(1,id);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()){
                    user=createUser(rs);
                }

            }
        }catch (SQLException e){
            System.out.println("ocurrio un error");
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void save(User user) {
        String sql;
        if (user.getId()!=null && user.getId()>0){
            sql="UPDATE usuarios SET usuario=?, password=?, fecha=? WHERE id=?";

        }else{
            sql="INSERT INTO usuarios (usuario,password,fecha) VALUES(?,?,?)";
        }
        try (Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,user.getUser());
            ps.setString(2,user.getPassword());
            ps.setDate(3,  new Date(user.getDate().getTime()));
            if (user.getId()!=null && user.getId()>0){
                ps.setLong(4,user.getId());
                ps.executeUpdate();
            }else{
               ps.executeUpdate();
            }

        }catch (SQLException e){
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {
        try (Connection con = getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE id=?")){
            ps.setLong(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private User createUser(ResultSet rs)throws SQLException{
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUser(rs.getString("usuario"));
        user.setPassword(rs.getString("password"));
        user.setDate(rs.getDate("fecha"));
        return user;
    }
}
