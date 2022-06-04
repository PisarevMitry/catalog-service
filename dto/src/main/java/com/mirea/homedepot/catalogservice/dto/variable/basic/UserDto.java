package com.mirea.homedepot.catalogservice.dto.variable.basic;

import com.mirea.homedepot.commonmodule.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Dto {

    private Long id;

    private String email;

    private String password;

    private Set<RoleDto> roles;
}
