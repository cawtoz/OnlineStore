package com.github.cawtoz.onlinestore.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@Getter @Setter
@AllArgsConstructor
public class Database {

    private final String url;

    @SneakyThrows
    public Connection getConnection() {
        return DriverManager.getConnection(url);
    }

}
