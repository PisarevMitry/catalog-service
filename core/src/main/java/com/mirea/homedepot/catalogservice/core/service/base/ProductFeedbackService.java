package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.core.service.CrudServiceForDefaultDto;
import com.mirea.homedepot.catalogservice.dto.ProductFeedbackDto;

import java.util.List;

public interface ProductFeedbackService extends CrudServiceForDefaultDto<ProductFeedbackDto> {
    List<ProductFeedbackDto> findRecurListByParentId(Long id);
}
