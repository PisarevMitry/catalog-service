package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.core.service.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.dto.ProductPhotoDto;

import java.util.List;

public interface ProductPhotoService extends CrudServiceForDefaultDto<ProductPhotoDto> {
    List<ProductPhotoDto> findRecurListByParentId(Long id);
}
