package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import com.mirea.homedepot.catalogservice.core.model.entity.ProductPhotoEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductPhotoRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductPhotoService;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import com.mirea.homedepot.catalogservice.dto.type.ProductPhotoDtoType;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductPhotoDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductPhotoDtoWithoutParent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {

    private final ProductPhotoRepository productPhotoRepository;

    private final ModelMapper modelMapper;

    public ProductPhotoServiceImpl(
            ProductPhotoRepository productPhotoRepository,
            ModelMapper modelMapper) {
        this.productPhotoRepository = productPhotoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Dto> findAll() {
        List<Entity> productPhotoEntityList = productPhotoRepository.findAll();
        return SelectorDto.mapFromEntity()
                .select(productPhotoEntityList, ProductPhotoDtoDefault.class);
    }

    @Override
    public List<Dto> findAll(ProductPhotoDtoType type) {
        List<Entity> productPhotoEntityList = productPhotoRepository.findAll();
        List<Dto> productPhotoDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productPhotoDtoList = SelectorDto.mapFromEntity()
                        .select(productPhotoEntityList,
                                ProductPhotoDtoWithoutParent.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productPhotoDtoList;
    }

    @Override
    public Dto findById(Long productPhotoId) {
        Entity productPhotoEntity =
                productPhotoRepository.findById(productPhotoId);
        return SelectorDto.mapFromEntity()
                .select(productPhotoEntity, ProductPhotoDtoDefault.class);
    }

    @Override
    public Dto findById(ProductPhotoDtoType type, Long productPhotoId) {
        Entity productPhotoEntity =
                productPhotoRepository.findById(productPhotoId);
        Dto productPhotoDto;
        switch (type) {
            case WITHOUT_PARENT: {
                productPhotoDto = SelectorDto.mapFromEntity()
                        .select(productPhotoEntity,
                                ProductPhotoDtoWithoutParent.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productPhotoDto;
    }

    @Override
    public List<Dto> findByListId(List<Long> listId) {
        List<Entity> productPhotoEntityList =
                productPhotoRepository.findByListId(listId);
        return SelectorDto.mapFromEntity()
                .select(productPhotoEntityList, ProductPhotoDtoDefault.class);
    }

    @Override
    public List<Dto> findByListId(ProductPhotoDtoType type, List<Long> listId) {
        List<Entity> productPhotoEntityList =
                productPhotoRepository.findByListId(listId);
        List<Dto> productPhotoDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productPhotoDtoList = SelectorDto.mapFromEntity()
                        .select(productPhotoEntityList,
                                ProductPhotoDtoWithoutParent.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productPhotoDtoList;
    }

    @Override
    public void insert(Dto productPhotoDto) {
        Entity productPhotoEntity = SelectorEntity.mapFromDto()
                .select(productPhotoDto, ProductPhotoEntity.class);
        if (productPhotoEntity.getId() == null)
            productPhotoRepository.insert(productPhotoEntity);
        else productPhotoRepository.update(productPhotoEntity);
    }

    @Override
    public void insertList(List<Dto> productPhotoDtoList) {
        List<Entity> productPhotoEntityList = SelectorEntity.mapFromDto()
                .select(productPhotoDtoList, ProductPhotoEntity.class);
        productPhotoRepository.insertList(productPhotoEntityList);
    }

    @Override
    public void update(Dto productPhotoDto) {
        Entity productPhotoEntity = SelectorEntity.mapFromDto()
                .select(productPhotoDto, ProductPhotoEntity.class);
        productPhotoRepository.update(productPhotoEntity);
    }

    @Override
    public void deleteById(Long productPhotoId) {
        productPhotoRepository.deleteById(productPhotoId);
    }

    @Override
    public List<Dto> findTreeIterationByParentId(Long id) {
        List<Entity> productPhotoEntityList =
                productPhotoRepository.findTreeIterationByParentId(id);
        return SelectorDto.mapFromEntity().select(productPhotoEntityList,
                ProductPhotoDtoWithoutParent.class);
    }

    @Override
    public List<Dto> findTreeIterationByParentId(ProductPhotoDtoType type,
                                                 Long id) {
        List<Entity> productPhotoEntityList =
                productPhotoRepository.findTreeIterationByParentId(id);
        List<Dto> productPhotoDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productPhotoDtoList = SelectorDto.mapFromEntity()
                        .select(productPhotoEntityList,
                                ProductPhotoDtoWithoutParent.class);

            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productPhotoDtoList;
    }

    @Override
    public List<Dto> findTreePathByParentId(Long id) {
        List<Entity> productPhotoEntityList =
                productPhotoRepository.findTreePathByParentId(id);
        return SelectorDto.mapFromEntity().select(productPhotoEntityList,
                ProductPhotoDtoWithoutParent.class);
    }

    @Override
    public List<Dto> findTreePathByParentId(ProductPhotoDtoType type, Long id) {
        List<Entity> productPhotoEntityList =
                productPhotoRepository.findTreePathByParentId(id);
        List<Dto> productPhotoDtoList;
        switch (type) {
            case WITHOUT_PARENT: {
                productPhotoDtoList = SelectorDto.mapFromEntity()
                        .select(productPhotoEntityList,
                                ProductPhotoDtoWithoutParent.class);

            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productPhotoDtoList;
    }

}