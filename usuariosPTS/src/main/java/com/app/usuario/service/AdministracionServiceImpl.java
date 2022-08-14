package com.app.usuario.service;

import com.app.usuario.dao.Conexion;
import com.app.usuario.dao.IUsuarioRespositorio;
import com.app.usuario.dao.UsuarioRepositorioImpl;
import com.app.usuario.dto.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AdministracionServiceImpl implements IAdministracionService {

    private IUsuarioRespositorio<Usuario> usuarioR;

    public AdministracionServiceImpl() throws SQLException {
        this.usuarioR = new UsuarioRepositorioImpl();
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        try (Connection con = Conexion.getConnection()) {
            usuarioR.setCon(con);
            return usuarioR.listar();
        }
    }

    @Override
    public Usuario guardar(Usuario usuario) throws SQLException {
        Usuario usuario1 = null;
        try (Connection con = Conexion.getConnection()) {
            usuarioR.setCon(con);
            if (con.getAutoCommit()) {
                con.setAutoCommit(false);
            }
            try {
                usuario1 = usuarioR.guardar(usuario);
                con.commit();
            } catch (SQLException e) {
                System.out.println("Entrando rollback");
                con.rollback();
                e.printStackTrace();
            }
        }
        return usuario1;
    }

    @Override
    public Usuario obtener(Long id) throws SQLException {
        Usuario nuevoUsuario;
        try (Connection con = Conexion.getConnection()) {
            usuarioR.setCon(con);
            return nuevoUsuario = usuarioR.obtener(id);
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (Connection con = Conexion.getConnection()) {
            usuarioR.setCon(con);
            if (con.getAutoCommit()) {
                con.setAutoCommit(false);
            }
            try {
                usuarioR.eliminar(id);
                con.commit();
            } catch (SQLException e) {
                System.out.println("Entrando al rollback");
                con.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean comprobar(Usuario usuario) throws SQLException {
        boolean u = false;
        try (Connection con = Conexion.getConnection()) {
            usuarioR.setCon(con);
            u = usuarioR.sesion(usuario);
            if (u == true) {
                System.out.println("iniciando sesion");
                return true;
            } else {
                System.out.println("credenciales incorrectas");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
