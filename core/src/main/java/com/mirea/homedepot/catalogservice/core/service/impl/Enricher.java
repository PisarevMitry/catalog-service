package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.Entity;
import com.mirea.homedepot.catalogservice.core.service.base.ProductCategoryService;
import com.mirea.homedepot.catalogservice.core.service.base.ProductFeedbackService;
import com.mirea.homedepot.catalogservice.core.service.base.ProductPhotoService;
import com.mirea.homedepot.catalogservice.core.service.base.ProductService;
import com.mirea.homedepot.catalogservice.core.service.base.ProductSpecialConditionService;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import com.mirea.homedepot.catalogservice.dto.type.ProductPhotoDtoType;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductPhotoDtoDefault;
import com.mirea.homedepot.catalogservice.dto.variable.derived.ProductPhotoDtoWithoutParent;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

class EnricherDto {
}



class EnricherProductPhotoDto {

    ProductCategoryService productCategoryService;

    ProductFeedbackService productFeedbackService;

    ProductPhotoService productPhotoService;

    ProductService productService;

    ProductSpecialConditionService productSpecialConditionService;

    private ModelMapper modelMapper;

    private Entity entity;

    private Dto dto;

    private List<Entity> entityList;

    private List<Dto> dtoList;

    public EnricherProductPhotoDto(Entity entity) {
        this.entity = entity;

    }

    public EnricherProductPhotoDto(Dto dto) {
        this.dto = dto;
    }

    public EnricherProductPhotoDto(List<Entity> entityList) {
        this.entityList = entityList;
    }

    public EnricherProductPhotoDto(List<Dto> dtoList) {
        this.dtoList = dtoList;
    }

    public Dto selector(ProductPhotoDtoType type) {
        switch (type) {
            case DEFAULT:
                return mapToProductPhotoDtoDefault(dto);
            break;
            case WITHOUT_PARENT:
                return mapToProductPhotoDtoWithoutParent(dto);
            break;
        }
    }

    private Dto mapToProductPhotoDtoDefault(Dto dto) {
        return modelMapper.map(dto, ProductPhotoDtoDefault.class);
    }

    Dto mapToProductPhotoDtoWithoutParent(Dto dto) {
        return modelMapper.map(dto, ProductPhotoDtoWithoutParent.class);
    }

    public Dto selector(ProductPhotoDtoType type) {
        switch (type) {
            case DEFAULT:
                return mapToProductPhotoDtoDefault(entity);
            break;
            case WITHOUT_PARENT:
                return mapToProductPhotoDtoWithoutParent(entity);
            break;
        }
    }

    private Dto mapToProductPhotoDtoDefault(Entity entity) {
        return modelMapper.map(entity, ProductPhotoDtoDefault.class);
    }

    Dto mapToProductPhotoDtoWithoutParent(Entity entity) {
        return modelMapper.map(entity, ProductPhotoDtoWithoutParent.class);
    }

    /* public Dto selector(ProductPhotoDtoType type) {
         switch (type) {
             case DEFAULT:
                 return mapToProductPhotoDtoDefault(dto);
             break;
             case WITHOUT_PARENT:
                 return mapToProductPhotoDtoWithoutParent(dto);
             break;
         }
     }

     private Dto mapToProductPhotoDtoDefault(Dto dto) {
         return modelMapper.map(dto, ProductPhotoDtoDefault.class);
     }

     Dto mapToProductPhotoDtoWithoutParent(Dto dto) {
         return modelMapper.map(dto, ProductPhotoDtoWithoutParent.class);
     }

     public Dto selector(ProductPhotoDtoType type) {
         switch (type) {
             case DEFAULT:
                 return mapToProductPhotoDtoDefault(entity);
             break;
             case WITHOUT_PARENT:
                 return mapToProductPhotoDtoWithoutParent(entity);
             break;
         }
     }

     private Dto mapToProductPhotoDtoDefault(Entity entity) {
         return modelMapper.map(entity, ProductPhotoDtoDefault.class);
     }

     Dto mapToProductPhotoDtoWithoutParent(Entity entity) {
         return modelMapper.map(entity, ProductPhotoDtoWithoutParent.class);
     }
 */
    List<Dto> mapToList(List<Dto> list, Dto resultDtoClass) {
        return list.stream().map(el -> modelMapper.map(el, ProductPhotoDtoDefault.class)).collect(Collectors.toList());
    }

    List<Dto> mapToList(List<Entity> list) {
        return list.stream().map(el -> modelMapper.map(el, ProductPhotoDtoDefault.class)).collect(Collectors.toList());
    }

}