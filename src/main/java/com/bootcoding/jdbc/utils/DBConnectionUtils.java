package com.bootcoding.jdbc.utils;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtils {
    public static Connection getConnection(){

        try {
            Class.forName("org.postgresql.Driver");

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","6969");
            return connection;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
