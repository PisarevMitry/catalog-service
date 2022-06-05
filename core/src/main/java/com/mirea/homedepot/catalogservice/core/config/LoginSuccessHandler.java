package com.mirea.homedepot.catalogservice.core.config;

import com.mirea.homedepot.catalogservice.core.model.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

/**
 * Класс отвечающий за перенаправление пользователя на страницу в зависимости от роли.
 */
@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
        throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(
            authentication.getAuthorities());
        Long id = ((UserEntity) authentication.getPrincipal()).getId();
        response.sendRedirect("/person/" + id);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}