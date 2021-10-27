package com.saleborg.lil.jdbc;


import com.saleborg.lil.jdbc.DAO.CustomerDAO;
import com.saleborg.lil.jdbc.DAO.OrderDAO;
import com.saleborg.lil.jdbc.models.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {

    public static void main(String[] args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");

        try {
            var connection = dcm.getConnection();
            customerRun(connection);

            orderRun(connection);


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    private static void orderRun(Connection connection) {

        OrderDAO orderDAO = new OrderDAO(connection);
        var order = orderDAO.findById(1000);
        System.out.println("--> Order from db: " +order);


    }

    private static void customerRun(Connection connection) {
        CustomerDAO customerDAO = new CustomerDAO(connection);

        var customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Adams");
        customer.setEmail("jadams@gov.com");
        customer.setAddress("1234 Main st");
        customer.setCity("Arlington");
        customer.setState("VA");
        customer.setPhone("23432");
        customer.setZipCode("123321");

        Customer dbCustomer = customerDAO.create(customer);
        System.out.println("--> customer not added yet: " + dbCustomer);
        dbCustomer = customerDAO.findById(dbCustomer.getId());
        System.out.println("--> customer from db: " + dbCustomer);
        dbCustomer.setEmail("John.adams@gov.com");
        dbCustomer = customerDAO.update(dbCustomer);
        System.out.println("--> Customer with updated email: " + dbCustomer);
        customerDAO.delete(dbCustomer.getId());
    }

}
