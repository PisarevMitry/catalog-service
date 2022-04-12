package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;

import java.util.List;

public interface ParentSearchForDefaultDto {
    List<Dto> findTreeIterationByParentId(Long id);

    List<Dto> findTreePathByParentId(Long id);
}
