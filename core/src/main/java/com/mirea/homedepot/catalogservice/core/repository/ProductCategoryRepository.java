package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.repository.base.BasicMethodRepository;
import com.mirea.homedepot.catalogservice.core.repository.base.ParentSearchRepository;
import com.mirea.homedepot.catalogservice.core.repository.base.Repository;
import com.mirea.homedepot.catalogservice.core.repository.base.TreeSearchRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductCategoryRepository
        extends Repository, BasicMethodRepository, ParentSearchRepository,
                TreeSearchRepository {
}
