package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductVideoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductVideoRepository {
    List<ProductVideoEntity> findAll();

    ProductVideoEntity findById(@Param("productVideoId") Long productVideoId);

    List<ProductVideoEntity> findByListId(@Param("productVideoListId") List<Long> productVideoListId);

    void insert(@RequestBody @Param("productVideoEntity") ProductVideoEntity productVideoEntity);

    void insertAll(@RequestBody @Param("productVideoEntityList") List<ProductVideoEntity> productVideoEntityList);

    void updateById(@RequestBody @Param("productVideoEntity") ProductVideoEntity productVideoEntity);

    void deleteById(@Param("productVideoId") Long productVideoId);


    List<ProductVideoEntity> findRecurById(@Param("productVideoId") Long productVideoId);
}
