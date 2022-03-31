package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductRepository;
import com.mirea.homedepot.catalogservice.dto.ProductDto;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/catalog-service")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get")
    List<ProductDto> getAllProductList() {
        List<ProductEntity> entity = productRepository.findAll();
        return entity.stream().map(el -> modelMapper.map(el, ProductDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    ProductDto getProductById(@PathVariable Long id) {
        ProductEntity entity = productRepository.findById(id);
        return modelMapper.map(entity, ProductDto.class);
    }

    @GetMapping("/get/{listId}")
    List<ProductDto> getProductByListId(@PathVariable List<Long> listId) {
        List<ProductEntity> entity = productRepository.findByListId(listId);
        return entity.stream().map(el -> modelMapper.map(el, ProductDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/get/{option}")
    List<ProductDto> getProductByOption(@PathVariable JSONObject option) {
        List<ProductEntity> entity = productRepository.findByListOption(option);
        return entity.stream().map(el -> modelMapper.map(el, ProductDto.class)).collect(Collectors.toList());
    }

}