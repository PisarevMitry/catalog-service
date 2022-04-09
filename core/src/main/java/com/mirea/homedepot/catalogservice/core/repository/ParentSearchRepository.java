package com.mirea.homedepot.catalogservice.core.repository;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParentSearchRepository<E> {
    List<E> findByParentId(@Param("parentId") Long parentId);
}
