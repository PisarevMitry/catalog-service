package com.mirea.homedepot.catalogservice.core.repository;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Интерфейс опряделяющий общие методы для работы с записями в БД.
 * @param <E> Entity сущность
 */
public interface BasicMethodRepository<E> {

    /**
     * Метод для поиска всех записей.
     * @return список объектов класса Entity
     */
    List<E> findAll();

    /**
     * Метод для поиска одной записи.
     * @param id идентификатор записи
     * @return объект класса Entity
     */
    E findById(
            @RequestParam("id")
                    Long id);

    /**
     * Метод для поиска множества записи.
     * @param listId список идентификаторов записей
     * @return список объектов класса Entity
     */
    List<E> findByListId(
            @RequestParam("listId")
                    List<Long> listId);

    /**
     * Метод для добавления записи в таблицу.
     * @param entity объект класса Entity
     * @return результат операции
     */
    Boolean insert(
            @RequestParam("entity")
                    E entity);

    /**
     * Метод для добавления множества записей в таблицу.
     * @param entityList список объектов класса Entity
     * @return результат операции
     */
    Boolean insertList(
            @RequestParam("entityList")
                    List<E> entityList);

    /**
     * Метод для изменения записи в таблице.
     * @param entity обновленный объект класса Entity
     * @return результат операции
     */
    Boolean update(
            @RequestParam("entity")
                    E entity);

    /**
     * Метод для удаления записи.
     * @param id идентификатор записи
     * @return результат операции
     */
    Boolean deleteById(
            @RequestParam("id")
                    Long id);
}
