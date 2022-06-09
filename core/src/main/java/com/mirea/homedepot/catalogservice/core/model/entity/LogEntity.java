package com.mirea.homedepot.catalogservice.core.model.entity;

import com.mirea.homedepot.commonmodule.model.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogEntity implements Entity {

    private Long id;

    private LocalDateTime createDttm;

    private String methodName;

    private String className;

    private String userName;
}