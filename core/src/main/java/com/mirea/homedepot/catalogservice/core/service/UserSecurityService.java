package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.commonmodule.dto.Dto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Сервис работы с безопасностью пользователя.
 */
public interface UserSecurityService extends UserDetailsService {

    /**
     * Метод поиска пользователя.
     *
     * @param login логин пользователя
     * @return представление пользователя
     */
    Dto findByLogin(String login);
}
