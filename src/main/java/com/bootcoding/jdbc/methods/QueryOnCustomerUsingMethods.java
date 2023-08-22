package com.bootcoding.jdbc.methods;

import com.bootcoding.jdbc.utils.DBConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryOnCustomerUsingMethods {
    public  List<Customer> getAllCustomer(){
        try {
            Connection conn= DBConnectionUtils.getConnection();
            Statement stmt = conn.createStatement();
            String s=  "select * from customer";
            ResultSet rs = stmt.executeQuery(s);


            List<Customer> customers = new ArrayList<>();
            while (rs.next()){
                int customer_id = rs.getInt("customer_id");
                String name = rs.getString("cust_name");
                String city = rs.getString("city");
                String email = rs.getString("email");
                String salesmanId = rs.getString("salesman_id");

                Customer customer = new Customer();
                System.out.println("id = " + customer_id);
                System.out.println("name = " + name);
                System.out.println("city = " + city);
                System.out.println("email = " + email);
                System.out.println("salesman id = " + salesmanId);
                System.out.println();

                customers.add(customer);
            }
            conn.close();
            return customers;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public int getTotalCustomerCount(){
        try {
            Connection connection = DBConnectionUtils.getConnection();

            Statement stmt = connection.createStatement();

            ResultSet rs =  stmt.executeQuery("select count(*) from customer");

            if(rs.next()){
                int count = rs.getInt("count");
                System.out.println("Total no of customer"+count);
                return count;
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return -1;
    }


    // Get all customers who belong to specific CITY
    public void getCustomerFromSpecificCity(String cityName){
            try{
                Connection conn =  DBConnectionUtils.getConnection();

                Statement stmt = conn.createStatement();

                String sql = ("Select cust_name from customer where city = '"+cityName +"'");

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){

                    String name = rs.getString("cust_name");

                    System.out.println("name by city = " + name);

                }

                stmt.executeQuery(sql);
            }catch (Exception exception){
                exception.printStackTrace();
            }
    }

    // Tell me how many customer belongs to specific city we have
    // SELECT COUNT(*) from customer where city = 'specific';

    public void getCountOfCustomerFromSpecificCity(String cityName){
        try{
            Connection conn =  DBConnectionUtils.getConnection();

            Statement stmt = conn.createStatement();

            String sql = ("Select count(*) from customer where city = '"+cityName +"'");

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){

                int count = rs.getInt("count");
                System.out.println("count by city= "+count);

            }

            stmt.executeQuery(sql);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    // Get all customers which handled by specific salesman
    public void getCustomerBySalesman(int id){
        try {
            Connection connection = DBConnectionUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql = ("Select cust_name from customer where Salesman_id = '" + id +"'");

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                String name = resultSet.getString("cust_name");

                System.out.println("Name by salesman id= "+name);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }



}

