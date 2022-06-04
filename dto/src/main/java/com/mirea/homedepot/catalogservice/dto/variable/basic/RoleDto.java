package com.mirea.homedepot.catalogservice.dto.variable.basic;

import com.mirea.homedepot.commonmodule.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto implements Dto {
    private Long id;

    private String name;
}
