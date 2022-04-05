package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductCategoryRepository extends BasicMethodRepository<ProductCategoryEntity> {
    List<ProductCategoryEntity> findByParentId(@Param("id") Long id);

    /**
     * Метод для получения списка дочерних категорий одной итерации
     * @param id идентификатор родительской категории
     * @return список сущностей категорий
     */
    //List<ProductCategoryEntity> findByParentId(@Param("id") Long id);

    //   Tree<ProductCategoryEntity> findTreeByParentId(@Param("id") Long id);

}
