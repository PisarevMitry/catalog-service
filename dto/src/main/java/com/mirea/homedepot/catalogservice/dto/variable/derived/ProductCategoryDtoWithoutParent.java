package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.commonmodule.dto.definition.ProductCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Представление сущности "Категория товара" без информации о дочерних категориях.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDtoWithoutParent extends ProductCategoryDto {
    private Long id;

    private String title;
}
