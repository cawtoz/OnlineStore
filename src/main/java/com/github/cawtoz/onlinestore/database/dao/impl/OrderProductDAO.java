package com.github.cawtoz.onlinestore.database.dao.impl;

import com.github.cawtoz.onlinestore.database.StatementBuilder;
import com.github.cawtoz.onlinestore.database.dao.DAO;
import com.github.cawtoz.onlinestore.model.OrderProduct;
import lombok.SneakyThrows;

import java.sql.ResultSet;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class OrderProductDAO extends DAO<OrderProduct> {

    public OrderProductDAO() {
        super(
                "CALL create_order_product(?, ?, ?)",
                "CALL read_order_product(?)",
                "CALL update_order_product(?, ?, ?, ?)",
                "CALL delete_order_product(?)",
                "SELECT * FROM order_products"
        );
    }

    @Override
    public int getRecordId(OrderProduct orderProduct) {
        return orderProduct.getId();
    }

    @Override
    public void setCreateValues(OrderProduct orderProduct, StatementBuilder statement) {
        statement
                .setInt(1, orderProduct.getOrderId())
                .setInt(2, orderProduct.getProductId())
                .setInt(3, orderProduct.getQuantity());
    }

    @Override
    public void setUpdateValues(OrderProduct orderProduct, StatementBuilder statement) {
        setCreateValues(orderProduct, statement);
        statement.setInt(4, orderProduct.getId());
    }

    @Override
    @SneakyThrows
    public OrderProduct getRecordObject(ResultSet resultSet) {
        return new OrderProduct(
                resultSet.getInt("id"),
                resultSet.getInt("order_id"),
                resultSet.getInt("product_id"),
                resultSet.getInt("quantity")
        );
    }

}