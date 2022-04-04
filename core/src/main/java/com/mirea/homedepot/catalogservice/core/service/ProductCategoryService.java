package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.dto.ProductCategoryDto;
import src.main.java.com.mirea.homedepot.catalogservice.utils.tree.Tree;

import java.util.List;

public interface ProductCategoryService extends CrudService<ProductCategoryDto> {

    //List<ProductCategoryDto> findListByParentId(Long id);

    /*Tree<ProductCategoryDto> findTreeByParentId(Long id);*/
}
