package com.mirea.homedepot.catalogservice.core.repository;

import java.util.List;

public interface AbstractRepository<E> {
    List<E> findAll();

    E findById(Long id);

    List<E> findByListId(List<Long> listId);

    void insert(E e);

    void insertAll(List<E> eList);

    void updateById(E e);

    void deleteById(Long id);
}