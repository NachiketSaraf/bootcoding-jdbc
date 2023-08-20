package com.bootcoding.jdbc;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserJdbcExample {
    public static void main(String[] args) {
        try{
            //1. load jdbc driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database connection
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","6969");

            /// 3. Query database using Statement Object
            Statement stmt = connection.createStatement();

            //4. Execute query
            ResultSet rs = stmt.executeQuery("select * from customer");
            System.out.println(rs);

            while (rs.next()){
                int customer_id = rs.getInt("customer_id");
                String name = rs.getString("cust_name");
                String city = rs.getString("city");
                String email = rs.getString("email");
                String salesmanId = rs.getString("salesman_id");

                System.out.println("id = " + customer_id);
                System.out.println("name = " + name);
                System.out.println("city = " + city);
                System.out.println("email = " + email);
                System.out.println("salesman id = " + salesmanId);
                System.out.println();
            }
            // 5. close connection
            connection.close();
        }

        catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
