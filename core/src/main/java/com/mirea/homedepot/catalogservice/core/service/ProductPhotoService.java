package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.commonmodule.dto.type.ProductPhotoDtoType;
import com.mirea.homedepot.commonmodule.services.CrudServiceForDefaultDto;
import com.mirea.homedepot.commonmodule.services.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.commonmodule.services.ParentSearchForDefaultDto;
import com.mirea.homedepot.commonmodule.services.ParentSearchForNotDefaultDto;

/**
 * Сервис работы с изображениями товаров.
 */
public interface ProductPhotoService extends CrudServiceForDefaultDto, CrudServiceForNotDefaultDto<ProductPhotoDtoType>, ParentSearchForDefaultDto,
    ParentSearchForNotDefaultDto<ProductPhotoDtoType> {

}
