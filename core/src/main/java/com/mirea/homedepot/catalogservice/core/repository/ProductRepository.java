package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.commonmodule.model.Entity;
import com.mirea.homedepot.commonmodule.repositories.BasicMethodRepository;
import com.mirea.homedepot.commonmodule.repositories.Repository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductRepository extends Repository, BasicMethodRepository {

    /**
     * Метод поиска записей в БД.
     *
     * @param option список харрактеристик товара
     * @return список объектов класса Entity
     */
    List<Entity> findListByOption(@RequestBody @Param("option") JSONObject option);

    /**
     * Метод поиска по категории.
     *
     * @param id идентификатор товара
     * @return сущность сущностей товаров
     */
    List<Entity> findByCategoryId(@Param("id") Long id);

    /**
     * Метод поиска по списку категорий.
     *
     * @param listId список идентификаторов
     * @return список сущностей товаров
     */
    List<Entity> findByListCategoryId(@Param("listId") List<Long> listId);

    /**
     * Метод поиска товаров по харрактеристикам.
     *
     * @param option харрактеристики товара
     * @return список сущностей товаров
     */
    List<Entity> findByOption(@Param("option") JSONObject option);
}
