package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductDtoDefault;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.definition.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Обогащенное представление сущности "Товар" без отзывов.
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoFullSmall extends ProductDto {
    private Long id;

    private String title;

    private Integer price;

    private Integer amount;

    private Dto photo;

    private Dto specialCondition;

    public ProductDtoFullSmall(ProductDtoDefault productDto, Dto photo, Dto specialCondition) {
        this.id = productDto.getId();
        this.title = productDto.getTitle();
        this.price = productDto.getPrice();
        this.amount = productDto.getAmount();
        this.photo = photo;
        this.specialCondition = specialCondition;
    }
}
