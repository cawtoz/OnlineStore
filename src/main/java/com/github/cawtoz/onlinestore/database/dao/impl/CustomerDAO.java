package com.github.cawtoz.onlinestore.database.dao.impl;

import com.github.cawtoz.onlinestore.database.StatementBuilder;
import com.github.cawtoz.onlinestore.database.dao.DAO;
import com.github.cawtoz.onlinestore.model.Customer;
import com.github.cawtoz.onlinestore.model.enums.UserType;
import lombok.SneakyThrows;

import java.sql.ResultSet;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class CustomerDAO extends DAO<Customer> {

    public CustomerDAO() {
        super(
                "CALL create_customer(?, ?, ?, ?, ?, ?, ?)",
                "CALL read_customer(?)",
                "CALL update_customer(?, ?, ?, ?, ?, ?, ?, ?)",
                "CALL delete_customer(?)",
                "SELECT * FROM customers"
        );
    }

    @Override
    public int getRecordId(Customer customer) {
        return customer.getId();
    }

    @Override
    public void setCreateValues(Customer customer, StatementBuilder statement) {
        statement
                .setString(1, customer.getName())
                .setString(2, customer.getAddress())
                .setString(3, customer.getPhone())
                .setString(4, customer.getEmail())
                .setString(5, customer.getUsername())
                .setString(6, customer.getPassword())
                .setString(7, customer.getUserType().toString().toLowerCase());
    }

    @Override
    public void setUpdateValues(Customer customer, StatementBuilder statement) {
        setCreateValues(customer, statement);
        statement.setInt(8, customer.getId());
    }

    @Override
    @SneakyThrows
    public Customer getRecordObject(ResultSet resultSet) {
        return new Customer(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("address"),
                resultSet.getString("phone"),
                resultSet.getString("email"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                UserType.valueOf(resultSet.getString("user_type").toUpperCase())
        );
    }

}