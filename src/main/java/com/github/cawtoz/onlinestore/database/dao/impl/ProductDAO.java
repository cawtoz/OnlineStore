package com.github.cawtoz.onlinestore.database.dao.impl;

import com.github.cawtoz.onlinestore.database.StatementBuilder;
import com.github.cawtoz.onlinestore.database.dao.DAO;
import com.github.cawtoz.onlinestore.model.Product;
import lombok.SneakyThrows;

import java.sql.ResultSet;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class ProductDAO extends DAO<Product> {

    public ProductDAO() {
        super(
                "CALL create_product(?, ?, ?, ?)",
                "CALL read_product(?)",
                "CALL update_product(?, ?, ?, ?, ?)",
                "CALL delete_product(?)",
                "SELECT * FROM products"
        );
    }

    @Override
    public int getRecordId(Product product) {
        return product.getId();
    }

    @Override
    public void setCreateValues(Product product, StatementBuilder statement) {
        statement
                .setString(1, product.getName())
                .setDouble(2, product.getPrice())
                .setInt(3, product.getStock())
                .setString(4, product.getDescription());
    }

    @Override
    public void setUpdateValues(Product product, StatementBuilder statement) {
        setCreateValues(product, statement);
        statement.setInt(5, product.getId());
    }

    @Override
    @SneakyThrows
    public Product getRecordObject(ResultSet resultSet) {
        return new Product(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getDouble("price"),
                resultSet.getInt("stock"),
                resultSet.getString("description")
        );
    }

}