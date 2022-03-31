package com.mirea.homedepot.catalogservice.core.model.entity;

import lombok.Data;

@Data
public class ProductCategoryEntity {

    private Long id;
    private String title;
    private Long parentId;
}
