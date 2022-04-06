package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.core.service.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.catalogservice.dto.ProductDto;
import com.mirea.homedepot.catalogservice.dtotype.ProductDtoType;

public interface ProductService extends CrudServiceForDefaultDto<ProductDto>, CrudServiceForNotDefaultDto<ProductDto, ProductDtoType> {

}
