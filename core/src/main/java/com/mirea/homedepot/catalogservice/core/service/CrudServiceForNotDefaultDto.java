package com.mirea.homedepot.catalogservice.core.service;

import java.util.List;

public interface CrudServiceForNotDefaultDto<D, T> {
    List<D> findAll(T type);

    D findById(T type, Long id);

    List<D> findByListId(T type, List<Long> listId);

}
