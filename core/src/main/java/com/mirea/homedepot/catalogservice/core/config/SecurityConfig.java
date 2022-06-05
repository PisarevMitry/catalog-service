package com.mirea.homedepot.catalogservice.core.config;

import com.mirea.homedepot.catalogservice.core.service.UserSecurityService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserSecurityService userSecurityService;

    private final LoginSuccessHandler loginSuccessHandler;

    public SecurityConfig(
        @Qualifier("userServiceImpl")
        UserSecurityService userSecurityService,
        LoginSuccessHandler loginSuccessHandler) {
        this.userSecurityService = userSecurityService;
        this.loginSuccessHandler = loginSuccessHandler;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/**").permitAll();
        http.formLogin().permitAll().successHandler(loginSuccessHandler)
            .usernameParameter("email").passwordParameter("password")
            .permitAll();
    }

    /**
     * Bean с системой шифрования паролей.
     *
     * @return метод шифрования паролей
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}