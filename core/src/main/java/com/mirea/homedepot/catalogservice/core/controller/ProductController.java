package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.service.ProductService;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import com.mirea.homedepot.catalogservice.dto.type.ProductDtoType;
import org.json.JSONObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get")
    public List<Dto> getAll(
            @RequestParam(required = false)
                    String type) {
        if (type == null) {
            return productService.findAll();
        } else {
            return productService.findAll(ProductDtoType.valueOf(type));
        }
    }

    @GetMapping("/get/definite/item")
    public Dto getById(
            @RequestParam(required = false)
                    String type,
            @RequestParam
                    Long id) {
        if (type == null) {
            return productService.findById(id);
        } else {
            return productService.findById(ProductDtoType.valueOf(type), id);
        }
    }

    @GetMapping("/get/definite/list")
    List<Dto> getById(
            @RequestParam(required = false)
                    String type,
            @RequestBody
                    List<Long> listId) {
        if (type == null) {
            return productService.findByListId(listId);
        } else {
            return productService.findByListId(ProductDtoType.valueOf(type),
                    listId);
        }
    }

    @GetMapping("/get/category/list")
    List<Dto> getByCategoryId(
            @RequestParam(required = false)
                    String type,
            @RequestParam
                    Long id) {
        if (type == null) {
            return productService.findByCategoryId(id);
        } else {
            return productService.findByCategoryId(ProductDtoType.valueOf(type),
                    id);
        }
    }

    @GetMapping("/get/option/list")
    List<Dto> getByOption(
            @RequestParam(required = false)
                    String type,
            @RequestParam
                    JSONObject option) {
        if (type == null) {
            return productService.findByOption(option);
        } else {
            return productService.findByOption(ProductDtoType.valueOf(type),
                    option);
        }
    }

}