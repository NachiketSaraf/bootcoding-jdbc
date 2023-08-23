package com.bootcoding.jdbc.crud;

import com.bootcoding.jdbc.utils.DBConnectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertJdbc {
    public static void main(String[] args) {
        try{
            // 1. Load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // 2. Get Database Connection Object
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "6969");

            // 3. Query Database using Statement Object
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO customer VALUES(1100, 'Raju', 'Nagpur', 'raju@nagpur.com', 753)";

            // 4. Execute Query and Get ResultSet
            stmt.executeUpdate(sql);

            // 5.Connection CLose;
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
