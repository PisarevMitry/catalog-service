package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductService;
import com.mirea.homedepot.catalogservice.dto.ProductDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductDto> findAll() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        return productEntityList.stream().map(el -> modelMapper.map(el, ProductDto.class)).collect(Collectors.toList());
    }

    public ProductDto findById(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId);
        return modelMapper.map(productEntity, ProductDto.class);
    }

    public List<ProductDto> findByListId(List<Long> listId) {
        List<ProductEntity> productEntityList = productRepository.findByListId(listId);
        return productEntityList.stream().map(el -> modelMapper.map(el, ProductDto.class)).collect(Collectors.toList());
    }

    public void insert(ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        if (productEntity.getId() == null) productRepository.insert(productEntity);
        else productRepository.update(productEntity);
    }

    public void insertList(List<ProductDto> productDtoList) {
        List<ProductEntity> productEntityList = productDtoList.stream().map(el -> modelMapper.map(el, ProductEntity.class)).collect(Collectors.toList());
        productRepository.insertList(productEntityList);
    }

    public void update(ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productRepository.update(productEntity);
    }

    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }


}
