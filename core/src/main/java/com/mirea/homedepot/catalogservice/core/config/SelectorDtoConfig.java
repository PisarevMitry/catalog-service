package com.mirea.homedepot.catalogservice.core.config;

import com.mirea.homedepot.catalogservice.core.model.entity.Entity;
import com.mirea.homedepot.catalogservice.core.service.impl.SelectorDto;
import com.mirea.homedepot.catalogservice.dto.abstractive.Dto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SelectorDtoConfig {
    @Autowired
    private ModelMapper modelMapper;

    @Bean
    public SelectorDto<Dto> selectorDtoFromDto() {
        return new SelectorDto<Dto>(modelMapper);
    }

    @Bean
    public SelectorDto<Entity> SelectorDtoFromEntity() {
        return new SelectorDto<Entity>(modelMapper);
    }



}
