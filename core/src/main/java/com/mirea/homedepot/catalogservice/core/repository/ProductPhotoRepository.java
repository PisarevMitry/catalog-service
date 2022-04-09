package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductPhotoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductPhotoRepository extends BasicMethodRepository<ProductPhotoEntity>, ParentSearchRepository<ProductPhotoEntity> {

}
