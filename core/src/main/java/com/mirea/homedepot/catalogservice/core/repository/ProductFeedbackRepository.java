package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductFeedbackEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductFeedbackRepository
        extends BasicMethodRepository<ProductFeedbackEntity>, ParentSearchRepository<ProductFeedbackEntity> {

}
