package com.mirea.homedepot.catalogservice.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductFeedbackDto {
    private Long id;
    private Integer grade;
    private String description;
    private LocalDate createDttm;
    private Long clientId;
}
