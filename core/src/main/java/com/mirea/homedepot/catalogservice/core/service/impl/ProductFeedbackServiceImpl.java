package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductFeedbackEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductFeedbackRepository;
import com.mirea.homedepot.catalogservice.core.service.base.ProductFeedbackService;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductFeedbackDto;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductFeedbackDtoDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<ProductFeedbackDto> findAll() {
        List<ProductFeedbackEntity> productFeedbackEntityList = productFeedbackRepository.findAll();
        return productFeedbackEntityList.stream().map(el -> modelMapper.map(el, ProductFeedbackDtoDefault.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductFeedbackDto findById(Long productFeedbackId) {
        ProductFeedbackEntity productFeedbackEntity = productFeedbackRepository.findById(productFeedbackId);
        return modelMapper.map(productFeedbackEntity, ProductFeedbackDtoDefault.class);
    }

    @Override
    public List<ProductFeedbackDto> findByListId(List<Long> listId) {
        List<ProductFeedbackEntity> productFeedbackEntityList = productFeedbackRepository.findByListId(listId);
        return productFeedbackEntityList.stream().map(el -> modelMapper.map(el, ProductFeedbackDtoDefault.class))
                .collect(Collectors.toList());
    }

    @Override
    public void insert(ProductFeedbackDto productFeedbackDto) {
        ProductFeedbackEntity productFeedbackEntity = modelMapper.map(productFeedbackDto, ProductFeedbackEntity.class);
        if (productFeedbackEntity.getId() == null) productFeedbackRepository.insert(productFeedbackEntity);
        else productFeedbackRepository.update(productFeedbackEntity);
    }

    @Override
    public void insertList(List<ProductFeedbackDto> productFeedbackDtoList) {
        List<ProductFeedbackEntity> productFeedbackEntityList =
                productFeedbackDtoList.stream().map(el -> modelMapper.map(el, ProductFeedbackEntity.class))
                        .collect(Collectors.toList());
        productFeedbackRepository.insertList(productFeedbackEntityList);
    }

    @Override
    public void update(ProductFeedbackDto productFeedbackDto) {
        ProductFeedbackEntity productFeedbackEntity = modelMapper.map(productFeedbackDto, ProductFeedbackEntity.class);
        productFeedbackRepository.update(productFeedbackEntity);
    }

    @Override
    public void deleteById(Long productFeedbackId) {
        productFeedbackRepository.deleteById(productFeedbackId);
    }

    @Override
    public List<ProductFeedbackDto> findListRecursiveByParentId(Long id) {
        List<ProductFeedbackEntity> productFeedbackEntityList = new ArrayList<>();
        ProductFeedbackEntity currentProductFeedbackEntity;
        ProductFeedbackEntity parentProductFeedbackEntity;
        Long parentId;

        currentProductFeedbackEntity = productFeedbackRepository.findById(id);
        parentId = currentProductFeedbackEntity.getParentId();
        productFeedbackEntityList.add(currentProductFeedbackEntity);
        while (parentId != null) {

            parentProductFeedbackEntity = productFeedbackRepository.findById(parentId);
            productFeedbackEntityList.add(parentProductFeedbackEntity);
            parentId = parentProductFeedbackEntity.getParentId();
        }
        return productFeedbackEntityList.stream().map(el -> modelMapper.map(el, ProductFeedbackDtoDefault.class))
                .collect(Collectors.toList());
    }
}
