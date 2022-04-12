package com.mirea.homedepot.catalogservice.core.repository.base;

import com.mirea.homedepot.catalogservice.core.model.base.Entity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreeSearchRepository {
    List<Entity> findTreeByParentId(
            @Param("id")
                    Long id);

}
