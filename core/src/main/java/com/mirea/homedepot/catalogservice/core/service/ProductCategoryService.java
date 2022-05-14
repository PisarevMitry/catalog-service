package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.type.ProductCategoryDtoType;
import com.mirea.homedepot.commonmodule.services.CrudServiceForDefaultDto;
import com.mirea.homedepot.commonmodule.services.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.commonmodule.services.ParentSearchForDefaultDto;
import com.mirea.homedepot.commonmodule.services.ParentSearchForNotDefaultDto;

import java.util.List;

public interface ProductCategoryService extends CrudServiceForDefaultDto,
                                                CrudServiceForNotDefaultDto<ProductCategoryDtoType>,
                                                ParentSearchForDefaultDto,
                                                ParentSearchForNotDefaultDto<ProductCategoryDtoType> {

    List<Dto> findTreeByParentId(Long id);

    List<Dto> findTreeByParentId(ProductCategoryDtoType type, Long id);

}
