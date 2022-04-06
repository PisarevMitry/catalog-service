package com.mirea.homedepot.catalogservice.dto;

import lombok.Data;

@Data
public class ProductCategoryDtoWithoutParent extends ProductCategoryDto {
    private Long id;
    private String title;

    public ProductCategoryDtoWithoutParent(ProductCategoryDtoDefault productCategoryDtoDefault) {
        this.id = productCategoryDtoDefault.getId();
        this.title = productCategoryDtoDefault.getTitle();
    }
}
