package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.RoleEntity;
import com.mirea.homedepot.catalogservice.core.repository.RoleRepository;
import com.mirea.homedepot.catalogservice.core.service.RoleService;
import com.mirea.homedepot.catalogservice.dto.variable.basic.RoleDto;
import com.mirea.homedepot.catalogservice.utils.SelectorDto;
import com.mirea.homedepot.catalogservice.utils.SelectorEntity;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.model.Entity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<Dto> findAll() {
        List<Entity> roleEntityList = roleRepository.findAll();
        return SelectorDto.mapFromEntity()
            .select(roleEntityList, RoleDto.class);
    }

    @Override
    public Dto findById(Long roleId) {
        Entity roleEntity = roleRepository.findById(roleId);
        return SelectorDto.mapFromEntity().select(roleEntity, RoleDto.class);
    }

    @Override
    public List<Dto> findByListId(List<Long> listId) {
        List<Entity> roleEntityList = roleRepository.findByListId(listId);
        return SelectorDto.mapFromEntity()
            .select(roleEntityList, RoleDto.class);
    }

    @Override
    public void insert(Dto roleDto) {
        Entity roleEntity =
            SelectorEntity.mapFromDto().select(roleDto, RoleEntity.class);
        if (roleEntity.getId() == null) {
            roleRepository.insert(roleEntity);
        } else {
            roleRepository.update(roleEntity);
        }
    }

    @Override
    public void insertList(List<Dto> roleDtoList) {
        List<Entity> roleEntityList = SelectorEntity.mapFromDto()
            .select(roleDtoList, RoleEntity.class);
        roleRepository.insertList(roleEntityList);
    }

    @Override
    public void update(Dto roleDto) {
        Entity roleEntity =
            SelectorEntity.mapFromDto().select(roleDto, RoleEntity.class);
        roleRepository.update(roleEntity);
    }

    @Override
    public void deleteById(Long roleId) {
        roleRepository.deleteById(roleId);
    }

    @Override
    public Set<RoleEntity> getListRoleByUserId(Long userId) {
        return roleRepository.getListRoleByUserId(userId);
    }

    @Override
    public Dto findByName(String name) {
        Entity roleEntity = roleRepository.findByName(name);
        return SelectorDto.mapFromEntity().select(roleEntity, RoleDto.class);
    }
}

