package jdbc;

import java.sql.*;

public class Conexion {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/sga?useSSL=false";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = (Connection) DriverManager.getConnection(url,"root","1234");

            Statement instruccion= conexion.createStatement();

            String sql="select * from persona";

            ResultSet result = instruccion.executeQuery(sql);

            while(result.next()){
                System.out.println("id: "+result.getInt(1));
                System.out.println("nombre: "+result.getString(2));
                System.out.println("apellido: "+result.getString(3));
            }
            result.close();
            instruccion.close();
            conexion.close();

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
