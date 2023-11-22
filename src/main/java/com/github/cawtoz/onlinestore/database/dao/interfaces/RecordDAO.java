package com.github.cawtoz.onlinestore.database.dao.interfaces;

import com.github.cawtoz.onlinestore.database.StatementBuilder;

import java.sql.ResultSet;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public interface RecordDAO<T> {
    int getRecordId(T record);
    void setCreateValues(T record, StatementBuilder statement);
    void setUpdateValues(T record, StatementBuilder statement);
    T getRecordObject(ResultSet resultSet);
}