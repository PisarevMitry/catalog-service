package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductCategoryRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductFeedbackRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductPhotoRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductSpecialConditionRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductService;
import com.mirea.homedepot.catalogservice.core.service.utils.EnricherProductDto;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFull;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFullSmall;
import com.mirea.homedepot.catalogservice.utils.SelectorDto;
import com.mirea.homedepot.catalogservice.utils.SelectorEntity;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.type.ProductDtoType;
import com.mirea.homedepot.commonmodule.model.Entity;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductCategoryRepository productCategoryRepository;

    private final ProductFeedbackRepository productFeedbackRepository;

    private final ProductPhotoRepository productPhotoRepository;

    private final ProductRepository productRepository;

    private final ProductSpecialConditionRepository
            productSpecialConditionRepository;

    public ProductServiceImpl(
            ProductCategoryRepository productCategoryRepository,
            ProductFeedbackRepository productFeedbackRepository,
            ProductPhotoRepository productPhotoRepository,
            ProductRepository productRepository,
            ProductSpecialConditionRepository productSpecialConditionRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.productFeedbackRepository = productFeedbackRepository;
        this.productPhotoRepository = productPhotoRepository;
        this.productRepository = productRepository;
        this.productSpecialConditionRepository =
                productSpecialConditionRepository;
    }

    @Override
    public List<Dto> findAll() {
        List<Entity> productEntityList = productRepository.findAll();
        return SelectorDto.mapFromEntity()
                .select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findAll(ProductDtoType type) {
        List<Entity> productEntityList = productRepository.findAll();
        List<Dto> productDtoList;
        if (type == ProductDtoType.FULL) {
            productDtoList = EnricherProductDto.enrichFromEntityClass()
                    .select(productEntityList, ProductDtoFull.class);
        } else if (type == ProductDtoType.FULL_SMALL) {
            productDtoList = EnricherProductDto.enrichFromEntityClass()
                    .select(productEntityList, ProductDtoFullSmall.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public Dto findById(Long productId) {
        Entity productEntity = productRepository.findById(productId);
        return SelectorDto.mapFromEntity()
                .select(productEntity, ProductDtoDefault.class);
    }

    @Override
    public Dto findById(ProductDtoType type, Long productId) {
        Entity productEntity = productRepository.findById(productId);
        Dto productDto;
        if (type == ProductDtoType.FULL) {
            productDto = EnricherProductDto.enrichFromEntityClass()
                    .select(productEntity, ProductDtoFull.class);
        } else if (type == ProductDtoType.FULL_SMALL) {
            productDto = EnricherProductDto.enrichFromEntityClass()
                    .select(productEntity, ProductDtoFullSmall.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDto;
    }

    @Override
    public List<Dto> findByListId(List<Long> listId) {
        List<Entity> productEntityList = productRepository.findByListId(listId);
        return SelectorDto.mapFromEntity()
                .select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findByListId(ProductDtoType type, List<Long> listId) {
        List<Entity> productEntityList = productRepository.findByListId(listId);
        List<Dto> productDtoList;
        if (type == ProductDtoType.FULL) {
            productDtoList = EnricherProductDto.enrichFromEntityClass()
                    .select(productEntityList, ProductDtoFull.class);
        } else if (type == ProductDtoType.FULL_SMALL) {
            productDtoList = EnricherProductDto.enrichFromEntityClass()
                    .select(productEntityList, ProductDtoFullSmall.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public List<Dto> findByCategoryId(Long id) {
        List<Entity> productEntityList = productRepository.findByCategoryId(id);
        return SelectorDto.mapFromEntity()
                .select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findByCategoryId(ProductDtoType type, Long id) {
        List<Entity> productEntityList = productRepository.findByCategoryId(id);
        List<Dto> productDtoList;
        switch (type) {
            case FULL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass()
                        .select(productEntityList, ProductDtoFull.class);
            }
            break;
            case FULL_SMALL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass()
                        .select(productEntityList, ProductDtoFullSmall.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public List<Dto> findByListCategoryId(List<Long> listId) {
        List<Entity> productEntityList =
                productRepository.findByListCategoryId(listId);
        return SelectorDto.mapFromEntity()
                .select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findByListCategoryId(ProductDtoType type,
                                          List<Long> listId) {
        List<Entity> productEntityList =
                productRepository.findByListCategoryId(listId);
        List<Dto> productDtoList;
        switch (type) {
            case FULL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass()
                        .select(productEntityList, ProductDtoFull.class);
            }
            break;
            case FULL_SMALL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass()
                        .select(productEntityList, ProductDtoFullSmall.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public List<Dto> findByOption(JSONObject option) {
        List<Entity> productEntityList = productRepository.findByOption(option);
        return SelectorDto.mapFromEntity()
                .select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findByOption(ProductDtoType type, JSONObject option) {
        List<Entity> productEntityList = productRepository.findByOption(option);
        List<Dto> productDtoList;
        switch (type) {
            case FULL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass()
                        .select(productEntityList, ProductDtoFull.class);
            }
            break;
            case FULL_SMALL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass()
                        .select(productEntityList, ProductDtoFullSmall.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public void insert(Dto productDto) {
        Entity productEntity = SelectorEntity.mapFromDto()
                .select(productDto, ProductEntity.class);
        if (productEntity.getId() == null) {
            productRepository.insert(productEntity);
        } else {
            productRepository.update(productEntity);
        }
    }

    @Override
    public void insertList(List<Dto> productDtoList) {
        List<Entity> productEntityList = SelectorEntity.mapFromDto()
                .select(productDtoList, ProductEntity.class);
        productRepository.insertList(productEntityList);
    }

    @Override
    public void update(Dto productDto) {
        Entity productEntity = SelectorEntity.mapFromDto()
                .select(productDto, ProductEntity.class);
        productRepository.update(productEntity);
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

}

