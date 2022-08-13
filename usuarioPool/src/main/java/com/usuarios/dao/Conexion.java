package com.usuarios.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {
    private static String URL="jdbc:mysql://localhost:3306/rol?serverTimezone=America/El_Salvador";
    private static String USER="root";
    private static String PASS="1234";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() {
        if (pool==null){
            pool= new BasicDataSource();
            pool.setUrl(URL);
            pool.setUsername(USER);
            pool.setPassword(PASS);
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
            pool.setMaxTotal(8);
        }

        return pool;
    }

    public static Connection getConnection()throws SQLException {
        return  getInstance().getConnection();
    }
}
