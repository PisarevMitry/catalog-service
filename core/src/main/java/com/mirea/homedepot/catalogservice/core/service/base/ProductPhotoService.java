package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.core.service.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.RecursiveSearchForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.RecursiveSearchForNotDefaultDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductPhotoDto;
import com.mirea.homedepot.catalogservice.dto.type.ProductPhotoDtoType;

public interface ProductPhotoService extends CrudServiceForDefaultDto<ProductPhotoDto>,
        CrudServiceForNotDefaultDto<ProductPhotoDto, ProductPhotoDtoType>,
        RecursiveSearchForDefaultDto<ProductPhotoDto>,
        RecursiveSearchForNotDefaultDto<ProductPhotoDto, ProductPhotoDtoType> {

}
