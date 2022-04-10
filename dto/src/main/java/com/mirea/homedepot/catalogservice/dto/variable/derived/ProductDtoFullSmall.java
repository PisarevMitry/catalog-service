package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductPhotoDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductSpecialConditionDto;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductDtoDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoFullSmall extends ProductDto {
    private Long id;
    private String title;
    private Integer price;
    private Integer amount;
    private ProductPhotoDto photo;
    private ProductSpecialConditionDto specialCondition;

    public ProductDtoFullSmall(ProductDtoDefault productDto, ProductPhotoDto photo,
                               ProductSpecialConditionDto specialCondition) {
        this.id = productDto.getId();
        this.title = productDto.getTitle();
        this.price = productDto.getPrice();
        this.amount = productDto.getAmount();
        this.photo = photo;
        this.specialCondition = specialCondition;
    }
}
