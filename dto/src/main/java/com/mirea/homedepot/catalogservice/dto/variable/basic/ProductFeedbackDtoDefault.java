package com.mirea.homedepot.catalogservice.dto.variable.basic;

import com.mirea.homedepot.catalogservice.dto.abstractive.ProductFeedbackDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFeedbackDtoDefault extends ProductFeedbackDto {
    private Long id;
    private Integer grade;
    private String description;
    private LocalDate createDttm;
    private Long clientId;
    private Long parentId;
}
