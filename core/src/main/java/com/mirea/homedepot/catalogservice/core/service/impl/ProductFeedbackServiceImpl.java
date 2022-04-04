package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductFeedbackEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductFeedbackRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductFeedbackService;
import com.mirea.homedepot.catalogservice.dto.ProductFeedbackDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductFeedbackServiceImpl implements ProductFeedbackService {

    private final ProductFeedbackRepository productFeedbackRepository;
    private final ModelMapper modelMapper;

    public ProductFeedbackServiceImpl(ProductFeedbackRepository productFeedbackRepository, ModelMapper modelMapper) {
        this.productFeedbackRepository = productFeedbackRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductFeedbackDto> findAll() {
        List<ProductFeedbackEntity> productFeedbackEntityList = productFeedbackRepository.findAll();
        return productFeedbackEntityList.stream().map(el -> modelMapper.map(el, ProductFeedbackDto.class)).collect(Collectors.toList());
    }

    public ProductFeedbackDto findById(Long productFeedbackId) {
        ProductFeedbackEntity productFeedbackEntity = productFeedbackRepository.findById(productFeedbackId);
        return modelMapper.map(productFeedbackEntity, ProductFeedbackDto.class);
    }

    public List<ProductFeedbackDto> findByListId(List<Long> listId) {
        List<ProductFeedbackEntity> productFeedbackEntityList = productFeedbackRepository.findByListId(listId);
        return productFeedbackEntityList.stream().map(el -> modelMapper.map(el, ProductFeedbackDto.class)).collect(Collectors.toList());
    }

    public void insert(ProductFeedbackDto productFeedbackDto) {
        ProductFeedbackEntity productFeedbackEntity = modelMapper.map(productFeedbackDto, ProductFeedbackEntity.class);
        if (productFeedbackEntity.getId() == null) productFeedbackRepository.insert(productFeedbackEntity);
        else productFeedbackRepository.update(productFeedbackEntity);
    }

    public void insertList(List<ProductFeedbackDto> productFeedbackDtoList) {
        List<ProductFeedbackEntity> productFeedbackEntityList = productFeedbackDtoList.stream().map(el -> modelMapper.map(el, ProductFeedbackEntity.class)).collect(Collectors.toList());
        productFeedbackRepository.insertList(productFeedbackEntityList);
    }

    public void update(ProductFeedbackDto productFeedbackDto) {
        ProductFeedbackEntity productFeedbackEntity = modelMapper.map(productFeedbackDto, ProductFeedbackEntity.class);
        productFeedbackRepository.update(productFeedbackEntity);
    }

    public void deleteById(Long productFeedbackId) {
        productFeedbackRepository.deleteById(productFeedbackId);
    }
}
