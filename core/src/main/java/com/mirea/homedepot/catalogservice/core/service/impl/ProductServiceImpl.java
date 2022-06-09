package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.controller.ProductRequestFilter;
import com.mirea.homedepot.catalogservice.core.model.entity.ProductEntity;
import com.mirea.homedepot.catalogservice.core.model.entity.ProductPhotoEntity;
import com.mirea.homedepot.catalogservice.core.model.entity.ProductSpecialConditionEntity;
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
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductCategoryRepository productCategoryService;

    private final ProductFeedbackRepository productFeedbackService;

    private final ProductPhotoRepository productPhotoService;

    private final ProductRepository productRepository;

    private final ProductSpecialConditionRepository productSpecialConditionService;

    private final ModelMapper modelMapper;

    @Override
    public List<Dto> findAll() {
        List<Entity> productEntityList = productRepository.findAll();
        return SelectorDto.mapFromEntity().select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findAll(ProductDtoType type) {
        List<Entity> productEntityList = productRepository.findAll();
        List<Dto> productDtoList;
        if (type == ProductDtoType.FULL) {
            productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFull.class);
        } else if (type == ProductDtoType.FULL_SMALL) {
            productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFullSmall.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public Dto findById(Long productId) {
        Entity productEntity = productRepository.findById(productId);
        return SelectorDto.mapFromEntity().select(productEntity, ProductDtoDefault.class);
    }

    @Override
    public Dto findById(ProductDtoType type, Long productId) {
        Entity productEntity = productRepository.findById(productId);
        Dto productDto;
        if (type == ProductDtoType.FULL) {
            productDto = EnricherProductDto.enrichFromEntityClass().select(productEntity, ProductDtoFull.class);
        } else if (type == ProductDtoType.FULL_SMALL) {
            productDto = EnricherProductDto.enrichFromEntityClass().select(productEntity, ProductDtoFullSmall.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDto;
    }

    @Override
    public List<Dto> findByListId(List<Long> listId) {
        List<Entity> productEntityList = productRepository.findByListId(listId);
        return SelectorDto.mapFromEntity().select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findByListId(ProductDtoType type, List<Long> listId) {
        List<Entity> productEntityList = productRepository.findByListId(listId);
        List<Dto> productDtoList;
        if (type == ProductDtoType.FULL) {
            productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFull.class);
        } else if (type == ProductDtoType.FULL_SMALL) {
            productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFullSmall.class);
        } else {
            throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public List<Dto> findByCategoryId(Long id) {
        List<Entity> productEntityList = productRepository.findByCategoryId(id);
        return SelectorDto.mapFromEntity().select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findByCategoryId(ProductDtoType type, Long id) {
        List<Entity> productEntityList = productRepository.findByCategoryId(id);
        List<Dto> productDtoList;
        switch (type) {
            case FULL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFull.class);
            }
            break;
            case FULL_SMALL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFullSmall.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public List<Dto> findByListCategoryId(List<Long> listId) {
        List<Entity> productEntityList = productRepository.findByListCategoryId(listId);
        return SelectorDto.mapFromEntity().select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findByListCategoryId(ProductDtoType type, List<Long> listId) {
        List<Entity> productEntityList = productRepository.findByListCategoryId(listId);
        List<Dto> productDtoList;
        switch (type) {
            case FULL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFull.class);
            }
            break;
            case FULL_SMALL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFullSmall.class);
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
        return SelectorDto.mapFromEntity().select(productEntityList, ProductDtoDefault.class);
    }

    @Override
    public List<Dto> findByOption(ProductDtoType type, JSONObject option) {
        List<Entity> productEntityList = productRepository.findByOption(option);
        List<Dto> productDtoList;
        switch (type) {
            case FULL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFull.class);
            }
            break;
            case FULL_SMALL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass().select(productEntityList, ProductDtoFullSmall.class);
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public void insert(Dto productDto) {
        Entity productEntity = SelectorEntity.mapFromDto().select(productDto, ProductEntity.class);
        if (productEntity.getId() == null) {
            productRepository.insert(productEntity);
        } else {
            productRepository.update(productEntity);
        }
    }

    @Override
    public void insert(ProductRequestFilter requestFilter) {
        if (requestFilter.getProductDtoDefault() != null) {
            insert(requestFilter.getProductDtoDefault());
        } else if (requestFilter.getProductDtoFullSmall() != null) {

            ProductDtoFullSmall productDtoFullSmall = requestFilter.getProductDtoFullSmall();
            ProductEntity productEntity = (ProductEntity) SelectorEntity.mapFromDto().select(productDtoFullSmall, ProductEntity.class);

            productSpecialConditionService.insert(SelectorEntity.mapFromDto()
                .select(requestFilter.getProductDtoFullSmall().getSpecialCondition(), ProductSpecialConditionEntity.class));
            productEntity.setSpecialConditionId(
                productSpecialConditionService.findAll().get(productSpecialConditionService.findAll().size() - 1).getId());

            productPhotoService.insert(
                SelectorEntity.mapFromDto().select(requestFilter.getProductDtoFullSmall().getPhoto(), ProductPhotoEntity.class));
            productEntity.setPhotoId(
                productPhotoService.findAll().get(productPhotoService.findAll().size() - 1).getId());
            System.out.println(productPhotoService.findAll().get(productPhotoService.findAll().size() - 1).getId());

            productRepository.insert(productEntity);
        } else if (requestFilter.getProductDtoFull() != null) {
          /*  ProductDtoFull productDtoFull = requestFilter.getProductDtoFull();
            productSpecialConditionService.insert(SelectorEntity.mapFromDto()
                .select(requestFilter.getProductDtoFullSmall().getSpecialCondition(), ProductSpecialConditionEntity.class));

            List<ProductPhotoDtoDefault> photoList =
                productDtoFull.getPhotoList().stream().map(t -> modelMapper.map(t, ProductPhotoDtoDefault.class)).collect(Collectors.toList());
            photoList
            List<Entity> productPhotoEntityList = SelectorEntity.mapFromDto().select(productDtoFull.getPhotoList(), ProductPhotoEntity.class);
            productPhotoService.insertList(productPhotoEntityList);
            productCategoryService.insert(
                SelectorEntity.mapFromDto().select(requestFilter.getProductDtoFull().getCategory(), ProductCategoryEntity.class));
            productFeedbackService.insertList(
                SelectorEntity.mapFromDto().select(requestFilter.getProductDtoFull().getFeedbackList(), ProductFeedbackEntity.class));
        */
        }
    }

    @Override
    public void insertList(List<Dto> productDtoList) {
        List<Entity> productEntityList = SelectorEntity.mapFromDto().select(productDtoList, ProductEntity.class);
        productRepository.insertList(productEntityList);
    }

    @Override
    public void update(Dto productDto) {
        Entity productEntity = SelectorEntity.mapFromDto().select(productDto, ProductEntity.class);
        productRepository.update(productEntity);
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

}

