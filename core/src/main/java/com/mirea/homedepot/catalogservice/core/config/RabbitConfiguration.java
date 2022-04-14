package com.mirea.homedepot.catalogservice.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@Configuration
public class RabbitConfiguration {

    Logger logger = LoggerFactory.getLogger(RabbitConfiguration.class);

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

   *//* @Bean
    public Queue catalogQueue() {
        return new Queue("catalogQueue");
    }

    @Bean
    public DirectExchange catalogQueueDirectExchange() {
        return new DirectExchange("exchangeCatalogQueue");
    }

    @Bean
    public Binding getAllProductCategoryBinding() {
        return BindingBuilder.bind(catalogQueue()).to(catalogQueueDirectExchange()).with("getAllProductCategory");
    }

    @Bean
    public Binding getProductCategoryByIdBinding() {
        return BindingBuilder.bind(catalogQueue()).to(catalogQueueDirectExchange()).with("getProductCategoryById");
    }*//*
*//*   Logger logger = LoggerFactory.getLogger(RabbitConfiguration.class);

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue catalogQueue() {
        return new Queue("catalogQueue");
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames("catalogQueue");
        // container.setMessageListener(message -> logger.info("Recieved from catalogQueue1 : " + new String(message.getBody())));
        return container;
    }

    @Bean

    public DirectExchange catalogQueueDirectExchange() {
        return new DirectExchange("exchangeCatalogQueue");
    }

    @Bean
    public Binding getAllProductCategoryBinding() {
        return BindingBuilder.bind(catalogQueue()).to(catalogQueueDirectExchange()).with("key.1");
    }

    @Bean
    public Binding getProductCategoryByIdBinding() {
        return BindingBuilder.bind(catalogQueue()).to(catalogQueueDirectExchange()).with("key.2");
    }

    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }*//*
}*/
