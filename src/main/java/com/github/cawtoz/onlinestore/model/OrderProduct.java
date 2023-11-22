package com.github.cawtoz.onlinestore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@ToString
@Getter @Setter
@AllArgsConstructor
public class OrderProduct {
    private final int id, orderId, productId;
    private int quantity;
}
