package com.mirea.homedepot.catalogservice.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер автоизации.
 */
@Controller
public class LoginController {

    /**
     * Метод авторизации.
     *
     * @return страница авторизации
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
