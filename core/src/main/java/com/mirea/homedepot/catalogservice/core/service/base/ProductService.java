package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.core.service.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductDto;
import com.mirea.homedepot.catalogservice.dto.type.ProductDtoType;

public interface ProductService extends CrudServiceForDefaultDto<ProductDto>, CrudServiceForNotDefaultDto<ProductDto, ProductDtoType> {

}
