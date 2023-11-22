package com.github.cawtoz.onlinestore.ui.dashboard.table.impl;

import com.github.cawtoz.onlinestore.database.dao.impl.CustomerDAO;
import com.github.cawtoz.onlinestore.ui.dashboard.table.Table;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class CustomersTable extends Table {

    public CustomersTable() {
        super("customers");
    }

    @Override
    public String[] getColums() {
        return new String[]{"Id", "Name", "Address", "Phone", "Email", "Username", "Password", "UserType"};
    }

    @Override
    public Object[][] getRows() {
        return new CustomerDAO().getAll().stream()
                .map(customer -> new Object[] {
                        customer.getId(),
                        customer.getName(),
                        customer.getAddress(),
                        customer.getPhone(),
                        customer.getEmail(),
                        customer.getUsername(),
                        customer.getPassword(),
                        customer.getUserType().toString()
                }).toArray(Object[][]::new);
    }

    @Override
    protected int getPreferredColumnWidth(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> 40;
            case 1, 2, 4 -> 200;
            case 3 -> 150;
            default -> 100;
        };
    }

}
