package com.bootcoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertJdbcExample {
    public static void main(String[] args) {
        try{
            //1. load jdbc driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database connection
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","6969");

            /// 3. Query database using Statement Object
            Statement stmt = connection.createStatement();

            stmt.executeUpdate("insert into customer ")

            //4. Execute query
            ResultSet rs = stmt.executeQuery("select * from customer");
            System.out.println(rs);

            // 5. close connection
            connection.close();
        }

        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
