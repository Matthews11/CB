package datos;

import java.sql.*;

public class Conexion {


    private static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";

    private static String JDBC_URL="jdbc:mysql://localhost:9999/sga?useSSL=false";

    private static String JDBC_USER="root";

    private static String JDBC_PASS="12345";

    private static Driver driver =null;

   // protected PreparedStatement ps;
   //   protected ResultSet rs;

    public static synchronized Connection getConnection() throws SQLException{
            if (driver==null){
                try {
                    Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                    driver = (Driver) jdbcDriverClass.newInstance();
                    DriverManager.registerDriver(driver);
                }catch (Exception e){
                    System.out.println("Fallo en cargar el driver JDBC");
                    e.printStackTrace();
                }
            }
            return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }

    public static void close(ResultSet rs){
        try{
            if (rs!=null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps){
        try{
            if (ps!=null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(Connection conn){
        try {
            if (conn !=null){
                conn.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
