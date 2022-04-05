package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.dto.ProductPhotoDto;

import java.util.List;

public interface ProductPhotoService extends CrudService<ProductPhotoDto> {
    List<ProductPhotoDto> findRecurListByParentId(Long id);
}
