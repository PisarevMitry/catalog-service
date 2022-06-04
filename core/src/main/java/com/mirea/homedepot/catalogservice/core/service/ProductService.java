package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.dto.type.ProductDtoType;
import com.mirea.homedepot.commonmodule.services.CrudServiceForDefaultDto;
import com.mirea.homedepot.commonmodule.services.CrudServiceForNotDefaultDto;
import org.json.JSONObject;

import java.util.List;

public interface ProductService extends CrudServiceForDefaultDto,
                                        CrudServiceForNotDefaultDto<ProductDtoType> {

    List<Dto> findByCategoryId(Long id);

    List<Dto> findByCategoryId(ProductDtoType type, Long id);

    List<Dto> findByListCategoryId(List<Long> listId);

    List<Dto> findByListCategoryId(ProductDtoType type, List<Long> listId);

    List<Dto> findByOption(JSONObject option);

    List<Dto> findByOption(ProductDtoType type, JSONObject option);

}
