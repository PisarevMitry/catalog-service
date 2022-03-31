package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductSpecialConditionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductSpecialConditionRepository {

    List<ProductSpecialConditionEntity> findAll();

    ProductSpecialConditionEntity findById(@Param("productSpecialConditionId") Long productSpecialConditionId);

    List<ProductSpecialConditionEntity> findByListId(@Param("productSpecialConditionListId") List<Long> productSpecialConditionListId);

    void insert(@RequestBody @Param("productSpecialConditionEntity") ProductSpecialConditionEntity productSpecialConditionEntity);

    void insertAll(@RequestBody @Param("productSpecialConditionEntityList") List<ProductSpecialConditionEntity> productSpecialConditionEntityList);

    void updateById(@RequestBody @Param("productSpecialConditionEntity") ProductSpecialConditionEntity productSpecialConditionEntity);

    void deleteById(@Param("productSpecialConditionId") Long productSpecialConditionId);
}
