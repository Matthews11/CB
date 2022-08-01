package datos;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import domain.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonasJDBC {

    private final String SQL_INSERT="INSERT INTO persona(nombre,apellido) values(?,?)";

    private final String SQL_UPDATE="UPDATE persona SET nombre=?, apellido=? WHERE id=?";

    private final String SQL_DELETE="DELETE FROM persona WHERE id=?";

    private final String SQL_LISTAR="SELECT * FROM persona ORDER BY id=?";

    public int insert(String nombre, String apellido){
        Connection conn = null;
        PreparedStatement ps = null;
     //   ResultSet rs =null;
        int rows =0;
        try {
            conn=Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            int index=1;
            ps.setString(index++, nombre);
            ps.setString(index++,apellido);
            System.out.println("Ejecutando el query: "+SQL_INSERT);
            rows=ps.executeUpdate();
            System.out.println("Registros afectados: "+ rows);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int update(int id, String nombre, String apellido){
        Connection conn=null;
        PreparedStatement ps = null;
        int rows =0;

        try {
            conn= Conexion.getConnection();
            System.out.println("Ejecutando el query: "+SQL_UPDATE);
            ps=conn.prepareStatement(SQL_UPDATE);
            int index=1;
            ps.setString(index++,nombre);
            ps.setString(index++, apellido);
            ps.setInt(index++, id);
            rows= ps.executeUpdate();
            System.out.println("Registros actualizados "+rows);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public int delete(int id){
        Connection conn = null;
        PreparedStatement ps = null;
        int rows= 0;
        try{
            conn= Conexion.getConnection();
            ps=conn.prepareStatement(SQL_DELETE);
            ps.setInt(1,id);
            rows=ps.executeUpdate();
            System.out.println("Registros eliminados "+rows);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Conexion.close(ps);
            Conexion.close(conn);
        }
        return rows;
    }

    public List<Persona> select(int id1){

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        Persona persona =null;
        List<Persona> personas = new ArrayList<>();
        try {
            conn=Conexion.getConnection();
            ps=conn.prepareStatement(SQL_LISTAR);
            ps.setInt(1,id1);
            rs=ps.executeQuery();
            while (rs.next()){
                persona = new Persona();
                int id=rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);

                persona.setId(id);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                personas.add(persona);
            }

        }catch (SQLException e){
            e.printStackTrace();

        }finally {
            Conexion.close(ps);
            Conexion.close(rs);
            Conexion.close(conn);
        }
        return personas;
    }
}
