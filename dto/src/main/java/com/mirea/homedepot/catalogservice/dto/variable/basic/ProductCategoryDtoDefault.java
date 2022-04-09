package com.mirea.homedepot.catalogservice.dto.variable.basic;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDtoDefault extends ProductCategoryDto {
    private Long id;
    private String title;
    private Long parentId;
}
