package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.entity.RoleEntity;
import com.mirea.homedepot.commonmodule.model.Entity;
import com.mirea.homedepot.commonmodule.repositories.BasicMethodRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Mapper
public interface RoleRepository extends BasicMethodRepository {

    /**
     * Метод поиска роли по названию.
     *
     * @param name название роли
     * @return сущность роли
     */
    Entity findByName(@RequestParam("name") String name);

    /**
     * Метод поиска всех ролей пользователя.
     *
     * @param userId идентификатор пользователя
     * @return список сущностей ролей
     */
    Set<RoleEntity> getListRoleByUserId(@Param("userId") Long userId);
}
