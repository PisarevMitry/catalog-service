package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.core.service.base.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.base.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.base.ParentSearchForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.base.ParentSearchForNotDefaultDto;
import com.mirea.homedepot.catalogservice.dto.type.ProductPhotoDtoType;

public interface ProductPhotoService extends CrudServiceForDefaultDto,
                                             CrudServiceForNotDefaultDto<ProductPhotoDtoType>,
                                             ParentSearchForDefaultDto,
                                             ParentSearchForNotDefaultDto<ProductPhotoDtoType> {

}
