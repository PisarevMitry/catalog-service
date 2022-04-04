package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductPhotoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductPhotoRepository extends BasicMethodRepository<ProductPhotoEntity>{

    List<ProductPhotoEntity> findRecurById(@Param("id") Long id);
}
