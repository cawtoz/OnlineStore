package com.github.cawtoz.onlinestore.database.dao.interfaces;

import java.util.List;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public interface CRUD<T> {
    void create(T record);
    T read(int recordId);
    void update(T record);
    void delete(int recordId);
    List<T> getAll();
}
