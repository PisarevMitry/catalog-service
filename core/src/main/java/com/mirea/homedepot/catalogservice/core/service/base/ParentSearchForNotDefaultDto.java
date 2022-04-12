package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;

import java.util.List;

public interface ParentSearchForNotDefaultDto<T> {
    List<Dto> findTreeIterationByParentId(T type, Long id);

    List<Dto> findTreePathByParentId(T type, Long id);
}
