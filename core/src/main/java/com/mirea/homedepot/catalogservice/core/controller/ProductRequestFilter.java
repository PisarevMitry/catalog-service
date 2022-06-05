package com.mirea.homedepot.catalogservice.core.controller;

import lombok.Data;

import java.util.List;

/**
 * Фильтр запросов поиска товаров.
 */
@Data
public class ProductRequestFilter {
    Long categoryId;

    List<Long> listCategoryId;

    Long id;

    List<Long> listId;

}
