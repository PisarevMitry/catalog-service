package com.mirea.homedepot.catalogservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDtoToCard extends ProductDto {
    private Long id;
    private String title;
    private Integer price;
    private Integer amount;
    private ProductPhotoDto photo;
    private List<ProductSpecialConditionDto> specialConditionList;
}
