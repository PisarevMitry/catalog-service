package com.mirea.homedepot.catalogservice.core.service.utils;
/*

import com.mirea.homedepot.catalogservice.core.model.entity.ProductEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductCategoryRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductFeedbackRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductPhotoRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductSpecialConditionRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductCategoryService;
import com.mirea.homedepot.catalogservice.core.service.ProductFeedbackService;
import com.mirea.homedepot.catalogservice.core.service.ProductPhotoService;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFull;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFullSmall;
import com.mirea.homedepot.catalogservice.utils.SelectorDto;
import com.mirea.homedepot.catalogservice.utils.SelectorEntity;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.type.ProductDtoType;
import org.springframework.stereotype.Component;

@Component
public class ProductParser {
    private final ProductCategoryService productCategoryRepository;

    private final ProductFeedbackService productFeedbackRepository;

    private final ProductPhotoService productPhotoRepository;

    private final ProductSpecialConditionRepository
            productSpecialConditionRepository;

    ProductParser(ProductCategoryRepository productCategoryRepository,
                  ProductFeedbackRepository productFeedbackRepository,
                  ProductPhotoRepository productPhotoRepository,
                  ProductRepository productRepository,
                  ProductSpecialConditionRepository productSpecialConditionRepository) {
        this.productCategoryRepository = productCategoryRepository;
        this.productFeedbackRepository = productFeedbackRepository;
        this.productPhotoRepository = productPhotoRepository;
        this.productSpecialConditionRepository =
                productSpecialConditionRepository;
    }

    public void insert(ProductDtoType type, Dto dto) {
        switch (type) {
            case FULL: {
                ProductDtoFull product =
                        (ProductDtoFull) SelectorDto.mapFromDto()
                                .select(dto, ProductDtoFull.class);
                if (product.getFeedbackList() != null) {
                    productFeedbackService.insertList(
                            product.getFeedbackList());
                }
                if (product.getPhotoList() != null) {
                    productPhotoRepository.insertList(product.getPhotoList());
                }
                if (product.getSpecialCondition() != null) {
                    productSpecialConditionRepository.insert(
                            product.getSpecialCondition());
                }
                if (product.getFeedbackList() != null) {
                    productRepository.insert(SelectorEntity.mapFromDto()
                            .select(dto, ProductEntity.class));
                }
            }
            break;
            case FULL_SMALL: {
                productDtoList = EnricherProductDto.enrichFromEntityClass()
                        .select(productEntityList, ProductDtoFullSmall.class);
            }
            case DEFAULT: {
                productDtoList = EnricherProductDto.enrichFromEntityClass()
                        .select(productEntityList, ProductDtoFullSmall.class);
            }
        }
    }
}
*/
