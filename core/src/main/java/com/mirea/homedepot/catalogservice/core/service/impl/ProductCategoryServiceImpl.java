package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductCategoryEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductCategoryRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductCategoryService;
import com.mirea.homedepot.catalogservice.dto.ProductCategoryDto;
import com.mirea.homedepot.catalogservice.dto.ProductCategoryTreeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//репозитории взаимодействуют с сущностями (получаем всегда одинакового формата), а их уже парсим  в нужный ормат дто

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ModelMapper modelMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductCategoryDto> findAll() {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findAll();
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDto findById(Long id) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findById(id);
        return modelMapper.map(productCategoryEntity, ProductCategoryDto.class);
    }

    @Override
    public List<ProductCategoryDto> findByListId(List<Long> listId) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findByListId(listId);
        return null;
    }

    @Override
    public void insert(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity productCategoryEntity = modelMapper.map(productCategoryDto, ProductCategoryEntity.class);
        if (ProductCategoryEntity.getId() == null)
            productCategoryRepository.insert(productCategoryEntity);
        else
            productCategoryRepository.updateById(productCategoryEntity);
    }

    @Override
    public void insertAll(List<ProductCategoryDto> productCategoryDtoList) {
        List<ProductCategoryEntity> productCategoryEntityList =
                productCategoryDtoList.stream().map(el -> modelMapper.map(el, ProductCategoryEntity.class)).collect(Collectors.toList());
        productCategoryRepository.insertAll(productCategoryEntityList);
    }

    @Override
    public void updateById(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity productCategoryEntity = modelMapper.map(productCategoryDto, ProductCategoryEntity.class);
        productCategoryRepository.updateById(productCategoryEntity);
    }

    @Override
    public void deleteById(Long id) {
        productCategoryRepository.deleteById(id);
    }


    public List<ProductCategoryDto> findListByParentId(Long id);

    public ProductCategoryTreeDto findTreeByParentId(Long id);
}
