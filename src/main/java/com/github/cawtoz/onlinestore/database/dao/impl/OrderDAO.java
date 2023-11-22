package com.github.cawtoz.onlinestore.database.dao.impl;

import com.github.cawtoz.onlinestore.database.StatementBuilder;
import com.github.cawtoz.onlinestore.database.dao.DAO;
import com.github.cawtoz.onlinestore.model.Order;
import com.github.cawtoz.onlinestore.model.enums.OrderStatus;
import lombok.SneakyThrows;

import java.sql.ResultSet;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class OrderDAO extends DAO<Order> {

    public OrderDAO() {
        super(
                "CALL create_order(?, ?, ?)",
                "CALL read_order(?)",
                "CALL update_order(?, ?, ?, ?)",
                "CALL delete_order(?)",
                "SELECT * FROM orders"
        );
    }

    @Override
    public int getRecordId(Order order) {
        return order.getId();
    }

    @Override
    public void setCreateValues(Order order, StatementBuilder statement) {
        statement
                .setInt(1, order.getCustomerId())
                .setDate(2, order.getDate())
                .setString(3, order.getOrderStatus().toString().toLowerCase());
    }

    @Override
    public void setUpdateValues(Order order, StatementBuilder statement) {
        setCreateValues(order, statement);
        statement.setInt(4, order.getId());
    }

    @Override
    @SneakyThrows
    public Order getRecordObject(ResultSet resultSet) {
        return new Order(
                resultSet.getInt("id"),
                resultSet.getInt("customer_id"),
                resultSet.getDate("date"),
                OrderStatus.valueOf(resultSet.getString("status").toUpperCase())
        );
    }

}