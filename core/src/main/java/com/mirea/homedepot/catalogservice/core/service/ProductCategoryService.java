package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.dto.ProductCategoryDto;

import java.util.List;

public interface ProductCategoryService extends CrudService<ProductCategoryDto> {

    List<ProductCategoryDto> findListByParentId(Long id);

    List<ProductCategoryDto> findRecurListByParentId(Long id);

    /*Tree<ProductCategoryDto> findTreeByParentId(Long id);*/
}
