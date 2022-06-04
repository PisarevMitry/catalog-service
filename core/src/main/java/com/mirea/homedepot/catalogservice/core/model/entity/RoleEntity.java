package com.mirea.homedepot.catalogservice.core.model.entity;

import com.mirea.homedepot.commonmodule.model.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity implements GrantedAuthority, Entity {

    private Long id;

    private String name;

    public RoleEntity(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}