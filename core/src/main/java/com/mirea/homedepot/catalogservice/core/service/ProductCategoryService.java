package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.dto.ProductCategoryDto;
import com.mirea.homedepot.catalogservice.dto.ProductCategoryTreeDto;

import java.util.List;

public interface ProductCategoryService extends CrudService<ProductCategoryDto> {

    List<ProductCategoryDto> findListByParentId(Long id);

    ProductCategoryTreeDto findTreeByParentId(Long id);
}
