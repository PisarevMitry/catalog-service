package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.catalogservice.core.controller.ProductRequestFilter;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.type.ProductDtoType;
import com.mirea.homedepot.commonmodule.services.CrudServiceForDefaultDto;
import com.mirea.homedepot.commonmodule.services.CrudServiceForNotDefaultDto;
import org.json.JSONObject;

import java.util.List;

/**
 * Сервис работы с товарами.
 */
public interface ProductService extends CrudServiceForDefaultDto, CrudServiceForNotDefaultDto<ProductDtoType> {

    /**
     * Метод поиска товаров по категории.
     *
     * @param id
     * @return
     */
    List<Dto> findByCategoryId(Long id);

    /**
     * Метод поиска товаров по категории.
     *
     * @param type
     * @param id
     * @return
     */
    List<Dto> findByCategoryId(ProductDtoType type, Long id);

    /**
     * @param listId
     * @return
     */
    List<Dto> findByListCategoryId(List<Long> listId);

    /**
     * @param type
     * @param listId
     * @return
     */
    List<Dto> findByListCategoryId(ProductDtoType type, List<Long> listId);

    /**
     * @param option
     * @return
     */
    List<Dto> findByOption(JSONObject option);

    /**
     * @param type
     * @param option
     * @return
     */
    List<Dto> findByOption(ProductDtoType type, JSONObject option);

    void insert(ProductRequestFilter requestFilter);
}
