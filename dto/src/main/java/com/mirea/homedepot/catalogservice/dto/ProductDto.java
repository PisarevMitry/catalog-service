package com.mirea.homedepot.catalogservice.dto;

import lombok.Data;
import org.json.JSONObject;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private Integer price;
    private Integer amount;
    private Long photoId;
    private Long videoId;
    private JSONObject option;
    private Long categoryId;
    private Long feedbackId;
    private Long specialConditionId;
}
