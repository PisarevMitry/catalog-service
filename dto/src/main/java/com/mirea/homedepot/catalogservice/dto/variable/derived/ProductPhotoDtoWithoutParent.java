package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.commonmodule.dto.definition.ProductPhotoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Представление сущности "Изображение товара" без информации о дочерних сущностях.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhotoDtoWithoutParent extends ProductPhotoDto {

    private Long id;

    private String url;
}
