package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductSpecialConditionEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductSpecialConditionRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductSpecialConditionService;
import com.mirea.homedepot.catalogservice.dto.ProductSpecialConditionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSpecialConditionServiceImpl implements ProductSpecialConditionService {

    private final ProductSpecialConditionRepository productSpecialConditionRepository;
    private final ModelMapper modelMapper;

    public ProductSpecialConditionServiceImpl(ProductSpecialConditionRepository productSpecialConditionRepository, ModelMapper modelMapper) {
        this.productSpecialConditionRepository = productSpecialConditionRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductSpecialConditionDto> findAll() {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = productSpecialConditionRepository.findAll();
        return productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDto.class)).collect(Collectors.toList());
    }

    public ProductSpecialConditionDto findById(Long productSpecialConditionId) {
        ProductSpecialConditionEntity productSpecialConditionEntity = productSpecialConditionRepository.findById(productSpecialConditionId);
        return modelMapper.map(productSpecialConditionEntity, ProductSpecialConditionDto.class);
    }

    public List<ProductSpecialConditionDto> findByListId(List<Long> listId) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = productSpecialConditionRepository.findByListId(listId);
        return productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDto.class)).collect(Collectors.toList());
    }

    public void insert(ProductSpecialConditionDto productSpecialConditionDto) {
        ProductSpecialConditionEntity productSpecialConditionEntity = modelMapper.map(productSpecialConditionDto, ProductSpecialConditionEntity.class);
        if (productSpecialConditionEntity.getId() == null) productSpecialConditionRepository.insert(productSpecialConditionEntity);
        else productSpecialConditionRepository.update(productSpecialConditionEntity);
    }

    public void insertList(List<ProductSpecialConditionDto> productSpecialConditionDtoList) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList =
                productSpecialConditionDtoList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionEntity.class)).collect(Collectors.toList());
        productSpecialConditionRepository.insertList(productSpecialConditionEntityList);
    }

    public void update(ProductSpecialConditionDto productSpecialConditionDto) {
        ProductSpecialConditionEntity productSpecialConditionEntity = modelMapper.map(productSpecialConditionDto, ProductSpecialConditionEntity.class);
        productSpecialConditionRepository.update(productSpecialConditionEntity);
    }

    public void deleteById(Long productSpecialConditionId) {
        productSpecialConditionRepository.deleteById(productSpecialConditionId);
    }


}

