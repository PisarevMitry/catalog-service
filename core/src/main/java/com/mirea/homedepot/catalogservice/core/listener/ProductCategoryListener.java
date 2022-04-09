package com.mirea.homedepot.catalogservice.core.listener;

import com.mirea.homedepot.catalogservice.core.controller.ProductCategoryController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class ProductCategoryListener {

  /*  Logger logger = LoggerFactory.getLogger(ProductCategoryListener.class);

    private final ProductCategoryController productCategoryController;

    public ProductCategoryListener(ProductCategoryController productCategoryController) {
        this.productCategoryController = productCategoryController;
    }

    @RabbitListener(id = "getAllProductCategory", bindings = @QueueBinding(exchange = @Exchange(value = "exchangeCatalogQueue", durable = "true", type = "topic"), value = @Queue(value = "catalogQueueGetAllProductCategory", durable = "true"), key = "getAllProductCategory"))
        //@RabbitListener(queues = "catalogQueue")
    String getAllProductCategory(String message) {
        logger.info("Метод 1 вызван в catalogservice");
        return String.valueOf(productCategoryController.getAllProductCategory());
    }

    @RabbitListener(id = "getProductCategoryById", bindings = @QueueBinding(exchange = @Exchange(value = "exchangeCatalogQueue", durable = "true", type = "topic"), value = @Queue(value = "catalogQueueGetProductCategoryById", durable = "true"), key = "getProductCategoryById"))
    public String getProductCategoryById(String message) {
        logger.info("Метод 2 вызван в catalogservice");
        return String.valueOf(productCategoryController.getProductCategoryById(12L));
    }*/
}
