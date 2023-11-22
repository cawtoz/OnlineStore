package com.github.cawtoz.onlinestore.model;

import com.github.cawtoz.onlinestore.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@ToString
@Getter @Setter
@AllArgsConstructor
public class Order {
    private final int id, customer_id;
    private Date date;
    private OrderStatus orderStatus;
}
