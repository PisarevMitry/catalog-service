package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import com.mirea.homedepot.catalogservice.core.model.entity.ProductEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductCategoryRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductFeedbackRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductPhotoRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductSpecialConditionRepository;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductCategoryDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductFeedbackDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductPhotoDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductSpecialConditionDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFull;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFullSmall;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class EnricherProductDto implements EnricherProduct {

    private static EnricherProductDtoMapper enricherFromDtoClass;

    private static EnricherProductDtoMapper enricherFromEntityClass;

    public EnricherProductDto(
            ProductCategoryRepository productCategoryRepository,
            ProductFeedbackRepository productFeedbackRepository,
            ProductPhotoRepository productPhotoRepository,
            ProductRepository productRepository,
            ProductSpecialConditionRepository productSpecialConditionRepository) {
        enricherFromEntityClass =
                new EnricherProductDtoMapper(productCategoryRepository,
                        productFeedbackRepository, productPhotoRepository,
                        productRepository, productSpecialConditionRepository);
        enricherFromDtoClass =
                new EnricherProductDtoMapper(productCategoryRepository,
                        productFeedbackRepository, productPhotoRepository,
                        productRepository, productSpecialConditionRepository);
    }

    public static EnricherProductDtoMapper enrichFromDtoClass() {
        return enricherFromDtoClass;
    }

    public static EnricherProductDtoMapper enrichFromEntityClass() {
        return enricherFromEntityClass;
    }

    static class EnricherProductDtoMapper {
        private final ProductCategoryRepository productCategoryRepository;

        private final ProductFeedbackRepository productFeedbackRepository;

        private final ProductPhotoRepository productPhotoRepository;

        private final ProductSpecialConditionRepository
                productSpecialConditionRepository;

        EnricherProductDtoMapper(
                ProductCategoryRepository productCategoryRepository,
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

        public Dto select(Dto dto, Class<? extends Dto> resultClass) {
            return enrich(dto, resultClass);
        }

        public Dto select(Entity entity, Class<? extends Dto> resultClass) {
            return enrich(entity, resultClass);
        }

        public List<Dto> select(List<Entity> list,
                                Class<? extends Dto> resultClass) {
            return list.stream().map(el -> enrich(el, resultClass))
                    .collect(Collectors.toList());
        }

        private Dto enrich(Dto dto, Class<? extends Dto> resultClass) {
            if (Objects.equals(resultClass, ProductDtoFull.class)) {
                return enrichToFull((ProductDtoDefault) dto);
            } else if (Objects.equals(resultClass, ProductDtoFullSmall.class)) {
                return enrichToFullSmall((ProductDtoDefault) dto);
            } else {
                throw new IllegalStateException("Да будет пиздец");
                ///return null;
            }
        }

        private Dto enrich(Entity entity, Class<? extends Dto> resultClass) {
            if (Objects.equals(resultClass, ProductDtoFull.class)) {
                return enrichToFull((ProductEntity) entity);
            } else if (Objects.equals(resultClass, ProductDtoFullSmall.class)) {
                return enrichToFullSmall((ProductEntity) entity);
            } else {
                throw new IllegalStateException("Да будет пиздец");
                //return null;
            }
        }

        private Dto enrichToFull(ProductEntity entity) {

            List<Entity> photoList =
                    productPhotoRepository.findTreePathByParentId(
                            entity.getPhotoId());

            List<Entity> feedbackList =
                    productFeedbackRepository.findTreePathByParentId(
                            entity.getFeedbackId());
            Entity category =
                    productCategoryRepository.findById(entity.getCategoryId());
            Entity specialCondition =
                    productSpecialConditionRepository.findById(
                            entity.getSpecialConditionId());

            return new ProductDtoFull(
                    (ProductDtoDefault) SelectorDto.mapFromEntity()
                            .select(entity, ProductDtoDefault.class),
                    SelectorDto.mapFromEntity()
                            .select(photoList, ProductPhotoDtoDefault.class),
                    SelectorDto.mapFromEntity()
                            .select(category, ProductCategoryDtoDefault.class),
                    SelectorDto.mapFromEntity().select(feedbackList,
                            ProductFeedbackDtoDefault.class),
                    SelectorDto.mapFromEntity().select(specialCondition,
                            ProductSpecialConditionDtoDefault.class));
        }

        private Dto enrichToFull(ProductDtoDefault dto) {

            List<Entity> photoList =
                    productPhotoRepository.findTreePathByParentId(
                            dto.getPhotoId());

            List<Entity> feedbackList =
                    productFeedbackRepository.findTreePathByParentId(
                            dto.getFeedbackId());
            Entity category =
                    productCategoryRepository.findById(dto.getCategoryId());
            Entity specialCondition =
                    productSpecialConditionRepository.findById(
                            dto.getSpecialConditionId());

            return new ProductDtoFull(dto, SelectorDto.mapFromEntity()
                    .select(photoList, ProductPhotoDtoDefault.class),
                    SelectorDto.mapFromEntity()
                            .select(category, ProductCategoryDtoDefault.class),
                    SelectorDto.mapFromEntity().select(feedbackList,
                            ProductFeedbackDtoDefault.class),
                    SelectorDto.mapFromEntity().select(specialCondition,
                            ProductSpecialConditionDtoDefault.class));
        }

        private Dto enrichToFullSmall(ProductDtoDefault dto) {
            Entity photo = productPhotoRepository.findById(dto.getPhotoId());
            Entity specialCondition =
                    productSpecialConditionRepository.findById(
                            dto.getSpecialConditionId());

            return new ProductDtoFullSmall(dto, SelectorDto.mapFromEntity()
                    .select(photo, ProductPhotoDtoDefault.class),
                    SelectorDto.mapFromEntity().select(specialCondition,
                            ProductSpecialConditionDtoDefault.class));
        }

        private Dto enrichToFullSmall(ProductEntity entity) {
            Entity photo = productPhotoRepository.findById(entity.getPhotoId());
            Entity specialCondition =
                    productSpecialConditionRepository.findById(
                            entity.getSpecialConditionId());

            return new ProductDtoFullSmall(
                    (ProductDtoDefault) SelectorDto.mapFromEntity()
                            .select(entity, ProductDtoDefault.class),
                    SelectorDto.mapFromEntity()
                            .select(photo, ProductPhotoDtoDefault.class),
                    SelectorDto.mapFromEntity().select(specialCondition,
                            ProductSpecialConditionDtoDefault.class));
        }

    }

}