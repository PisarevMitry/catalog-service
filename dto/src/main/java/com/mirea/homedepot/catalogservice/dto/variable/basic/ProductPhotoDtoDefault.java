package com.mirea.homedepot.catalogservice.dto.variable.basic;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductPhotoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhotoDtoDefault extends ProductPhotoDto {
    private Long id;
    private String url;
    private Long parentId;
}
