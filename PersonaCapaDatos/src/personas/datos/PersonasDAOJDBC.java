package personas.datos;

import personas.domain.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonasDAOJDBC implements PersonaDAO{

    private Connection useConnn;

    private final String SQL_INSERT="INSERT INTO persona(nombre,apellido) values(?,?)";

    private final String SQL_UPDATE="UPDATE persona SET nombre=?, apellido=? WHERE id=?";

    private final String SQL_DELETE="DELETE FROM persona WHERE id=?";

    private final String SQL_LISTAR="SELECT * FROM persona ";

    public PersonasDAOJDBC(){}

    public PersonasDAOJDBC(Connection conn){this.useConnn=conn;}

    @Override
    public int insert(PersonaDTO personaDTO) throws SQLException {
        Connection conn =null;
        PreparedStatement ps = null;
        //   ResultSet rs =null;
        int rows =0;
        try {
            useConnn= ((this.useConnn)!=null) ? this.useConnn:   Conexion.getConnection();
            ps = useConnn.prepareStatement(SQL_INSERT);
            int index=1;
            ps.setString(index++, personaDTO.getNombre());
            ps.setString(index++, personaDTO.getApellido());
            System.out.println("Ejecutando el query: "+SQL_INSERT);
            rows=ps.executeUpdate();
            System.out.println("Registros afectados: "+ rows);

        }finally{
            Conexion.close(ps);
            if (this.useConnn == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int update(PersonaDTO personaDTO) throws SQLException {
        Connection conn =null;
        PreparedStatement ps = null;
        int rows =0;

        try {
            conn= ((this.useConnn)!=null) ? this.useConnn:Conexion.getConnection();
            System.out.println("Ejecutando el query: "+SQL_UPDATE);
            ps=useConnn.prepareStatement(SQL_UPDATE);
            int index=1;
            ps.setString(index++, personaDTO.getNombre());
            ps.setString(index++, personaDTO.getApellido());
            ps.setInt(index++, personaDTO.getId());
            rows= ps.executeUpdate();
            System.out.println("Registros actualizados "+rows);
        } finally{
            Conexion.close(ps);
            if (this.useConnn == null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public int delete(PersonaDTO personaDTO) throws SQLException {
        Connection conn =null;
        PreparedStatement ps = null;
        int rows= 0;
        try{
            conn=  ((this.useConnn)!=null) ? this.useConnn:Conexion.getConnection();
            ps=useConnn.prepareStatement(SQL_DELETE);
            ps.setInt(1,personaDTO.getId());
            rows=ps.executeUpdate();
            System.out.println("Registros eliminados "+rows);
        }finally {
            Conexion.close(ps);
            if (this.useConnn == null){
            Conexion.close(conn);
            }
        }
        return rows;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {

        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        PersonaDTO persona =null;
        List<PersonaDTO> personas = new ArrayList<>();
        try {
            conn= ((this.useConnn)!=null) ? this.useConnn:Conexion.getConnection();
            ps=useConnn.prepareStatement(SQL_LISTAR);
            rs=ps.executeQuery();
            while (rs.next()){
                persona = new PersonaDTO();
                int id=rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);

                persona.setId(id);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                personas.add(persona);
            }

        } finally {
            Conexion.close(ps);
            Conexion.close(rs);
            if (this.useConnn == null){
                Conexion.close(conn);
            }
        }
        return personas;
    }
}
