package com.mirea.homedepot.catalogservice.core.repository.base;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParentSearchRepository {
    List<Entity> findTreeIterationByParentId(
            @Param("id")
                    Long id);

    List<Entity> findTreePathByParentId(
            @Param("id")
                    Long id);

}
