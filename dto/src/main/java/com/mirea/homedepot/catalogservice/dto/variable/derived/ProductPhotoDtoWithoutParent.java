package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductPhotoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhotoDtoWithoutParent extends ProductPhotoDto {
    private Long id;

    private String url;
}
