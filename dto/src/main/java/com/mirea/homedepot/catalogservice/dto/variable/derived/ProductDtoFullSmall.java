package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductPhotoDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductSpecialConditionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoFullSmall  extends ProductDto{
    private Long id;
    private String title;
    private Integer price;
    private Integer amount;
    private ProductPhotoDto photo;
    private List<ProductSpecialConditionDto> specialConditionList;


}
