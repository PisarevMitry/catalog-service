package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.core.service.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.RecursiveSearchForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.RecursiveSearchForNotDefaultDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductCategoryDto;
import com.mirea.homedepot.catalogservice.dto.type.ProductCategoryDtoType;

import java.util.List;

public interface ProductCategoryService extends CrudServiceForDefaultDto<ProductCategoryDto>,
        CrudServiceForNotDefaultDto<ProductCategoryDto, ProductCategoryDtoType>,
        RecursiveSearchForDefaultDto<ProductCategoryDto>,
        RecursiveSearchForNotDefaultDto<ProductCategoryDto, ProductCategoryDtoType> {

    List<ProductCategoryDto> findListByParentId(Long id);

    List<ProductCategoryDto> findListByParentId(ProductCategoryDtoType type, Long id);

    /*Tree<ProductCategoryDto> findTreeByParentId(Long id);*/
}
