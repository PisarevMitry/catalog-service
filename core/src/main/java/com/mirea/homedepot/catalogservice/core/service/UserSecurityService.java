package com.mirea.homedepot.catalogservice.core.service;

import com.mirea.homedepot.commonmodule.dto.Dto;
import com.mirea.homedepot.commonmodule.services.CrudServiceForDefaultDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserSecurityService extends UserDetailsService {
    Dto findByLogin(String login);
}
