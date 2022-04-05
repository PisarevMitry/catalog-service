package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductCategoryEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductCategoryRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductCategoryService;
import com.mirea.homedepot.catalogservice.dto.DtoType;
import com.mirea.homedepot.catalogservice.dto.ProductCategoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//репозитории взаимодействуют с сущностями (получаем всегда одинакового формата), а их уже парсим  в нужный ормат дто

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ModelMapper modelMapper;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ModelMapper modelMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductCategoryDto> findAll(DtoType type) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findAll();
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDto.class)).collect(Collectors.toList());
    }

    public ProductCategoryDto findById(Long productCategoryId) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findById(productCategoryId);
        return modelMapper.map(productCategoryEntity, ProductCategoryDto.class);
    }

    public List<ProductCategoryDto> findByListId(List<Long> listId) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findByListId(listId);
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDto.class)).collect(Collectors.toList());
    }

    public void insert(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity productCategoryEntity = modelMapper.map(productCategoryDto, ProductCategoryEntity.class);
        if (productCategoryEntity.getId() == null) productCategoryRepository.insert(productCategoryEntity);
        else productCategoryRepository.update(productCategoryEntity);
    }

    public void insertList(List<ProductCategoryDto> productCategoryDtoList) {
        List<ProductCategoryEntity> productCategoryEntityList =
                productCategoryDtoList.stream().map(el -> modelMapper.map(el, ProductCategoryEntity.class)).collect(Collectors.toList());
        productCategoryRepository.insertList(productCategoryEntityList);
    }

    public void update(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity productCategoryEntity = modelMapper.map(productCategoryDto, ProductCategoryEntity.class);
        productCategoryRepository.update(productCategoryEntity);
    }

    public void deleteById(Long productCategoryId) {
        productCategoryRepository.deleteById(productCategoryId);
    }

    @Override
    public List<ProductCategoryDto> findListByParentId(Long id) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findByParentId(id);
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductCategoryDto> findRecurListByParentId(Long id) {
        List<ProductCategoryEntity> productCategoryEntityList = new ArrayList<ProductCategoryEntity>();
        ProductCategoryEntity currentProductCategoryEntity;
        ProductCategoryEntity parentProductCategoryEntity;
        Long parentId;

        currentProductCategoryEntity = productCategoryRepository.findById(id);
        parentId = currentProductCategoryEntity.getParentId();
        productCategoryEntityList.add(currentProductCategoryEntity);
        while (parentId != 0) {

            parentProductCategoryEntity = productCategoryRepository.findById(parentId);
            productCategoryEntityList.add(parentProductCategoryEntity);
            parentId = parentProductCategoryEntity.getParentId();
        }
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDto.class)).collect(Collectors.toList());
    }


   /* public Tree<ProductCategoryDto> findTreeByParentId(Long id) {
        Tree<ProductCategoryEntity> productCategoryEntityTree = productCategoryRepository.findTreeByParentId(id);
        return productCategoryEntityTree.stream().map(el -> modelMapper.map(el, ProductCategoryDto.class)).collect(Collectors.toList());
    }*/
}
