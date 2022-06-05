package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.service.ProductService;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.type.ProductDtoType;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Dto> findAll(@RequestParam(required = false) String type) {
        if (type == null) {
            return productService.findAll();
        } else {
            return productService.findAll(ProductDtoType.valueOf(type));
        }
    }

    @GetMapping("/item")
    public Dto findById(@RequestParam(required = false) String type, @RequestBody ProductRequestFilter filter) {
        if (type == null) {
            return productService.findById(filter.getId());
        } else {
            return productService.findById(ProductDtoType.valueOf(type), filter.getId());
        }
    }

    @GetMapping("/list")
    List<Dto> findByListId(@RequestParam(required = false) String type, @RequestBody ProductRequestFilter filter) {
        if (type == null) {
            return productService.findByListId(filter.getListId());
        } else {
            return productService.findByListId(ProductDtoType.valueOf(type), filter.getListId());
        }
    }

    @GetMapping("/categories")
    List<Dto> findByCategoryId(@RequestParam(required = false) String type, @RequestBody ProductRequestFilter filter) {
        if (type == null) {
            return productService.findByCategoryId(filter.getCategoryId());
        } else {
            return productService.findByCategoryId(ProductDtoType.valueOf(type), filter.getCategoryId());
        }
    }

    @GetMapping("/list/categories")
    List<Dto> findByListCategoryId(@RequestParam(required = false) String type, @RequestBody ProductRequestFilter filter) {
        if (type == null) {
            return productService.findByListCategoryId(filter.getListCategoryId());
        } else {
            return productService.findByListCategoryId(ProductDtoType.valueOf(type), filter.getListCategoryId());
        }
    }

    @GetMapping("/options")
    List<Dto> getByOption(@RequestParam(required = false) String type, @RequestParam JSONObject option) {
        if (type == null) {
            return productService.findByOption(option);
        } else {
            return productService.findByOption(ProductDtoType.valueOf(type), option);
        }
    }

    @PostMapping()
    void insert(@RequestBody Dto dto) {
        productService.insert(dto);
    }
/*
    @PostMapping("/list")
    void insertList(
            @RequestParam(required = false)
                    String type,
            @RequestBody
                    List<Dto> dto) {
        if (type == null) {
            productService.insertList(dto);
        } else {
            productService.insertList(ProductDtoType.valueOf(type), dto);
        }
    }

    @PutMapping()
    void update(
            @RequestParam(required = false)
                    String type,
            @RequestBody
                    Dto dto) {
        if (type == null) {
            productService.update(dto);
        } else {
            productService.update(ProductDtoType.valueOf(type), dto);
        }
    }

    @DeleteMapping()
    void delete(
            @RequestParam(required = false)
                    String type,
            @RequestBody
                    Long id) {
        if (type == null) {
            productService.delete(id);
        } else {
            productService.delete(ProductDtoType.valueOf(type), id);
        }
    }
*/
}