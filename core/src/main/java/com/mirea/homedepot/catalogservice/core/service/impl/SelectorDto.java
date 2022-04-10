package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class SelectorDto<T> {

    private final ModelMapper modelMapper;

    public SelectorDto(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Dto selectItem(T t, Class<? extends Dto> resultClass) {
        return map(t, resultClass);
    }

    public List<Dto> selectList(List<T> list, Class<? extends Dto> resultClass) {
        return mapList(list, resultClass);
    }

    private Dto map(T t, Class<? extends Dto> resultClass) {
        return modelMapper.map(t, resultClass);
    }

    private List<Dto> mapList(@NotNull List<T> list, Class<? extends Dto> resultClass) {
        return list.stream().map(el -> map(el, resultClass)).collect(Collectors.toList());
    }
}
/*

public static class SelectorDtoFromEntity extends SelectorDto {

    public static Dto selectItemTypeDto(Entity entity, Class<? extends Dto> resultClass) {
        return mapEntity(entity, resultClass);
    }

    public static List<Dto> selectListTypeDto(List<Entity> entityList, Class<? extends Dto> resultClass) {
        return mapEntityList(entityList, resultClass);
    }

    private static Dto mapEntity(Entity entity, Class<? extends Dto> resultClass) {
        return modelMapper.map(entity, resultClass);
    }

    private static List<Dto> mapEntityList(@NotNull List<Entity> entityList, Class<? extends Dto> resultClass) {
        return entityList.stream().map(el -> mapEntity(el, resultClass)).collect(Collectors.toList());
    }
}*/
