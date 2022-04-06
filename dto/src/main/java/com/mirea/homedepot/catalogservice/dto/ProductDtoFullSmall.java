package com.mirea.homedepot.catalogservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDtoFullSmall {
    private Long id;
    private String title;
    private Integer price;
    private Integer amount;
    private ProductPhotoDto photo;
    private List<ProductSpecialConditionDto> specialConditionList;

    public ProductDtoFullSmall(ProductDto productDto, ProductPhotoDto photo, List<ProductSpecialConditionDto> specialConditionList) {
        this.id = productDto.getId();
        this.title = productDto.getTitle();
        this.price = productDto.getPrice();
        this.amount = productDto.getAmount();
        this.photo = photo;
        this.specialConditionList = specialConditionList;
    }
}
