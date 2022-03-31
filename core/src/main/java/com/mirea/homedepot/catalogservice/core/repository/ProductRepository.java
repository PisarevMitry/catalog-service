package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductRepository {

    List<ProductEntity> findAll();

    ProductEntity findById(@Param("productId") Long productId);

    List<ProductEntity> findByListId(@Param("productListId") List<Long> productListId);

    void insert(@RequestBody @Param("productEntity") ProductEntity productEntity);

    void insertAll(@RequestBody @Param("productEntityList") List<ProductEntity> productEntityList);

    void updateById(@RequestBody @Param("productEntity") ProductEntity productEntity);

    void deleteById(@Param("productId") Long productId);

    List<ProductEntity> findByListOption(@RequestBody @Param("productEntityOption") JSONObject productEntityOption);

}
