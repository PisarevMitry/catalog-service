package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductPhotoEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductPhotoRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductPhotoService;
import com.mirea.homedepot.catalogservice.dto.ProductPhotoDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPhotoServiceImpl implements ProductPhotoService {

    private final ProductPhotoRepository productPhotoRepository;
    private final ModelMapper modelMapper;

    public ProductPhotoServiceImpl(ProductPhotoRepository productPhotoRepository, ModelMapper modelMapper) {
        this.productPhotoRepository = productPhotoRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductPhotoDto> findAll() {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoRepository.findAll();
        return productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDto.class)).collect(Collectors.toList());
    }

    public ProductPhotoDto findById(Long productPhotoId) {
        ProductPhotoEntity productPhotoEntity = productPhotoRepository.findById(productPhotoId);
        return modelMapper.map(productPhotoEntity, ProductPhotoDto.class);
    }

    public List<ProductPhotoDto> findByListId(List<Long> listId) {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoRepository.findByListId(listId);
        return productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDto.class)).collect(Collectors.toList());
    }

    public void insert(ProductPhotoDto productPhotoDto) {
        ProductPhotoEntity productPhotoEntity = modelMapper.map(productPhotoDto, ProductPhotoEntity.class);
        if (productPhotoEntity.getId() == null) productPhotoRepository.insert(productPhotoEntity);
        else productPhotoRepository.update(productPhotoEntity);
    }

    public void insertList(List<ProductPhotoDto> productPhotoDtoList) {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoDtoList.stream().map(el -> modelMapper.map(el, ProductPhotoEntity.class)).collect(Collectors.toList());
        productPhotoRepository.insertList(productPhotoEntityList);
    }

    public void update(ProductPhotoDto productPhotoDto) {
        ProductPhotoEntity productPhotoEntity = modelMapper.map(productPhotoDto, ProductPhotoEntity.class);
        productPhotoRepository.update(productPhotoEntity);
    }

    public void deleteById(Long productPhotoId) {
        productPhotoRepository.deleteById(productPhotoId);
    }


}
