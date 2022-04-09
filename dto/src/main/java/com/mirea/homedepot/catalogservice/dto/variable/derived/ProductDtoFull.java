package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductFeedbackDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductPhotoDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductSpecialConditionDto;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductDtoDefault;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoFull extends ProductDto {
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private Integer amount;
    private List<ProductPhotoDto> photoList;
    private JSONObject options;
    private Long categoryId;
    private List<ProductFeedbackDto> feedbackList;
    private ProductSpecialConditionDto specialCondition;

    public ProductDtoFull(ProductDtoDefault productDto, List<ProductPhotoDto> photoList, List<ProductFeedbackDto> feedbackList, ProductSpecialConditionDto specialCondition) {
        this.id = productDto.getId();
        this.title = productDto.getTitle();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.amount = productDto.getAmount();
        this.photoList = photoList;
        this.options = productDto.getOption();
        this.categoryId = productDto.getCategoryId();
        this.feedbackList = feedbackList;
        this.specialCondition = specialCondition;
    }
}
