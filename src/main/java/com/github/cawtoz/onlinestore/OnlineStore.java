package com.github.cawtoz.onlinestore;

import com.formdev.flatlaf.FlatLightLaf;
import com.github.cawtoz.onlinestore.database.Database;
import com.github.cawtoz.onlinestore.ui.login.LoginWindow;
import lombok.Getter;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class OnlineStore {

    @Getter
    private static final Database database = new Database("jdbc:mysql://umuiypwqh162mq0g:SYgHh5zJGFa7AsVhT1nv@btighr8jwpnemerwfwpr-mysql.services.clever-cloud.com:3306/btighr8jwpnemerwfwpr");

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new LoginWindow().setVisible(true);
    }

}
