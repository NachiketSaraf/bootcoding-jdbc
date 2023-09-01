package com.bootcoding.jdbc.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteJdbc {
    public static void main(String[] args) {
        try{
            //1. load jdbc driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database connection
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","6969");

            /// 3. Query database using Statement Object
            Statement stmt = connection.createStatement();

            //4
            stmt.executeUpdate("delete from customer where customer_id between 500 and 1000");


            // 5. close connection
            connection.close();
        }

        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
