package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductPhotoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductPhotoRepository {

    List<ProductPhotoEntity> findAll();

    ProductPhotoEntity findById(@Param("productPhotoId") Long productPhotoId);

    List<ProductPhotoEntity> findByListId(@Param("productPhotoListId") List<Long> productPhotoListId);

    void insert(@RequestBody @Param("productPhotoEntity") ProductPhotoEntity productPhotoEntity);

    void insertAll(@RequestBody @Param("productPhotoEntityList") List<ProductPhotoEntity> productPhotoEntityList);

    void updateById(@RequestBody @Param("productPhotoEntity") ProductPhotoEntity productPhotoEntity);

    void deleteById(@Param("productPhotoId") Long productPhotoId);

    List<ProductPhotoEntity> findRecurById(@Param("productPhotoId") Long productPhotoId);
}
