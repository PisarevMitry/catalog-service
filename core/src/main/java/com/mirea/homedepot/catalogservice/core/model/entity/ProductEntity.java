package com.mirea.homedepot.catalogservice.core.model.entity;

import com.mirea.homedepot.commonmodule.model.Entity;
import lombok.Data;
import org.json.JSONObject;

@Data
public class ProductEntity implements Entity {

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
