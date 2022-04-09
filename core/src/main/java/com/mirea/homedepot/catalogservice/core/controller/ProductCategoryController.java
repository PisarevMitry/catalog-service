package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.service.base.ProductCategoryService;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductCategoryDto;
import com.mirea.homedepot.catalogservice.dto.type.ProductCategoryDtoType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/category")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("/get")
    public List<ProductCategoryDto> getList(@RequestParam(required = false) String type) {
        if (type == null) {
            return productCategoryService.findAll();
        } else {
            return productCategoryService.findAll(ProductCategoryDtoType.valueOf(type));
        }
    }

    @GetMapping("/get/definite/item")
    public ProductCategoryDto getItem(@RequestParam(required = false) String type, @RequestParam Long id) {
        if (type == null) {
            return productCategoryService.findById(id);
        } else {
            return productCategoryService.findById(ProductCategoryDtoType.valueOf(type), id);
        }
    }

    @GetMapping("/get/definite/list")
    List<ProductCategoryDto> getList(@RequestParam(required = false) String type, @RequestBody List<Long> listId) {
        if (type == null) {
            return productCategoryService.findByListId(listId);
        } else {
            return productCategoryService.findByListId(ProductCategoryDtoType.valueOf(type), listId);
        }
    }

    @GetMapping("/get/child/list")
    List<ProductCategoryDto> getListChildItem(@RequestParam(required = false) String type, @RequestParam Long id) {
        if (type == null) {
            return productCategoryService.findListByParentId(id);
        } else {
            return productCategoryService.findListByParentId(ProductCategoryDtoType.valueOf(type), id);
        }
    }

    @GetMapping("/get/path/list")
    List<ProductCategoryDto> getItemPath(@RequestParam(required = false) String type, @RequestParam Long id) {
        if (type == null) {
            return productCategoryService.findListRecursiveByParentId(id);
        } else {
            return productCategoryService.findListRecursiveByParentId(ProductCategoryDtoType.valueOf(type), id);
        }
    }
/*
   @GetMapping("/get?{id}&{numberIteration}")
    Tree<ProductCategoryDto> getProductCategoryByParentId(@PathVariable Long id, @PathVariable Integer numberIteration) {
        return productCategoryService.findTreeByParentId(id, numberIteration);
    }*/
}
