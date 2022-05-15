package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.service.ProductCategoryService;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.definition.ProductCategoryDto;
import com.mirea.homedepot.commonmodule.dto.type.ProductCategoryDtoType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/categories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(
            ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public List<Dto> getAll(
            @RequestParam(required = false)
                    String type) {
        if (type == null) {
            return productCategoryService.findAll();
        } else {
            return productCategoryService.findAll(
                    ProductCategoryDtoType.valueOf(type));
        }
    }

    @GetMapping("/{id}")
    public Dto getById(
            @RequestParam(required = false)
                    String type,
            @PathVariable
                    Long id) {
        if (type == null) {
            return productCategoryService.findById(id);
        } else {
            return productCategoryService.findById(
                    ProductCategoryDtoType.valueOf(type), id);
        }
    }

    @GetMapping("/list")
    List<Dto> getByListId(
            @RequestParam(required = false)
                    String type,
            @RequestBody
                    List<Long> listId) {
        if (type == null) {
            return productCategoryService.findByListId(listId);
        } else {
            return productCategoryService.findByListId(
                    ProductCategoryDtoType.valueOf(type), listId);
        }
    }

    @GetMapping("/get/child/list")
    List<Dto> getListChildItem(
            @RequestParam(required = false)
                    String type,
            @RequestParam
                    Long id) {
        if (type == null) {
            return productCategoryService.findTreeIterationByParentId(id);
        } else {
            return productCategoryService.findTreeIterationByParentId(
                    ProductCategoryDtoType.valueOf(type), id);
        }
    }

    @GetMapping("/get/path/list")
    List<Dto> getItemPath(
            @RequestParam(required = false)
                    String type,
            @RequestParam
                    Long id) {
        if (type == null) {
            return productCategoryService.findTreePathByParentId(id);
        } else {
            return productCategoryService.findTreePathByParentId(
                    ProductCategoryDtoType.valueOf(type), id);
        }
    }

    /*@GetMapping("/get?{id}&{numberIteration}")
    Tree<ProductCategoryDto> getProductCategoryByParentId(
            @PathVariable
                    Long id,
            @PathVariable
                    Integer numberIteration) {
        return productCategoryService.findTreeByParentId(id, numberIteration);
    }*/
}
