package com.mirea.homedepot.catalogservice.core.config;

import com.mirea.homedepot.catalogservice.core.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserSecurityService userSecurityService;

    private final LoginSuccessHandler loginSuccessHandler;

    public SecurityConfig(@Qualifier("userServiceImpl") UserSecurityService userSecurityService, LoginSuccessHandler loginSuccessHandler) {
        this.userSecurityService = userSecurityService;
        this.loginSuccessHandler = loginSuccessHandler;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable().authorizeRequests()
            //Доступ только для не зарегистрированных пользователей
            .antMatchers("/registration").not().fullyAuthenticated()
            //Доступ только для пользователей с ролью Администратор
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/news").hasRole("USER")
            //Доступ разрешен всем пользователей
            .antMatchers("/").permitAll()
            //Все остальные страницы требуют аутентификации
            .anyRequest().authenticated();
        http.formLogin().permitAll().successHandler(loginSuccessHandler)
            .usernameParameter("email").passwordParameter("password")
            .permitAll();
    }

}