package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.core.service.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.CrudServiceForNotDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.RecursiveSearchForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.RecursiveSearchForNotDefaultDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductFeedbackDto;
import com.mirea.homedepot.catalogservice.dto.type.ProductFeedbackDtoType;

public interface ProductFeedbackService extends CrudServiceForDefaultDto<ProductFeedbackDto>, RecursiveSearchForDefaultDto<ProductFeedbackDto> {


}
