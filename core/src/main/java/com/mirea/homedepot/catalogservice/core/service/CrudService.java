package com.mirea.homedepot.catalogservice.core.service;

import java.util.List;

public interface CrudService<D> {
    List<D> findAll();

    D findById(Long id);

    List<D> findByListId(List<Long> listId);

    void insert(D d);

    void insertList(List<D> dList);

    void update(D d);

    void deleteById(Long id);
}
