package com.mirea.homedepot.catalogservice.core.model.entity;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import lombok.Data;

@Data
public class ProductCategoryEntity implements Entity {

    private Long id;

    private String title;

    private Long parentId;
}
