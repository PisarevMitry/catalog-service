package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.RoleEntity;
import com.mirea.homedepot.catalogservice.core.model.entity.UserEntity;
import com.mirea.homedepot.catalogservice.core.repository.UserRepository;
import com.mirea.homedepot.catalogservice.core.service.RoleService;
import com.mirea.homedepot.catalogservice.core.service.UserSecurityService;
import com.mirea.homedepot.catalogservice.core.service.UserService;
import com.mirea.homedepot.catalogservice.dto.variable.basic.UserDto;
import com.mirea.homedepot.catalogservice.utils.SelectorDto;
import com.mirea.homedepot.catalogservice.utils.SelectorEntity;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.model.Entity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserSecurityService {

    private final UserRepository userRepository;

    private final RoleService roleService;

    private final SelectorEntity selectorEntity;

    private final SelectorDto selectorDto;

    public UserServiceImpl(UserRepository userRepository,
                           RoleService roleService, SelectorEntity selectorEntity,
                           SelectorDto selectorDto) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.selectorEntity = selectorEntity;
        this.selectorDto = selectorDto;
    }

    @Override
    public List<Dto> findAll() {
        List<Entity> userEntityList = userRepository.findAll();
        return SelectorDto.mapFromEntity()
                .select(userEntityList, UserDto.class);
    }

    @Override
    public Dto findById(Long userId) {
        Entity userEntity = userRepository.findById(userId);
        return SelectorDto.mapFromEntity().select(userEntity, UserDto.class);
    }

    @Override
    public List<Dto> findByListId(List<Long> listId) {
        List<Entity> userEntityList = userRepository.findByListId(listId);
        return SelectorDto.mapFromEntity()
                .select(userEntityList, UserDto.class);
    }

    @Override
    public void insert(Dto userDto) {
        Entity userEntity =
                selectorEntity.mapFromDto().select(userDto, UserEntity.class);
        if (userEntity.getId() == null) userRepository.insert(userEntity);
        else userRepository.update(userEntity);
    }

    @Override
    public void insertList(List<Dto> userDtoList) {
        List<Entity> userEntityList = SelectorEntity.mapFromDto()
                .select(userDtoList, UserEntity.class);
        userRepository.insertList(userEntityList);
    }

    @Override
    public void update(Dto userDto) {
        Entity userEntity =
                SelectorEntity.mapFromDto().select(userDto, UserEntity.class);
        userRepository.update(userEntity);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Dto findByLogin(String login) {
        Entity userEntity = userRepository.findByLogin(login);
        return SelectorDto.mapFromEntity().select(userEntity, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserEntity user = (UserEntity) findByLogin(username);
        user.setRoles(getListRoleByUserId(user.getId()));
        return user;
    }

    public Set<RoleEntity> getListRoleByUserId(Long userId) {
        return roleService.getListRoleByUserId(userId);
    }
}
