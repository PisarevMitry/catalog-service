package com.mirea.homedepot.catalogservice.dto.variable.basic;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductSpecialConditionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSpecialConditionDtoDefault extends ProductSpecialConditionDto {
    private Long id;
    private String description;
    //private JSONObject details;
}
