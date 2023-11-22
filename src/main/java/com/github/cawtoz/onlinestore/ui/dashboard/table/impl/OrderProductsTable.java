package com.github.cawtoz.onlinestore.ui.dashboard.table.impl;

import com.github.cawtoz.onlinestore.database.dao.impl.OrderProductDAO;
import com.github.cawtoz.onlinestore.ui.dashboard.table.Table;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class OrderProductsTable extends Table {

    public OrderProductsTable() {
        super("order_products");
    }

    @Override
    public String[] getColums() {
        return new String[]{"Id", "Order Id", "Product Id", "Quantity"};
    }

    @Override
    public Object[][] getRows() {
        return new OrderProductDAO().getAll().stream()
                .map(product -> new Object[] {
                        product.getId(),
                        product.getId(),
                        product.getId(),
                        product.getQuantity(),
                }).toArray(Object[][]::new);
    }

    @Override
    protected int getPreferredColumnWidth(int columnIndex) {
        return 0;
    }

}
