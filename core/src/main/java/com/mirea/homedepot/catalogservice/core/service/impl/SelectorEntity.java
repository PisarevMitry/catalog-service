package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SelectorEntity {

    private static SelectorEntityMapper<Entity> mapFromEntityClass;

    private static SelectorEntityMapper<Dto> mapFromDtoClass;

    public SelectorEntity(ModelMapper modelMapper) {
        mapFromEntityClass = new SelectorEntityMapper<Entity>(modelMapper);
        mapFromDtoClass = new SelectorEntityMapper<Dto>(modelMapper);
    }

    public static SelectorEntityMapper<Entity> mapFromEntity() {
        return mapFromEntityClass;
    }

    public static SelectorEntityMapper<Dto> mapFromDto() {
        return mapFromDtoClass;
    }

    static class SelectorEntityMapper<T> {

        private ModelMapper modelMapper;

        SelectorEntityMapper(ModelMapper modelMapper) {
            this.modelMapper = modelMapper;
        }

        public Entity select(T t, Class<? extends Entity> resultClass) {
            return map(t, resultClass);
        }

        public List<Entity> select(List<T> list,
                                   Class<? extends Entity> resultClass) {
            return mapList(list, resultClass);
        }

        private Entity map(T t, Class<? extends Entity> resultClass) {
            return modelMapper.map(t, resultClass);
        }

        private List<Entity> mapList(List<T> list,
                                     Class<? extends Entity> resultClass) {
            return list.stream().map(el -> map(el, resultClass))
                    .collect(Collectors.toList());
        }
    }
}