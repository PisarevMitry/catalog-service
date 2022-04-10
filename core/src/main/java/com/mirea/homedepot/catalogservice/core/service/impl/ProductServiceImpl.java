package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.Entity;
import com.mirea.homedepot.catalogservice.core.model.entity.ProductEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductCategoryRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductFeedbackRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductRepository;
import com.mirea.homedepot.catalogservice.core.repository.ProductSpecialConditionRepository;
import com.mirea.homedepot.catalogservice.core.service.base.ProductCategoryService;
import com.mirea.homedepot.catalogservice.core.service.base.ProductFeedbackService;
import com.mirea.homedepot.catalogservice.core.service.base.ProductPhotoService;
import com.mirea.homedepot.catalogservice.core.service.base.ProductService;
import com.mirea.homedepot.catalogservice.core.service.base.ProductSpecialConditionService;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import com.mirea.homedepot.catalogservice.dto.abstractive.ProductDto;
import com.mirea.homedepot.catalogservice.dto.type.ProductDtoType;
import com.mirea.homedepot.catalogservice.dto.type.ProductPhotoDtoType;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductFeedbackDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductSpecialConditionDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFull;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductDtoFullSmall;
import liquibase.pro.packaged.E;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductFeedbackRepository productFeedbackRepository;
    private final ProductPhotoServiceImpl productPhotoService;
    private final ProductRepository productRepository;
    private final ProductSpecialConditionRepository productSpecialConditionRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductCategoryRepository productCategoryRepository,
                              ProductFeedbackRepository productFeedbackRepository,
                              ProductPhotoServiceImpl productPhotoService, ProductRepository productRepository,
                              ProductSpecialConditionRepository productSpecialConditionRepository,
                              ModelMapper modelMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.productFeedbackRepository = productFeedbackRepository;
        this.productPhotoService = productPhotoService;
        this.productRepository = productRepository;
        this.productSpecialConditionRepository = productSpecialConditionRepository;
        this.modelMapper = modelMapper;
    }

    static class EnricherProductDto<D> {

        ProductCategoryService productCategoryService;
        ProductFeedbackService productFeedbackService;
        ProductPhotoService productPhotoService;
        ProductService productService;
        ProductSpecialConditionService productSpecialConditionService;

        private ModelMapper modelMapper;

        private Entity entity;

        private Dto dto;

        public EnricherProductDto(ModelMapper modelMapper, Entity entity) {
            this.modelMapper = modelMapper;
            this.entity = entity;
        }

        public EnricherProductDto(ModelMapper modelMapper, Dto dto) {
            this.modelMapper = modelMapper;
            this.dto = dto;
        }

        public Dto selector(ProductDtoType type) {
            switch (type) {
                case DEFAULT:
                    return mapToProductDtoDefault();
                break;
                case FULL:
                    return mapToProductDtoFull();
                break;
                case FULL_SMALL:
                    return mapToProductDtoFullSmall();
                break;

            }
        }

        private Dto mapToProductDtoDefault() {
        }

        Dto mapToProductDtoFull(ProductEntity productEntity) {

            Dto productDtoFull = new ProductDtoFull(modelMapper.map(productEntity, ProductDtoDefault.class),
                    productPhotoService.findListRecursiveByParentId(ProductPhotoDtoType.WITHOUT_PARENT,
                            productEntity.getPhotoId()),
                    productFeedbackRepository.findByParentId(productEntity.getFeedbackId()).stream()
                            .map(el -> modelMapper.map(el, ProductFeedbackDtoDefault.class))
                            .collect(Collectors.toList()),
                    modelMapper.map(productSpecialConditionRepository.findById(productEntity.getSpecialConditionId()),
                            ProductSpecialConditionDtoDefault.class));
            return productDtoFull;

        }

        ProductDtoFullSmall mapToProductDtoFullSmall(ProductEntity productEntity) {
            return new ProductDtoFullSmall(modelMapper.map(productEntity, ProductDtoDefault.class),
                    productPhotoService.findById(ProductPhotoDtoType.WITHOUT_PARENT, productEntity.getPhotoId()),
                    modelMapper.map(productSpecialConditionRepository.findById(productEntity.getSpecialConditionId()),
                            ProductSpecialConditionDtoDefault.class));
        }

        List<Dto> mapToList(List<E> list) {

        }

        Dto getPhoto(Long id) {
            return productPhotoService.findById(ProductPhotoDtoType.WITHOUT_PARENT, productEntity.getPhotoId()),
        }

        List<Dto> getListPhoto(Long id){

        }

    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        return productEntityList.stream().map(el -> modelMapper.map(el, ProductDtoDefault.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long productId) {
        ProductEntity productEntity = productRepository.findById(productId);
        return modelMapper.map(productEntity, ProductDtoDefault.class);
    }

    @Override
    public List<ProductDto> findByListId(List<Long> listId) {
        List<ProductEntity> productEntityList = productRepository.findByListId(listId);
        return productEntityList.stream().map(el -> modelMapper.map(el, ProductDtoDefault.class))
                .collect(Collectors.toList());
    }

    @Override
    public void insert(ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        if (productEntity.getId() == null) productRepository.insert(productEntity);
        else productRepository.update(productEntity);
    }

    @Override
    public void insertList(List<ProductDto> productDtoList) {
        List<ProductEntity> productEntityList =
                productDtoList.stream().map(el -> modelMapper.map(el, ProductEntity.class))
                        .collect(Collectors.toList());
        productRepository.insertList(productEntityList);
    }

    @Override
    public void update(ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productRepository.update(productEntity);
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<ProductDto> findAll(ProductDtoType type) {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<ProductDto> productDtoList;
        switch (type) {
            case FULL:
                productDtoList = productEntityList.stream().map(el -> mapFromProductDtoDefaultToProductDtoFull(el))
                        .collect(Collectors.toList());
                break;
            case FULL_SMALL:
                productDtoList = productEntityList.stream().map(el -> mapFromProductDtoDefaultToProductDtoFullSmall(el))
                        .collect(Collectors.toList());

                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public ProductDto findById(ProductDtoType type, Long productId) {
        ProductEntity productEntity = productRepository.findById(productId);
        ProductDto productDto;
        switch (type) {
            case FULL:
                productDto = mapFromProductDtoDefaultToProductDtoFull(productEntity);
                break;
            case FULL_SMALL:
                productDto = mapFromProductDtoDefaultToProductDtoFullSmall(productEntity);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDto;
    }

    @Override
    public List<ProductDto> findByListId(ProductDtoType type, List<Long> listId) {
        List<ProductEntity> productEntityList = productRepository.findByListId(listId);
        List<ProductDto> productDtoList;
        switch (type) {
            case FULL:
                productDtoList = productEntityList.stream().map(el -> mapFromProductDtoDefaultToProductDtoFull(el))
                        .collect(Collectors.toList());
                break;
            case FULL_SMALL:
                productDtoList = productEntityList.stream().map(el -> mapFromProductDtoDefaultToProductDtoFullSmall(el))
                        .collect(Collectors.toList());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
        return productDtoList;
    }

    @Override
    public List<ProductDto> findByCategoryId(Long id) {
        return null;
    }

    @Override
    public List<ProductDto> findByCategoryId(ProductDtoType type, Long id) {
        return null;
    }

    @Override
    public List<ProductDto> findByOption(JSONObject option) {
        return null;
    }

    @Override
    public List<ProductDto> findByOption(ProductDtoType type, JSONObject option) {
        return null;
    }
}

