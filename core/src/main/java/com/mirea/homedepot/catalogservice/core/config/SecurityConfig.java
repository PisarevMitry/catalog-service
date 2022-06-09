package com.mirea.homedepot.catalogservice.core.config;

import com.mirea.homedepot.catalogservice.core.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/user/**").hasAuthority("ctl.admin")
            .antMatchers("/products/**").hasAuthority("ctl.admin")
            .antMatchers("/categories/**").hasAuthority("ctl.admin")
            .antMatchers(HttpMethod.POST, "/products/**", "/categories/**").hasAuthority("ctl.saveProducts")
            .antMatchers(HttpMethod.GET, "/products/**", "/categories/**").permitAll();
        http
            .csrf().disable().authorizeRequests()
            .antMatchers("/registration").not().fullyAuthenticated();
        http.formLogin().permitAll().successHandler(loginSuccessHandler)
            .usernameParameter("email").passwordParameter("password")
            .permitAll();
    }

}