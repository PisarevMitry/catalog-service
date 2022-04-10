package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.core.service.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.core.service.RecursiveSearchForDefaultDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductFeedbackDto;

public interface ProductFeedbackService
        extends CrudServiceForDefaultDto<ProductFeedbackDto>, RecursiveSearchForDefaultDto<ProductFeedbackDto> {

}
