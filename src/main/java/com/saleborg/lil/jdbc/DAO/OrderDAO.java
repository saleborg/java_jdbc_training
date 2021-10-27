package com.saleborg.lil.jdbc.DAO;


import com.saleborg.lil.jdbc.models.Order;
import com.saleborg.lil.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO extends DataAccessObject<Order> {

    private static final String GET_ONE = "SELECT order_id, creation_date, total_due, status, customer_id, salesperson_id FROM orders WHERE order_id = ?";

    public OrderDAO(Connection connection) {
        super(connection);
    }


    @Override
    public Order findById(long id) {
        Order order = new Order();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE)){
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                order.setId(rs.getLong("order_id"));
                order.setCreationDate(rs.getString("creation_date"));
                order.setCustomerId(rs.getLong("total_due"));
                order.setSalespersonId(rs.getLong("salesperson_id"));
                order.setStatus(rs.getString("status"));
                order.setTotalDue(rs.getInt("total_due"));
            }



        } catch (SQLException throwable) {
            throwable.printStackTrace();
            throw new RuntimeException(throwable);

        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public Order create(Order dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
