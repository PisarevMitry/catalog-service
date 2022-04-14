package com.mirea.homedepot.catalogservice.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Service application.
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan("com.mirea.homedepot.catalogservice")
public class CatalogServiceApplication {

    /**
     * The entry point of application.
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class);
    }
}
