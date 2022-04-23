package com.mirea.homedepot.catalogservice.core.repository;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import com.mirea.homedepot.catalogservice.core.repository.base.BasicMethodRepository;
import com.mirea.homedepot.catalogservice.core.repository.base.Repository;
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

}
