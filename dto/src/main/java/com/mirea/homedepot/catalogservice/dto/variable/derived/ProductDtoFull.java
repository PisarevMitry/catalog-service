package com.mirea.homedepot.catalogservice.dto.variable.derived;

import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductDtoDefault;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.definition.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.util.List;

/**
 * Полное представление сущности "Товар".
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoFull extends ProductDto {
    private Long id;

    private String title;

    private String description;

    private Integer price;

    private Integer amount;

    private List<Dto> photoList;

    private JSONObject options;

    private Dto category;

    private List<Dto> feedbackList;

    private Dto specialCondition;

    public ProductDtoFull(ProductDtoDefault productDto, List<Dto> photoList,
                          Dto productCategory, List<Dto> feedbackList,
                          Dto specialCondition) {
        this.id = productDto.getId();
        this.title = productDto.getTitle();
        this.description = productDto.getDescription();
        this.price = productDto.getPrice();
        this.amount = productDto.getAmount();
        this.photoList = photoList;
        this.options = productDto.getOption();
        this.category = productCategory;
        this.feedbackList = feedbackList;
        this.specialCondition = specialCondition;
    }
}
