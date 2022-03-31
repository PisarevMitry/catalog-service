package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductCategoryRepository {

    List<ProductCategoryEntity> findAll();

    ProductCategoryEntity findById(@Param("productCategoryId") Long productCategoryId);

    List<ProductCategoryEntity> findByListId(@Param("productCategoryListId") List<Long> productCategoryListId);

    void insert(@RequestBody @Param("productCategoryEntity") ProductCategoryEntity productCategoryEntity);

    void insertAll(@RequestBody @Param("productCategoryEntityList") List<ProductCategoryEntity> productCategoryEntityList);

    void updateById(@RequestBody @Param("productCategoryEntity") ProductCategoryEntity productCategoryEntity);

    void deleteById(@Param("productCategoryId") Long productCategoryId);
}
