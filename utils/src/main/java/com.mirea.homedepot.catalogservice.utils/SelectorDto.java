package com.mirea.homedepot.catalogservice.utils;

import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.model.Entity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для изменения представления dto и entity.
 */
@Component
public class SelectorDto {

    private static SelectorDtoMapper<Entity> mapFromEntityClass;

    private static SelectorDtoMapper<Dto> mapFromDtoClass;

    public SelectorDto(ModelMapper modelMapper) {
        mapFromEntityClass = new SelectorDtoMapper<Entity>(modelMapper);
        mapFromDtoClass = new SelectorDtoMapper<Dto>(modelMapper);
    }

    /**
     * @return
     */
    public static SelectorDtoMapper<Entity> mapFromEntity() {
        return mapFromEntityClass;
    }

    /**
     * @return
     */
    public static SelectorDtoMapper<Dto> mapFromDto() {
        return mapFromDtoClass;
    }

    /**
     * @param <T>
     */
    public static class SelectorDtoMapper<T> {

        /**
         *
         */
        private final ModelMapper modelMapper;

        /**
         * @param modelMapper
         */
        SelectorDtoMapper(ModelMapper modelMapper) {
            this.modelMapper = modelMapper;
        }

        /**
         * @param t
         * @param resultClass
         * @return
         */
        public Dto select(T t, Class<? extends Dto> resultClass) {
            return map(t, resultClass);
        }

        /**
         * @param list
         * @param resultClass
         * @return
         */
        public List<Dto> select(List<T> list,
                                Class<? extends Dto> resultClass) {
            return mapList(list, resultClass);
        }

        /**
         * @param t
         * @param resultClass
         * @return
         */
        private Dto map(T t, Class<? extends Dto> resultClass) {
            return modelMapper.map(t, resultClass);
        }

        /**
         * @param list
         * @param resultClass
         * @return
         */
        private List<Dto> mapList(List<T> list,
                                  Class<? extends Dto> resultClass) {
            return list.stream().map(el -> map(el, resultClass))
                .collect(Collectors.toList());
        }
    }
}