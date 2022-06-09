package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFull;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFullSmall;
import com.mirea.homedepot.commonmodule.dto.definition.ProductCategoryDto;
import com.mirea.homedepot.commonmodule.dto.definition.ProductFeedbackDto;
import com.mirea.homedepot.commonmodule.dto.definition.ProductPhotoDto;
import com.mirea.homedepot.commonmodule.dto.definition.ProductSpecialConditionDto;
import lombok.Data;
import org.json.JSONObject;

import java.util.List;

/**
 * Фильтр запросов поиска товаров.
 */
@Data
public class ProductRequestFilter {

    ProductDtoDefault productDtoDefault;

    ProductDtoFullSmall productDtoFullSmall;

    ProductDtoFull productDtoFull;

    private Long id;

    private List<Long> listId;

    private String title;

    private String description;

    private Integer price;

    private Integer amount;

    private Long photoId;

    private List<Long> listPhotoId;

    private ProductPhotoDto productPhotoDto;

    private List<ProductPhotoDto> listPhotoDto;

    private JSONObject option;

    private Long categoryId;

    private List<Long> listCategoryId;

    private ProductCategoryDto productCategoryDto;

    private List<ProductCategoryDto> listProductCategoryDto;

    private Long feedbackId;

    private ProductFeedbackDto productFeedbackDto;

    private List<ProductFeedbackDto> listProductFeedbackDto;

    private Long specialConditionId;

    private ProductSpecialConditionDto productSpecialConditionDto;

}
