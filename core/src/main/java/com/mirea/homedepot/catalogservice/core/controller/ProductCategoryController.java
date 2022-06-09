package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.service.ProductCategoryService;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.type.ProductCategoryDtoType;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер категорий товаров.
 */
@Validated
@RestController
@RequestMapping("/categories")
@AllArgsConstructor
@PreAuthorize(value = "hasAuthority('ctl.admin')")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    /**
     * Метод получения всех категорий.
     *
     * @param type тип возвращаемого представления
     * @return список представлений сущности "Категория товара"
     */
    @GetMapping
    @PreAuthorize("hasAuthority('ctl.searchProducts')")
    public List<Dto> getAll(@RequestParam(required = false) String type) {
        if (type == null) {
            return productCategoryService.findAll();
        } else {
            return productCategoryService.findAll(ProductCategoryDtoType.valueOf(type));
        }
    }

    /**
     * Метод получения категории по идентификатору.
     *
     * @param type тип возвращаемого представления
     * @param id   идентификатор записи
     * @return представление сущности "Категория товара"
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ctl.searchProducts')")
    public Dto getById(@RequestParam(required = false) String type, @PathVariable Long id) {
        if (type == null) {
            return productCategoryService.findById(id);
        } else {
            return productCategoryService.findById(ProductCategoryDtoType.valueOf(type), id);
        }
    }

    /**
     * Метод получения списка категорий по списку идентификаторов.
     *
     * @param type   тип возвращаемого представления
     * @param listId список идентификаторов записей
     * @return список представлений сущности "Категория товара"
     */
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ctl.searchProducts')")
    List<Dto> getByListId(@RequestParam(required = false) String type, @RequestBody List<Long> listId) {
        if (type == null) {
            return productCategoryService.findByListId(listId);
        } else {
            return productCategoryService.findByListId(ProductCategoryDtoType.valueOf(type), listId);
        }
    }

    /**
     * Метод получения списка дочерних категорий.
     *
     * @param type тип возвращаемого представления
     * @param id   идентификатор записи
     * @return список представлений сущности "Категория товара"
     */
    @GetMapping("/get/child/list")
    @PreAuthorize("hasAuthority('ctl.searchProducts')")
    List<Dto> getListChildItem(@RequestParam(required = false) String type, @RequestParam Long id) {
        if (type == null) {
            return productCategoryService.findTreeIterationByParentId(id);
        } else {
            return productCategoryService.findTreeIterationByParentId(ProductCategoryDtoType.valueOf(type), id);
        }
    }

    /**
     * Метод получения списка родительских категорий.
     *
     * @param type тип возвращаемого представления
     * @param id   идентификатор записи
     * @return список представлений сущности "Категория товара"
     */
    @GetMapping("/get/path/list")
    @PreAuthorize("hasAuthority('ctl.searchProducts')")
    List<Dto> getItemPath(@RequestParam(required = false) String type, @RequestParam Long id) {
        if (type == null) {
            return productCategoryService.findTreePathByParentId(id);
        } else {
            return productCategoryService.findTreePathByParentId(ProductCategoryDtoType.valueOf(type), id);
        }
    }
}
