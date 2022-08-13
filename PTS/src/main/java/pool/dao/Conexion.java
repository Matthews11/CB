package pool.dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {

    private static String url="jdbc:mysql://localhost:9999/hibernate?serverTimezone=America/El_Salvador";

    private static String JDBC_USER="root";

    private static String JDBC_PASS="12345";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null){
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setUsername(JDBC_USER);
            pool.setPassword(JDBC_PASS);
            pool.setInitialSize(3);
            pool.setMinIdle(3);
            pool.setMaxIdle(8);
            pool.setMaxTotal(8);
        }
        return pool;
    }

    public static Connection getConnection() throws SQLException{
        return getInstance().getConnection();
    }
}
