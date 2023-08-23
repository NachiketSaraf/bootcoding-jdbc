package com.bootcoding.jdbc.crud;

import com.bootcoding.jdbc.utils.DBConnectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateJdbc {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");

            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres","6969");
            Statement statement =  conn.createStatement();
            String sqlQuery = "update customer set city = 'Chandrapur' where customer_id = 1100 ";

            statement.executeUpdate(sqlQuery);

            conn.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
