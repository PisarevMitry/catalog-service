package com.mirea.homedepot.catalogservice.core.service;

import java.util.List;

public interface RecursiveSearchForDefaultDto<D> {
    List<D> findListRecursiveByParentId(Long id);
}
