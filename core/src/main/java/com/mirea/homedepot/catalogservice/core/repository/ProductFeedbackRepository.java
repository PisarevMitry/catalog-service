package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductFeedbackEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductFeedbackRepository extends BasicMethodRepository<ProductFeedbackEntity> {

    List<ProductFeedbackEntity> findRecurById(@Param("id") Long id);
}
