package com.mirea.homedepot.catalogservice.core.service.base;

import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;

import java.util.List;

public interface CrudServiceForDefaultDto {
    List<Dto> findAll();

    Dto findById(Long id);

    List<Dto> findByListId(List<Long> listId);

    void insert(Dto d);

    void insertList(List<Dto> dList);

    void update(Dto d);

    void deleteById(Long id);
}
