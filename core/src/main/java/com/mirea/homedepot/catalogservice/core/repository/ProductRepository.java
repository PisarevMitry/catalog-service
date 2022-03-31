package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;

import java.util.List;

@Mapper
public interface ProductRepository {

    List<ProductEntity> findAll();

    ProductEntity findById(@Param("productId") Long id);

    List<ProductEntity> findByListId(@Param("productListId") List<Long> listId);

    List<ProductEntity> findByListOption(@Param("productOption") JSONObject Option);

}
