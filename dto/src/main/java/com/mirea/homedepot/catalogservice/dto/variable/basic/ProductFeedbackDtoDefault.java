package com.mirea.homedepot.catalogservice.dto.variable.basic;

import com.mirea.homedepot.commonmodule.dto.definition.ProductFeedbackDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = false)
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
