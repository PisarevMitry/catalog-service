package com.mirea.homedepot.catalogservice.core.repository.base;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Интерфейс опряделяющий полные итеративные методы для работы с записями в БД.
 */
public interface TreeSearchRepository extends IterativeRepository {

    /**
     * Метод создания дерева элементов на основе всех записей.
     * @param id идентификатор родительской записи
     * @return список объектов класса Entity
     */
    List<Entity> findTreeByParentId(
            @Param("id")
                    Long id);

}
