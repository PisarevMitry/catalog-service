package com.mirea.homedepot.catalogservice.dto;

import lombok.Data;

@Data
public class ProductCategoryDtoDefault extends ProductCategoryDto {
    private Long id;
    private String title;
    private Long parentId;
}
