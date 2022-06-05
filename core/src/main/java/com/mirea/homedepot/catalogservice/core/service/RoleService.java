package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.core.model.entity.RoleEntity;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.services.CrudServiceForDefaultDto;

import java.util.Set;

/**
 * Сервис работы с ролями
 */
public interface RoleService extends CrudServiceForDefaultDto {

    /**
     * Метод поиска списка ролей пользователя.
     *
     * @param userId идентификатор пользователя.
     * @return список сущностей ролей
     */
    Set<RoleEntity> getListRoleByUserId(Long userId);

    /**
     * Метод поиска польщователя
     *
     * @param name логин пользователя
     * @return представление пользователя
     */
    Dto findByName(String name);
}
