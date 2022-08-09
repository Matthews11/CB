package dao;

import domain.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAOJDBC implements UsuarioDAO {
    private Connection usercon;

    private static final String INSERT="INSERT INTO usuarios (usuario,password,mail)values(?,?,?)";
    private static final String UPDATE="UPDATE usuarios set usuario=?,  password=?,  mail=? where id=?";
    private static final String DELETE="DELETE FROM usuarios WHERE id=?";
    private static final String SELECT="SELECT * FROM usuarios ";

    public UsuariosDAOJDBC(){
    }
    public UsuariosDAOJDBC(Connection con){
        this.usercon=con;
    }


    @Override
    public int insert(UsuarioDTO usuarioDTO) throws SQLException {
        Connection conn =null;
        PreparedStatement ps = null;
        //   ResultSet rs =null;
        int rows =0;
        try {
            usercon= ((this.usercon)!=null) ? this.usercon:   Conexion.getConnection();
            ps = usercon.prepareStatement(INSERT);
            int index=1;
            ps.setString(index++, usuarioDTO.getUsuario());
            ps.setString(index++, usuarioDTO.getPassword());
            ps.setString(index++, usuarioDTO.getMail());
            System.out.println("Ejecutando el query: "+INSERT);
            rows=ps.executeUpdate();
            System.out.println("Registros afectados: "+ rows);

        }finally{
            Conexion.close(ps);
            if (this.usercon == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(UsuarioDTO usuarioDTO) throws SQLException {
        Connection conn =null;
        PreparedStatement ps = null;
        int rows =0;

        try {
            usercon= ((this.usercon)!=null) ? this.usercon:Conexion.getConnection();
            ps=usercon.prepareStatement(UPDATE);
            int index=1;
            ps.setString(index++, usuarioDTO.getUsuario());
            ps.setString(index++, usuarioDTO.getPassword());
            ps.setString(index++, usuarioDTO.getMail());
            ps.setInt(index++, usuarioDTO.getId());
            rows= ps.executeUpdate();
            System.out.println("Ejecutando el query: "+UPDATE);
            System.out.println("Registros actualizados "+rows);
        }finally{
            Conexion.close(ps);
            if (this.usercon == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int delete(UsuarioDTO usuarioDTO) throws SQLException {
        Connection conn =null;
        PreparedStatement ps = null;
        int rows= 0;
        try{
            usercon=  ((this.usercon)!=null) ? this.usercon:Conexion.getConnection();
            ps=usercon.prepareStatement(DELETE);
            int index=1;
            ps.setInt(index++,usuarioDTO.getId());
            rows=ps.executeUpdate();
            System.out.println("Ejecutando el query"+DELETE);
            System.out.println("Registros eliminados "+rows);
        } finally {
            Conexion.close(ps);
            if (this.usercon == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public List<UsuarioDTO> select() throws SQLException {
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        UsuarioDTO usuario =null;
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try {
            conn= ((this.usercon)!=null) ? this.usercon:Conexion.getConnection();
            ps=usercon.prepareStatement(SELECT);
            rs=ps.executeQuery();
            while (rs.next()){
                usuario = new UsuarioDTO();
                usuario.setId(rs.getInt(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setPassword(rs.getString(3));
                usuario.setMail(rs.getString(4));
                usuarios.add(usuario);
            }
        }finally {
            Conexion.close(ps);
            Conexion.close(rs);
            if (this.usercon == null){
                Conexion.close(conn);
            }
        }
        return usuarios;
    }
}
