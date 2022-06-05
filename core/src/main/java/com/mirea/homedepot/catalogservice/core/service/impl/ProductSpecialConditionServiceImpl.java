package com.mirea.homedepot.catalogservice.core.service.impl;

import com.mirea.homedepot.catalogservice.core.model.entity.ProductSpecialConditionEntity;
import com.mirea.homedepot.catalogservice.core.repository.ProductSpecialConditionRepository;
import com.mirea.homedepot.catalogservice.core.service.ProductSpecialConditionService;
import com.mirea.homedepot.catalogservice.dto.variable.basic.ProductSpecialConditionDtoDefault;
import com.mirea.homedepot.catalogservice.utils.SelectorDto;
import com.mirea.homedepot.catalogservice.utils.SelectorEntity;
import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.model.Entity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductSpecialConditionServiceImpl implements ProductSpecialConditionService {

    private final ProductSpecialConditionRepository productSpecialConditionRepository;


    @Override
    public List<Dto> findAll() {
        List<Entity> productSpecialConditionEntityList = productSpecialConditionRepository.findAll();
        return SelectorDto.mapFromEntity().select(productSpecialConditionEntityList, ProductSpecialConditionDtoDefault.class);
    }

    @Override
    public Dto findById(Long productSpecialConditionId) {
        Entity productSpecialConditionEntity = productSpecialConditionRepository.findById(productSpecialConditionId);
        return SelectorDto.mapFromEntity().select(productSpecialConditionEntity, ProductSpecialConditionDtoDefault.class);
    }

    @Override
    public List<Dto> findByListId(List<Long> listId) {
        List<Entity> productSpecialConditionEntityList = productSpecialConditionRepository.findByListId(listId);
        return SelectorDto.mapFromEntity().select(productSpecialConditionEntityList, ProductSpecialConditionDtoDefault.class);
    }

    @Override
    public void insert(Dto productSpecialConditionDto) {
        Entity productSpecialConditionEntity = SelectorEntity.mapFromDto().select(productSpecialConditionDto, ProductSpecialConditionEntity.class);
        if (productSpecialConditionEntity.getId() == null) {
            productSpecialConditionRepository.insert(productSpecialConditionEntity);
        } else {
            productSpecialConditionRepository.update(productSpecialConditionEntity);
        }
    }

    @Override
    public void insertList(List<Dto> productSpecialConditionDtoList) {
        List<Entity> productSpecialConditionEntityList =
            SelectorEntity.mapFromDto().select(productSpecialConditionDtoList, ProductSpecialConditionEntity.class);
        productSpecialConditionRepository.insertList(productSpecialConditionEntityList);
    }

    @Override
    public void update(Dto productSpecialConditionDto) {
        Entity productSpecialConditionEntity = SelectorEntity.mapFromDto().select(productSpecialConditionDto, ProductSpecialConditionEntity.class);
        productSpecialConditionRepository.update(productSpecialConditionEntity);
    }

    @Override
    public void deleteById(Long productSpecialConditionId) {
        productSpecialConditionRepository.deleteById(productSpecialConditionId);
    }

}