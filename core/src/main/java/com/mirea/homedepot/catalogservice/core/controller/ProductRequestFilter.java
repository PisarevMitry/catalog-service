package com.mirea.homedepot.catalogservice.core.controller;

import lombok.Data;

import java.util.List;

@Data
public class ProductRequestFilter {
    Long categoryId;

    List<Long> listCategoryId;

    Long id;

    List<Long> listId;

}
