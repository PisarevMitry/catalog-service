package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.commonmodule.repositories.BasicMethodRepository;
import com.mirea.homedepot.commonmodule.repositories.Repository;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogRepository extends Repository, BasicMethodRepository {

}

