package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.dto.ProductFeedbackDto;

import java.util.List;

public interface ProductFeedbackService extends CrudService<ProductFeedbackDto> {
    List<ProductFeedbackDto> findRecurListByParentId(Long id);
}
