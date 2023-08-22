package com.bootcoding.jdbc;

import com.bootcoding.jdbc.methods.QueryOnCustomerUsingMethods;

public class CustomerApp {
    public static void main(String[] args) {
        QueryOnCustomerUsingMethods qm = new QueryOnCustomerUsingMethods();
        qm.getAllCustomer();
        qm.getTotalCustomerCount();
        System.out.println();
        qm.getCustomerFromSpecificCity("Strasbourg");
        qm.getCountOfCustomerFromSpecificCity("Nagpur");
        qm.getCustomerBySalesman(123);

    }
}
