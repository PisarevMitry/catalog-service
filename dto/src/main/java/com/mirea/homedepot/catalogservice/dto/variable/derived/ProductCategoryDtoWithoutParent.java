package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductCategoryDto;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductCategoryDtoDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDtoWithoutParent extends ProductCategoryDto {
    private Long id;
    private String title;

    public ProductCategoryDtoWithoutParent(ProductCategoryDtoDefault productCategoryDtoDefault) {
        this.id = productCategoryDtoDefault.getId();
        this.title = productCategoryDtoDefault.getTitle();
    }
}
