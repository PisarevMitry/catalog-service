package com.mirea.homedepot.catalogservice.core.model.entity;

import com.mirea.homedepot.commonmodule.model.Entity;
import lombok.Data;

/**
 * Сущность "Акции".
 */
@Data
public class ProductSpecialConditionEntity implements Entity {

    private Long id;

    private String description;
}
