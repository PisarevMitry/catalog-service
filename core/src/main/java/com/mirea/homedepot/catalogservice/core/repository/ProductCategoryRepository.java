package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.commonmodule.repositories.BasicMethodRepository;
import com.mirea.homedepot.commonmodule.repositories.ParentSearchRepository;
import com.mirea.homedepot.commonmodule.repositories.Repository;
import com.mirea.homedepot.commonmodule.repositories.TreeSearchRepository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductCategoryRepository extends Repository, BasicMethodRepository, ParentSearchRepository, TreeSearchRepository {
}
