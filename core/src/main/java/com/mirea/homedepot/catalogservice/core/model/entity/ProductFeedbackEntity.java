package com.mirea.homedepot.catalogservice.core.model.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductFeedbackEntity extends Entity{

    private Long id;
    private Integer grade;
    private String description;
    private LocalDate createDttm;
    private Long clientId;
    private Long parentId;
}
