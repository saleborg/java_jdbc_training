package com.saleborg.lil.jdbc;


import java.sql.SQLException;

public class JDBCExecutor {

    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");

        try {
            var connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
            var customer = customerDAO.findById(10000);
            System.out.println(customer.getFirstName());

            customer.setFirstName("Stefan");
            customer = customerDAO.update(customer);
            System.out.println(customer.getFirstName());

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
