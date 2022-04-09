package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductPhotoEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductPhotoRepository;
import com.mirea.homedepot.catalogservice.core.service.base.ProductPhotoService;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductPhotoDto;
import com.mirea.homedepot.catalogservice.dto.type.ProductPhotoDtoType;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductPhotoDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductPhotoDtoWithoutParent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {

    private final ProductPhotoRepository productPhotoRepository;
    private final ModelMapper modelMapper;

    public ProductPhotoServiceImpl(ProductPhotoRepository productPhotoRepository, ModelMapper modelMapper) {
        this.productPhotoRepository = productPhotoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductPhotoDto> findAll() {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoRepository.findAll();
        return productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductPhotoDto> findAll(ProductPhotoDtoType type) {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoRepository.findAll();
        List<ProductPhotoDto> productPhotoDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productPhotoDtoList = productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productPhotoDtoList;
    }

    @Override
    public ProductPhotoDto findById(Long productPhotoId) {
        ProductPhotoEntity productPhotoEntity = productPhotoRepository.findById(productPhotoId);
        return modelMapper.map(productPhotoEntity, ProductPhotoDtoDefault.class);
    }

    @Override
    public ProductPhotoDto findById(ProductPhotoDtoType type, Long productPhotoId) {
        ProductPhotoEntity productPhotoEntity = productPhotoRepository.findById(productPhotoId);
        ProductPhotoDto productPhotoDto;
        switch (type) {
            case WITHOUT_PARENT: {
                productPhotoDto = modelMapper.map(productPhotoEntity, ProductPhotoDtoWithoutParent.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productPhotoDto;
    }

    @Override
    public List<ProductPhotoDto> findByListId(List<Long> listId) {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoRepository.findByListId(listId);
        return productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductPhotoDto> findByListId(ProductPhotoDtoType type, List<Long> listId) {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoRepository.findByListId(listId);
        List<ProductPhotoDto> productPhotoDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productPhotoDtoList = productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productPhotoDtoList;
    }

    @Override
    public void insert(ProductPhotoDto productPhotoDto) {
        ProductPhotoEntity productPhotoEntity = modelMapper.map(productPhotoDto, ProductPhotoEntity.class);
        if (productPhotoEntity.getId() == null) productPhotoRepository.insert(productPhotoEntity);
        else productPhotoRepository.update(productPhotoEntity);
    }

    @Override
    public void insertList(List<ProductPhotoDto> productPhotoDtoList) {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoDtoList.stream().map(el -> modelMapper.map(el, ProductPhotoEntity.class)).collect(Collectors.toList());
        productPhotoRepository.insertList(productPhotoEntityList);
    }

    @Override
    public void update(ProductPhotoDto productPhotoDto) {
        ProductPhotoEntity productPhotoEntity = modelMapper.map(productPhotoDto, ProductPhotoEntity.class);
        productPhotoRepository.update(productPhotoEntity);
    }

    @Override
    public void deleteById(Long productPhotoId) {
        productPhotoRepository.deleteById(productPhotoId);
    }

    @Override
    public List<ProductPhotoDto> findListRecursiveByParentId(Long id) {
        List<ProductPhotoEntity> productPhotoEntityList = new ArrayList<>();
        ProductPhotoEntity currentProductPhotoEntity;
        ProductPhotoEntity parentProductPhotoEntity;
        Long parentId;

        currentProductPhotoEntity = productPhotoRepository.findById(id);
        parentId = currentProductPhotoEntity.getParentId();
        productPhotoEntityList.add(currentProductPhotoEntity);
        while (parentId != null) {

            parentProductPhotoEntity = productPhotoRepository.findById(parentId);
            productPhotoEntityList.add(parentProductPhotoEntity);
            parentId = parentProductPhotoEntity.getParentId();
        }
        return productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductPhotoDto> findListRecursiveByParentId(ProductPhotoDtoType type, Long id) {
        List<ProductPhotoEntity> productPhotoEntityList = new ArrayList<>();
        ProductPhotoEntity currentProductPhotoEntity;
        ProductPhotoEntity parentProductPhotoEntity;
        Long parentId;

        currentProductPhotoEntity = productPhotoRepository.findById(id);
        parentId = currentProductPhotoEntity.getParentId();
        productPhotoEntityList.add(currentProductPhotoEntity);
        while (parentId != null) {

            parentProductPhotoEntity = productPhotoRepository.findById(parentId);
            productPhotoEntityList.add(parentProductPhotoEntity);
            parentId = parentProductPhotoEntity.getParentId();
        }
        List<ProductPhotoDto> productPhotoDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productPhotoDtoList = productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productPhotoDtoList;
    }


}


