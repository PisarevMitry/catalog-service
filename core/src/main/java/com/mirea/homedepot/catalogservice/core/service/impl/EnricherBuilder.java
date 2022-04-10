package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.Entity;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;

import java.util.List;

public class EnricherBuilder {
    private Entity entity;

    private Dto dto;

    private List<Dto> entityList;

    private List<Dto> dtoList;

    public EnricherBuilder setEntity(Entity entity) {
        this.entity = entity;
        return this;
    }

    public EnricherBuilder setDto(Dto dto) {
        this.dto = dto;
        return this;
    }

    public EnricherBuilder setEntityList(List<Dto> entityList) {
        this.entityList = entityList;
        return this;
    }

    public EnricherBuilder setDtoList(List<Dto> dtoList) {
        this.dtoList = dtoList;
        return this;
    }

    public ProductPhotoServiceImpl.EnricherProductPhotoDto createEnricherProductPhotoDto() {
        return new ProductPhotoServiceImpl.EnricherProductPhotoDto(entity);
    }
}