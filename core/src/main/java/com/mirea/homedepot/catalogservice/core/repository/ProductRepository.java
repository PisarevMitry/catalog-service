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
     * @param option список харрактеристик товара
     * @return список объектов класса Entity
     */
    List<Entity> findListByOption(
            @RequestBody
            @Param("option")
                    JSONObject option);

    List<Entity> findByCategoryId(
            @Param("id")
                    Long id);

    List<Entity> findByListCategoryId(
            @Param("listId")
                    List<Long> listId);

    List<Entity> findByOption(
            @Param("option")
                    JSONObject option);
}
