package com.mirea.homedepot.catalogservice.dto;

import lombok.Data;
import org.json.JSONObject;

import java.util.List;

@Data
public class ProductDtoToFullCard extends ProductDto {
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private Integer amount;
    private List<ProductPhotoDto> photoList;
    private List<ProductVideoDto> videoList;
    private JSONObject options;
    private Long categoryId;
    private List<ProductFeedbackDto> feedbackList;
    private List<SpecialConditionDto> specialConditionList;
}
