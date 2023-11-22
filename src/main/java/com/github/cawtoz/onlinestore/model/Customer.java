package com.github.cawtoz.onlinestore.model;

import com.github.cawtoz.onlinestore.model.enums.UserType;
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
public class Customer {
    private final int id;
    private String name, address, phone, email, username, password;
    private UserType userType;
}
