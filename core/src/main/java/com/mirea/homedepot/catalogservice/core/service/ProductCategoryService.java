package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.core.service.base.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.base.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.base.ParentSearchForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.base.ParentSearchForNotDefaultDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import com.mirea.homedepot.catalogservice.dto.type.ProductCategoryDtoType;

import java.util.List;

public interface ProductCategoryService extends CrudServiceForDefaultDto,
                                                CrudServiceForNotDefaultDto<ProductCategoryDtoType>,
                                                ParentSearchForDefaultDto,
                                                ParentSearchForNotDefaultDto<ProductCategoryDtoType> {

    List<Dto> findTreeByParentId(Long id);

    List<Dto> findTreeByParentId(ProductCategoryDtoType type, Long id);

}
