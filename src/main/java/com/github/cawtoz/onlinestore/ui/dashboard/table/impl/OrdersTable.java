package com.github.cawtoz.onlinestore.ui.dashboard.table.impl;

import com.github.cawtoz.onlinestore.database.dao.impl.OrderDAO;
import com.github.cawtoz.onlinestore.ui.dashboard.table.Table;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class OrdersTable extends Table {

    public OrdersTable() {
        super("orders");
    }

    @Override
    public String[] getColums() {
        return new String[]{"Id", "Customer Id", "Date", "Status"};
    }

    @Override
    public Object[][] getRows() {
        return new OrderDAO().getAll().stream()
                .map(product -> new Object[] {
                        product.getId(),
                        product.getId(),
                        product.getDate(),
                        product.getOrderStatus().toString(),
                }).toArray(Object[][]::new);
    }

    @Override
    protected int getPreferredColumnWidth(int columnIndex) {
        return 0;
    }

}
