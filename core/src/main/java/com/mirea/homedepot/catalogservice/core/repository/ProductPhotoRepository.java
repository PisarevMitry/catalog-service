package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.repository.base.BasicMethodRepository;
import com.mirea.homedepot.catalogservice.core.repository.base.ParentSearchRepository;
import com.mirea.homedepot.catalogservice.core.repository.base.Repository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductPhotoRepository
        extends Repository, BasicMethodRepository, ParentSearchRepository {

}
