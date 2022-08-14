package com.app.usuario.dao;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class Conexion {
    private static String url="jdbc:mysql://localhost:3306/rol?serverTimezone=America/El_Salvador";

    private static String JDBC_USER="root";

    private static String JDBC_PASS="1234";

    private static BasicDataSource pool;

    public static BasicDataSource getPool() {
        if (pool==null){
            pool=new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(JDBC_USER);
            pool.setPassword(JDBC_PASS);
            pool.setInitialSize(10);
            pool.setMinIdle(10);
            pool.setMaxIdle(20);
            pool.setMaxTotal(20);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        return getPool().getConnection();
    }

    public static void close(PreparedStatement ps) throws SQLException {
       ps.close();
    }


    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }


    public static void close(Statement st) throws SQLException {
        st.close();
    }


    public static void close(Connection con) throws SQLException {
        con.close();
    }
}
