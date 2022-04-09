package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.core.service.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductDto;
import com.mirea.homedepot.catalogservice.dto.type.ProductDtoType;
import org.json.JSONObject;

import java.util.List;

public interface ProductService extends CrudServiceForDefaultDto<ProductDto>, CrudServiceForNotDefaultDto<ProductDto, ProductDtoType> {

    List<ProductDto> findByCategoryId(Long id);

    List<ProductDto> findByCategoryId(ProductDtoType type, Long id);

    List<ProductDto> findByOption(JSONObject option);

    List<ProductDto> findByOption(ProductDtoType type, JSONObject option);
}
