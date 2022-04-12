package com.mirea.homedepot.catalogservice.core.model.entity;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import lombok.Data;

@Data
public class ProductPhotoEntity implements Entity {

    private Long id;
    private String url;
    private Long parentId;
}
