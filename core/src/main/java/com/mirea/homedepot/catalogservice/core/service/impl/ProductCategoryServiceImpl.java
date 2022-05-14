package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductCategoryEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductCategoryRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductCategoryService;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductCategoryDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductCategoryDtoWithoutParent;
import com.mirea.homedepot.catalogservice.utils.SelectorDto;
import com.mirea.homedepot.catalogservice.utils.SelectorEntity;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.type.ProductCategoryDtoType;
import com.mirea.homedepot.commonmodule.model.Entity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryServiceImpl(
            ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public List<Dto> findAll() {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findAll();
        return SelectorDto.mapFromEntity().select(productCategoryEntityList,
                ProductCategoryDtoDefault.class);
    }

    @Override
    public List<Dto> findAll(ProductCategoryDtoType type) {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findAll();
        List<Dto> productCategoryDtoList;
        if (type == ProductCategoryDtoType.WITHOUT_PARENT) {
            productCategoryDtoList = SelectorDto.mapFromEntity()
                    .select(productCategoryEntityList,
                            ProductCategoryDtoWithoutParent.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDtoList;
    }

    @Override
    public Dto findById(Long productCategoryId) {
        Entity productCategoryEntity =
                productCategoryRepository.findById(productCategoryId);
        return SelectorDto.mapFromEntity()
                .select(productCategoryEntity, ProductCategoryDtoDefault.class);
    }

    @Override
    public Dto findById(ProductCategoryDtoType type, Long productCategoryId) {
        Entity productCategoryEntity =
                productCategoryRepository.findById(productCategoryId);
        Dto productCategoryDto;
        if (type == ProductCategoryDtoType.WITHOUT_PARENT) {
            productCategoryDto = SelectorDto.mapFromEntity()
                    .select(productCategoryEntity,
                            ProductCategoryDtoWithoutParent.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDto;
    }

    @Override
    public List<Dto> findByListId(List<Long> listId) {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findByListId(listId);
        return SelectorDto.mapFromEntity().select(productCategoryEntityList,
                ProductCategoryDtoDefault.class);
    }

    @Override
    public List<Dto> findByListId(ProductCategoryDtoType type,
                                  List<Long> listId) {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findByListId(listId);
        List<Dto> productCategoryDtoList;
        if (type == ProductCategoryDtoType.WITHOUT_PARENT) {
            productCategoryDtoList = SelectorDto.mapFromEntity()
                    .select(productCategoryEntityList,
                            ProductCategoryDtoWithoutParent.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDtoList;
    }

    @Override
    public void insert(Dto productCategoryDto) {
        Entity productCategoryEntity = SelectorEntity.mapFromDto()
                .select(productCategoryDto, ProductCategoryEntity.class);
        if (productCategoryEntity.getId() == null)
            productCategoryRepository.insert(productCategoryEntity);
        else productCategoryRepository.update(productCategoryEntity);
    }

    @Override
    public void insertList(List<Dto> productCategoryDtoList) {
        List<Entity> productCategoryEntityList = SelectorEntity.mapFromDto()
                .select(productCategoryDtoList, ProductCategoryEntity.class);
        productCategoryRepository.insertList(productCategoryEntityList);
    }

    @Override
    public void update(Dto productCategoryDto) {
        Entity productCategoryEntity = SelectorEntity.mapFromDto()
                .select(productCategoryDto, ProductCategoryEntity.class);
        productCategoryRepository.update(productCategoryEntity);
    }

    @Override
    public void deleteById(Long productCategoryId) {
        productCategoryRepository.deleteById(productCategoryId);
    }

    @Override
    public List<Dto> findTreeByParentId(Long id) {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findTreeByParentId(id);
        return SelectorDto.mapFromEntity().select(productCategoryEntityList,
                ProductCategoryDtoDefault.class);
    }

    @Override
    public List<Dto> findTreeByParentId(ProductCategoryDtoType type, Long id) {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findTreeByParentId(id);
        List<Dto> productCategoryDtoList;
        if (type == ProductCategoryDtoType.WITHOUT_PARENT) {
            productCategoryDtoList = SelectorDto.mapFromEntity()
                    .select(productCategoryEntityList,
                            ProductCategoryDtoWithoutParent.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDtoList;
    }

    @Override
    public List<Dto> findTreeIterationByParentId(Long id) {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findTreeIterationByParentId(id);
        return SelectorDto.mapFromEntity().select(productCategoryEntityList,
                ProductCategoryDtoWithoutParent.class);
    }

    @Override
    public List<Dto> findTreeIterationByParentId(ProductCategoryDtoType type,
                                                 Long id) {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findTreeIterationByParentId(id);
        List<Dto> productCategoryDtoList;
        if (type == ProductCategoryDtoType.WITHOUT_PARENT) {
            productCategoryDtoList = SelectorDto.mapFromEntity()
                    .select(productCategoryEntityList,
                            ProductCategoryDtoWithoutParent.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDtoList;
    }

    @Override
    public List<Dto> findTreePathByParentId(Long id) {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findTreePathByParentId(id);
        return SelectorDto.mapFromEntity().select(productCategoryEntityList,
                ProductCategoryDtoWithoutParent.class);
    }

    @Override
    public List<Dto> findTreePathByParentId(ProductCategoryDtoType type,
                                            Long id) {
        List<Entity> productCategoryEntityList =
                productCategoryRepository.findTreePathByParentId(id);
        List<Dto> productCategoryDtoList;
        if (type == ProductCategoryDtoType.WITHOUT_PARENT) {
            productCategoryDtoList = SelectorDto.mapFromEntity()
                    .select(productCategoryEntityList,
                            ProductCategoryDtoWithoutParent.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productCategoryDtoList;
    }
}