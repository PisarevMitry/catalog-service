package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductCategoryEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductCategoryRepository;
import com.mirea.homedepot.catalogservice.core.service.base.ProductCategoryService;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductCategoryDto;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductCategoryDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductCategoryDtoWithoutParent;
import com.mirea.homedepot.catalogservice.dto.type.ProductCategoryDtoType;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ModelMapper modelMapper;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ModelMapper modelMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ProductCategoryDto> findAll() {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findAll();
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductCategoryDto> findAll(ProductCategoryDtoType type) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findAll();
        List<ProductCategoryDto> productCategoryDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productCategoryDtoList = productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDtoList;
    }

    @Override
    public ProductCategoryDto findById(Long productCategoryId) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findById(productCategoryId);
        return modelMapper.map(productCategoryEntity, ProductCategoryDtoDefault.class);
    }

    @Override
    public ProductCategoryDto findById(ProductCategoryDtoType type, Long productCategoryId) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findById(productCategoryId);
        ProductCategoryDto productCategoryDto;
        switch (type) {
            case WITHOUT_PARENT: {
                productCategoryDto = modelMapper.map(productCategoryEntity, ProductCategoryDtoWithoutParent.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDto;
    }

    @Override
    public List<ProductCategoryDto> findByListId(List<Long> listId) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findByListId(listId);
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductCategoryDto> findByListId(ProductCategoryDtoType type, List<Long> listId) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findByListId(listId);
        List<ProductCategoryDto> productCategoryDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productCategoryDtoList = productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDtoList;
    }

    @Override
    public void insert(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity productCategoryEntity = modelMapper.map(productCategoryDto, ProductCategoryEntity.class);
        if (productCategoryEntity.getId() == null) productCategoryRepository.insert(productCategoryEntity);
        else productCategoryRepository.update(productCategoryEntity);
    }

    @Override
    public void insertList(List<ProductCategoryDto> productCategoryDtoList) {
        List<ProductCategoryEntity> productCategoryEntityList =
                productCategoryDtoList.stream().map(el -> modelMapper.map(el, ProductCategoryEntity.class)).collect(Collectors.toList());
        productCategoryRepository.insertList(productCategoryEntityList);
    }

    @Override
    public void update(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity productCategoryEntity = modelMapper.map(productCategoryDto, ProductCategoryEntity.class);
        productCategoryRepository.update(productCategoryEntity);
    }

    @Override
    public void deleteById(Long productCategoryId) {
        productCategoryRepository.deleteById(productCategoryId);
    }

    @Override
    public List<ProductCategoryDto> findListByParentId(Long id) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findByParentId(id);
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductCategoryDto> findListByParentId(ProductCategoryDtoType type, Long id) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findByParentId(id);
        List<ProductCategoryDto> productCategoryDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productCategoryDtoList = productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDtoList;
    }

    @Override
    public List<ProductCategoryDto> findListRecursiveByParentId(Long id) {
        List<ProductCategoryEntity> productCategoryEntityList = new ArrayList<>();
        ProductCategoryEntity currentProductCategoryEntity;
        ProductCategoryEntity parentProductCategoryEntity;
        Long parentId;

        currentProductCategoryEntity = productCategoryRepository.findById(id);
        parentId = currentProductCategoryEntity.getParentId();
        productCategoryEntityList.add(currentProductCategoryEntity);
        while (parentId != null) {

            parentProductCategoryEntity = productCategoryRepository.findById(parentId);
            productCategoryEntityList.add(parentProductCategoryEntity);
            parentId = parentProductCategoryEntity.getParentId();
        }
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDtoDefault.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductCategoryDto> findListRecursiveByParentId(ProductCategoryDtoType type, Long id) {
        List<ProductCategoryEntity> productCategoryEntityList = new ArrayList<>();
        ProductCategoryEntity currentProductCategoryEntity;
        ProductCategoryEntity parentProductCategoryEntity;
        Long parentId;

        currentProductCategoryEntity = productCategoryRepository.findById(id);
        parentId = currentProductCategoryEntity.getParentId();
        productCategoryEntityList.add(currentProductCategoryEntity);
        while (parentId != null) {

            parentProductCategoryEntity = productCategoryRepository.findById(parentId);
            productCategoryEntityList.add(parentProductCategoryEntity);
            parentId = parentProductCategoryEntity.getParentId();
        }
        List<ProductCategoryDto> productCategoryDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productCategoryDtoList = productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDtoWithoutParent.class)).collect(Collectors.toList());
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDtoList;
    }

   /* public Tree<ProductCategoryDto> findTreeByParentId(Long id) {
        Tree<ProductCategoryEntity> productCategoryEntityTree = productCategoryRepository.findTreeByParentId(id);
        return productCategoryEntityTree.stream().map(el -> modelMapper.map(el, ProductCategoryDto.class)).collect(Collectors.toList());
    }*/
}

