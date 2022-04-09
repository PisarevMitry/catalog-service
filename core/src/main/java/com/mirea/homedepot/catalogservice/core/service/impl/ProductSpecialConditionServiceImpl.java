package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductSpecialConditionEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductSpecialConditionRepository;
import com.mirea.homedepot.catalogservice.core.service.base.ProductSpecialConditionService;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductSpecialConditionDto;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductSpecialConditionDtoDefault;
import com.mirea.homedepot.catalogservice.dto.type.ProductSpecialConditionDtoType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    @Override
    public List<ProductSpecialConditionDto> findAll() {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = productSpecialConditionRepository.findAll();
        return productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductSpecialConditionDto> findAll(ProductSpecialConditionDtoType type) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = productSpecialConditionRepository.findAll();
        List<ProductSpecialConditionDto> productSpecialConditionDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productSpecialConditionDtoList = productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productSpecialConditionDtoList;
    }

    @Override
    public ProductSpecialConditionDto findById(Long productSpecialConditionId) {
        ProductSpecialConditionEntity productSpecialConditionEntity = productSpecialConditionRepository.findById(productSpecialConditionId);
        return modelMapper.map(productSpecialConditionEntity, ProductSpecialConditionDtoDefault.class);
    }

    @Override
    public ProductSpecialConditionDto findById(ProductSpecialConditionDtoType type, Long productSpecialConditionId) {
        ProductSpecialConditionEntity productSpecialConditionEntity = productSpecialConditionRepository.findById(productSpecialConditionId);
        ProductSpecialConditionDto productSpecialConditionDto;
        switch (type) {
            case WITHOUT_PARENT: {
                productSpecialConditionDto = modelMapper.map(productSpecialConditionEntity, ProductSpecialConditionDtoWithoutParent.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productSpecialConditionDto;
    }

    @Override
    public List<ProductSpecialConditionDto> findByListId(List<Long> listId) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = productSpecialConditionRepository.findByListId(listId);
        return productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductSpecialConditionDto> findByListId(ProductSpecialConditionDtoType type, List<Long> listId) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = productSpecialConditionRepository.findByListId(listId);
        List<ProductSpecialConditionDto> productSpecialConditionDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productSpecialConditionDtoList = productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productSpecialConditionDtoList;
    }

    @Override
    public void insert(ProductSpecialConditionDto productSpecialConditionDto) {
        ProductSpecialConditionEntity productSpecialConditionEntity = modelMapper.map(productSpecialConditionDto, ProductSpecialConditionEntity.class);
        if (productSpecialConditionEntity.getId() == null) productSpecialConditionRepository.insert(productSpecialConditionEntity);
        else productSpecialConditionRepository.update(productSpecialConditionEntity);
    }

    @Override
    public void insertList(List<ProductSpecialConditionDto> productSpecialConditionDtoList) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList =
                productSpecialConditionDtoList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionEntity.class)).collect(Collectors.toList());
        productSpecialConditionRepository.insertList(productSpecialConditionEntityList);
    }

    @Override
    public void update(ProductSpecialConditionDto productSpecialConditionDto) {
        ProductSpecialConditionEntity productSpecialConditionEntity = modelMapper.map(productSpecialConditionDto, ProductSpecialConditionEntity.class);
        productSpecialConditionRepository.update(productSpecialConditionEntity);
    }

    @Override
    public void deleteById(Long productSpecialConditionId) {
        productSpecialConditionRepository.deleteById(productSpecialConditionId);
    }

    @Override
    public List<ProductSpecialConditionDto> findListByParentId(Long id) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = productSpecialConditionRepository.findByParentId(id);
        return productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductSpecialConditionDto> findListByParentId(ProductSpecialConditionDtoType type, Long id) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = productSpecialConditionRepository.findByParentId(id);
        List<ProductSpecialConditionDto> productSpecialConditionDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productSpecialConditionDtoList = productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productSpecialConditionDtoList;
    }

    @Override
    public List<ProductSpecialConditionDto> findListRecursiveByParentId(Long id) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = new ArrayList<>();
        ProductSpecialConditionEntity currentProductSpecialConditionEntity;
        ProductSpecialConditionEntity parentProductSpecialConditionEntity;
        Long parentId;

        currentProductSpecialConditionEntity = productSpecialConditionRepository.findById(id);
        parentId = currentProductSpecialConditionEntity.getParentId();
        productSpecialConditionEntityList.add(currentProductSpecialConditionEntity);
        while (parentId != null) {

            parentProductSpecialConditionEntity = productSpecialConditionRepository.findById(parentId);
            productSpecialConditionEntityList.add(parentProductSpecialConditionEntity);
            parentId = parentProductSpecialConditionEntity.getParentId();
        }
        return productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductSpecialConditionDto> findListRecursiveByParentId(ProductSpecialConditionDtoType type, Long id) {
        List<ProductSpecialConditionEntity> productSpecialConditionEntityList = new ArrayList<>();
        ProductSpecialConditionEntity currentProductSpecialConditionEntity;
        ProductSpecialConditionEntity parentProductSpecialConditionEntity;
        Long parentId;

        currentProductSpecialConditionEntity = productSpecialConditionRepository.findById(id);
        parentId = currentProductSpecialConditionEntity.getParentId();
        productSpecialConditionEntityList.add(currentProductSpecialConditionEntity);
        while (parentId != null) {

            parentProductSpecialConditionEntity = productSpecialConditionRepository.findById(parentId);
            productSpecialConditionEntityList.add(parentProductSpecialConditionEntity);
            parentId = parentProductSpecialConditionEntity.getParentId();
        }
        List<ProductSpecialConditionDto> productSpecialConditionDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productSpecialConditionDtoList = productSpecialConditionEntityList.stream().map(el -> modelMapper.map(el, ProductSpecialConditionDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productSpecialConditionDtoList;
    }


}