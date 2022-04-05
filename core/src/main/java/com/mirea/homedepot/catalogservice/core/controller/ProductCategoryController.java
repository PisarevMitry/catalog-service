package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.service.ProductCategoryService;
import com.mirea.homedepot.catalogservice.dto.ProductCategoryDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
    List<ProductCategoryDto> getProductCategoryById() {
        return productCategoryService.findAll();
    }

    @GetMapping("/get/item")
    ProductCategoryDto getProductCategoryById(@RequestParam Long id) {
        return productCategoryService.findById(id);
    }

    @GetMapping("/get/list")
    List<ProductCategoryDto> getProductCategoryByListId(@RequestParam List<Long> listId) {
        return productCategoryService.findByListId(listId);
    }

    @GetMapping("/get/relative/list")
    List<ProductCategoryDto> getProductCategoryByParentId(@RequestParam Long id) {
        return productCategoryService.findRecurListByParentId(id);
    }

 /*   @GetMapping("/get?{id}&{numberIteration}")
    Tree<ProductCategoryDto> getProductCategoryByParentId(@PathVariable Long id, @PathVariable Integer numberIteration) {
        return productCategoryService.findTreeByParentId(id, numberIteration);
    }*/
}
