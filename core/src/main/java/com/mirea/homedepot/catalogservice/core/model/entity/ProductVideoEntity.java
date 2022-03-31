package com.mirea.homedepot.catalogservice.core.model.entity;

import lombok.Data;

@Data
public class ProductVideoEntity {

    private Long id;
    private String url;
    private Long parentId;
}

