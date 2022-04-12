package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import com.mirea.homedepot.catalogservice.core.model.entity.ProductFeedbackEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductFeedbackRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductFeedbackService;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductFeedbackDtoDefault;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFeedbackServiceImpl implements ProductFeedbackService {

    private final ProductFeedbackRepository productFeedbackRepository;

    private final ModelMapper modelMapper;

    public ProductFeedbackServiceImpl(
            ProductFeedbackRepository productFeedbackRepository,
            ModelMapper modelMapper) {
        this.productFeedbackRepository = productFeedbackRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Dto> findAll() {
        List<Entity> productFeedbackEntityList =
                productFeedbackRepository.findAll();
        return SelectorDto.mapFromEntity().select(productFeedbackEntityList,
                ProductFeedbackDtoDefault.class);
    }

    @Override
    public Dto findById(Long productFeedbackId) {
        Entity productFeedbackEntity =
                productFeedbackRepository.findById(productFeedbackId);
        return SelectorDto.mapFromEntity()
                .select(productFeedbackEntity, ProductFeedbackDtoDefault.class);
    }

    @Override
    public List<Dto> findByListId(List<Long> listId) {
        List<Entity> productFeedbackEntityList =
                productFeedbackRepository.findByListId(listId);
        return SelectorDto.mapFromEntity().select(productFeedbackEntityList,
                ProductFeedbackDtoDefault.class);
    }

    @Override
    public List<Dto> findTreeIterationByParentId(Long id) {
        List<Entity> productFeedbackEntityList =
                productFeedbackRepository.findTreeIterationByParentId(id);
        return SelectorDto.mapFromEntity().select(productFeedbackEntityList,
                ProductFeedbackDtoDefault.class);
    }

    @Override
    public List<Dto> findTreePathByParentId(Long id) {
        List<Entity> productFeedbackEntityList =
                productFeedbackRepository.findTreePathByParentId(id);
        return SelectorDto.mapFromEntity().select(productFeedbackEntityList,
                ProductFeedbackDtoDefault.class);
    }

    @Override
    public void insert(Dto productFeedbackDto) {
        Entity productFeedbackEntity = SelectorEntity.mapFromDto()
                .select(productFeedbackDto, ProductFeedbackEntity.class);
        if (productFeedbackEntity.getId() == null)
            productFeedbackRepository.insert(productFeedbackEntity);
        else productFeedbackRepository.update(productFeedbackEntity);
    }

    @Override
    public void insertList(List<Dto> productFeedbackDtoList) {
        List<Entity> productFeedbackEntityList = SelectorEntity.mapFromDto()
                .select(productFeedbackDtoList, ProductFeedbackEntity.class);
        productFeedbackRepository.insertList(productFeedbackEntityList);
    }

    @Override
    public void update(Dto productFeedbackDto) {
        Entity productFeedbackEntity = SelectorEntity.mapFromDto()
                .select(productFeedbackDto, ProductFeedbackEntity.class);
        productFeedbackRepository.update(productFeedbackEntity);
    }

    @Override
    public void deleteById(Long productFeedbackId) {
        productFeedbackRepository.deleteById(productFeedbackId);
    }
}

