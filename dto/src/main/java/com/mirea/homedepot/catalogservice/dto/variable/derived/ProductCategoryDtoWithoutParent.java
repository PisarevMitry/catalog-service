package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDtoWithoutParent extends ProductCategoryDto {
    private Long id;
    private String title;
}
