package com.mirea.homedepot.catalogservice.core.model.entity;

import lombok.Data;

@Data
public class ProductPhotoEntity extends Entity{

    private Long id;
    private String url;
    private Long parentId;
}
