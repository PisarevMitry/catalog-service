package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.commonmodule.model.Entity;
import com.mirea.homedepot.commonmodule.repositories.BasicMethodRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface UserRepository extends BasicMethodRepository {
    Entity findByLogin(
            @RequestParam("login")
                    String login);
}
