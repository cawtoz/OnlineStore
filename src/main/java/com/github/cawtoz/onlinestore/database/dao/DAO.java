package com.github.cawtoz.onlinestore.database.dao;

import com.github.cawtoz.onlinestore.database.StatementBuilder;
import com.github.cawtoz.onlinestore.database.dao.interfaces.CRUD;
import com.github.cawtoz.onlinestore.database.dao.interfaces.RecordDAO;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@AllArgsConstructor
public abstract class DAO<T> implements CRUD<T>, RecordDAO<T> {

    private String createSql, readSql, updateSql, deleteSql, allSql;

    public void create(T record) {
        StatementBuilder statementBuilder = new StatementBuilder(createSql);
        setCreateValues(record, statementBuilder);
        statementBuilder.executeUpdate().close();
    }

    @SneakyThrows
    public T read(int recordId) {
        StatementBuilder statementBuilder = new StatementBuilder(readSql);
        ResultSet resultSet = statementBuilder.setInt(1, recordId).executeQuery();
        T object = (resultSet.next()) ? getRecordObject(resultSet) : null;
        statementBuilder.close();
        return object;
    }

    public void update(T record) {
        StatementBuilder statementBuilder = new StatementBuilder(updateSql);
        setUpdateValues(record, statementBuilder);
        statementBuilder.executeUpdate().close();
    }

    public void delete(int recordId) {
        new StatementBuilder(deleteSql).setInt(1, recordId).executeUpdate().close();
    }

    public void delete(T record) {
        delete(getRecordId(record));
    }

    @SneakyThrows
    public List<T> getAll() {
        List<T> records = new ArrayList<>();
        StatementBuilder statementBuilder = new StatementBuilder(allSql);
        ResultSet resultSet = statementBuilder.build().executeQuery();
        while (resultSet.next()) {
            records.add(getRecordObject(resultSet));
        }
        statementBuilder.close();
        return records;
    }

}
