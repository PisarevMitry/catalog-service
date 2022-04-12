package com.mirea.homedepot.catalogservice.core.model.entity;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductFeedbackEntity implements Entity {

    private Long id;
    private Integer grade;
    private String description;
    private LocalDate createDttm;
    private Long clientId;
    private Long parentId;
}
