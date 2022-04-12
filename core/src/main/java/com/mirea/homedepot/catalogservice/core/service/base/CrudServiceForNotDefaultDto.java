package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;

import java.util.List;

public interface CrudServiceForNotDefaultDto<T> {

    List<Dto> findAll(T type);

    Dto findById(T type, Long id);

    List<Dto> findByListId(T type, List<Long> listId);
}
