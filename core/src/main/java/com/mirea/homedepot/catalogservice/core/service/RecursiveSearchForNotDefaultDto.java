package com.mirea.homedepot.catalogservice.core.service;

import java.util.List;

public interface RecursiveSearchForNotDefaultDto<D, T> {
    List<D> findListRecursiveByParentId(T type, Long id);
}
