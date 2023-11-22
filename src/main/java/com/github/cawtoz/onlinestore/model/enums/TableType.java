package com.github.cawtoz.onlinestore.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TableType {
    CUSTOMERS("Customers"),
    ORDERS("Orders"),
    PRODUCT("Products"),
    ORDER_PRODUCTS("Order Products");
    private final String name;
}
