package com.github.cawtoz.onlinestore.database;

import com.github.cawtoz.onlinestore.OnlineStore;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@AllArgsConstructor
public class StatementBuilder {

    private Connection connection;
    private PreparedStatement statement;

    @SneakyThrows
    public StatementBuilder(String sql) {
        connection = OnlineStore.getDatabase().getConnection();
        statement = connection.prepareStatement(sql);
    }

    @SneakyThrows
    public StatementBuilder setString(int index, String value) {
        statement.setString(index, value);
        return this;
    }

    @SneakyThrows
    public StatementBuilder setInt(int index, int value) {
        statement.setInt(index, value);
        return this;
    }

    @SneakyThrows
    public StatementBuilder setDouble(int index, double value) {
        statement.setDouble(index, value);
        return this;
    }

    @SneakyThrows
    public StatementBuilder setDate(int index, Date value) {
        statement.setDate(index, value);
        return this;
    }

    @SneakyThrows
    public ResultSet executeQuery() {
        return statement.executeQuery();
    }

    @SneakyThrows
    public StatementBuilder executeUpdate() {
        statement.executeUpdate();
        return this;
    }

    @SneakyThrows
    public void close() {
        statement.close();
        connection.close();
    }

    @SneakyThrows
    public PreparedStatement build() {
        return statement;
    }

}
