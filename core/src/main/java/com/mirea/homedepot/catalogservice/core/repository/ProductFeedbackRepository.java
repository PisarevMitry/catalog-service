package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductFeedbackEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductFeedbackRepository {

    List<ProductFeedbackEntity> findAll();

    ProductFeedbackEntity findById(@Param("productFeedbackId") Long productFeedbackId);

    List<ProductFeedbackEntity> findByListId(@Param("productFeedbackListId") List<Long> productFeedbackListId);

    void insert(@Param("productFeedbackEntity") ProductFeedbackEntity productFeedbackEntity);

    void insertAll(@RequestBody @Param("productFeedbackEntityList") List<ProductFeedbackEntity> productFeedbackEntityList);

    void updateById(@RequestBody @Param("productFeedbackEntity") ProductFeedbackEntity productFeedbackEntity);

    void deleteById(@RequestBody @Param("productFeedbackId") Long productFeedbackId);

    List<ProductFeedbackEntity> findRecurById(@Param("productFeedbackId") Long productFeedbackId);
}
