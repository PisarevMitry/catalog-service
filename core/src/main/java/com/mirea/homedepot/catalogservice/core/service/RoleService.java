package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.core.model.entity.RoleEntity;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.services.CrudServiceForDefaultDto;

import java.util.Set;

public interface RoleService extends CrudServiceForDefaultDto {
    Set<RoleEntity> getListRoleByUserId(Long userId);

    Dto findByName(String name);
}
