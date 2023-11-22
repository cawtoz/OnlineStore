package com.github.cawtoz.onlinestore.ui.dashboard.table.impl;

import com.github.cawtoz.onlinestore.database.dao.impl.ProductDAO;
import com.github.cawtoz.onlinestore.ui.dashboard.table.Table;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class ProductsTable extends Table {

    public ProductsTable() {
        super("products");
    }

    @Override
    public String[] getColums() {
        return new String[]{"Id", "Name", "Price", "Stock", "Description"};
    }

    @Override
    public Object[][] getRows() {
        return new ProductDAO().getAll().stream()
                .map(product -> new Object[] {
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getStock(),
                        product.getDescription(),
                }).toArray(Object[][]::new);
    }

    @Override
    protected int getPreferredColumnWidth(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> 40;
            case 1 -> 200;
            case 4 -> 600;
            default -> 80;
        };
    }

}
