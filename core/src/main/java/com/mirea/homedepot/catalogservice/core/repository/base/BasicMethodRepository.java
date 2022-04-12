package com.mirea.homedepot.catalogservice.core.repository.base;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;


import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Интерфейс опряделяющий общие методы для работы с записями в БД.
 */
public interface BasicMethodRepository {

    /**
     * Метод для поиска всех записей.
     * @return список объектов класса Entity
     */
    List<Entity> findAll();

    /**
     * Метод для поиска одной записи.
     * @param id идентификатор записи
     * @return объект класса Entity
     */
    Entity findById(
            @RequestParam("id")
                    Long id);

    /**
     * Метод для поиска множества записи.
     * @param listId список идентификаторов записей
     * @return список объектов класса Entity
     */
    List<Entity> findByListId(
            @RequestParam("listId")
                    List<Long> listId);

    /**
     * Метод для добавления записи в таблицу.
     * @param entity объект класса Entity
     * @return результат операции
     */
    Boolean insert(
            @RequestParam("entity")
                    Entity entity);

    /**
     * Метод для добавления множества записей в таблицу.
     * @param entityList список объектов класса Entity
     * @return результат операции
     */
    Boolean insertList(
            @RequestParam("entityList")
                    List<Entity> entityList);

    /**
     * Метод для изменения записи в таблице.
     * @param entity обновленный объект класса Entity
     * @return результат операции
     */
    Boolean update(
            @RequestParam("entity")
                    Entity entity);

    /**
     * Метод для удаления записи.
     * @param id идентификатор записи
     * @return результат операции
     */
    Boolean deleteById(
            @RequestParam("id")
                    Long id);
}
