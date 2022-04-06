package com.mirea.homedepot.catalogservice.dto;

import lombok.Data;
import org.json.JSONObject;

import java.util.List;

@Data
public class ProductDtoFull {
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private Integer amount;
    private List<ProductPhotoDto> photoList;
    private JSONObject options;
    private Long categoryId;
    private List<ProductFeedbackDto> feedbackList;
    private List<ProductSpecialConditionDto> specialConditionList;

    public ProductDtoFull(ProductDto productDto, List<ProductPhotoDto> photoList, List<ProductFeedbackDto> feedbackList, List<ProductSpecialConditionDto> specialConditionList) {
        this.id = productDto.getId();
        this.title = productDto.getTitle();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.amount = productDto.getAmount();
        this.photoList = photoList;
        this.options = productDto.getOption();
        this.categoryId = productDto.getCategoryId();
        this.feedbackList = feedbackList;
        this.specialConditionList = specialConditionList;
    }
}
