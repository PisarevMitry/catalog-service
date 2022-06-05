package com.mirea.homedepot.catalogservice.utils;

import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.model.Entity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Component
public class SelectorEntity {

    /**
     *
     */
    private static SelectorEntityMapper<Entity> mapFromEntityClass;

    /**
     *
     */
    private static SelectorEntityMapper<Dto> mapFromDtoClass;

    /**
     * @param modelMapper
     */
    public SelectorEntity(ModelMapper modelMapper) {
        mapFromEntityClass = new SelectorEntityMapper<Entity>(modelMapper);
        mapFromDtoClass = new SelectorEntityMapper<Dto>(modelMapper);
    }

    /**
     * @return
     */
    public static SelectorEntityMapper<Entity> mapFromEntity() {
        return mapFromEntityClass;
    }

    /**
     * @return
     */
    public static SelectorEntityMapper<Dto> mapFromDto() {
        return mapFromDtoClass;
    }

    /**
     * @param <T>
     */
    public static class SelectorEntityMapper<T> {

        /**
         *
         */
        private ModelMapper modelMapper;

        SelectorEntityMapper(ModelMapper modelMapper) {
            this.modelMapper = modelMapper;
        }

        /**
         * @param t
         * @param resultClass
         * @return
         */
        public Entity select(T t, Class<? extends Entity> resultClass) {
            return map(t, resultClass);
        }

        /**
         * @param list
         * @param resultClass
         * @return
         */
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