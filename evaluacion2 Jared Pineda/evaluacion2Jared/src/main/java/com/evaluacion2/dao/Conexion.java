package com.evaluacion2.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class Conexion {


    private static String JDBC_URL="jdbc:mysql://localhost:9999/rh?useSSL=false";

    private static String JDBC_USER="root";

    private static String JDBC_PASS="12345";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null){
            pool = new BasicDataSource();
            pool.setUrl(JDBC_URL);
            pool.setUsername(JDBC_USER);
            pool.setPassword(JDBC_PASS);
            pool.setInitialSize(5);
            pool.setMinIdle(5);
            pool.setMaxIdle(10);
            pool.setMaxTotal(10);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException{
        return getInstance().getConnection();
    }
}
