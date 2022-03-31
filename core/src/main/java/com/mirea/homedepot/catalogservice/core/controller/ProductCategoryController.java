package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.service.impl.ProductCategoryServiceImpl;
import com.mirea.homedepot.catalogservice.dto.ProductCategoryDto;
import com.mirea.homedepot.catalogservice.dto.ProductCategoryTreeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/catalog-service/product")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @GetMapping("/get?{id}")
    ProductCategoryDto getProductCategoryById(@PathVariable Long id) {
        return productCategoryService.findById(id);

    }

    @GetMapping("/get")
    List<ProductCategoryDto> getProductCategoryByListId(@RequestParam List<Long> listId) {

        return productCategoryService.findByListId(listId);
    }

    @GetMapping("/get?{id}")
    List<ProductCategoryDto> getProductCategoryByParentId(@PathVariable Long id) {
        return productCategoryService.findListByParentId(id);
    }

    @GetMapping("/get?{id}&{numberIteration}")
    ProductCategoryTreeDto getProductCategoryByParentId(@PathVariable Long id, @PathVariable Integer numberIteration) {
        return productCategoryService.findTreeByParentId(id);
    }

}
