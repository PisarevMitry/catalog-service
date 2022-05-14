package com.mirea.homedepot.catalogservice.dto.variable.basic;

import com.mirea.homedepot.commonmodule.dto.definition.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoDefault extends ProductDto {
    private Long id;

    private String title;

    private String description;

    private Integer price;

    private Integer amount;

    private Long photoId;

    private JSONObject option;

    private Long categoryId;

    private Long feedbackId;

    private Long specialConditionId;
}
