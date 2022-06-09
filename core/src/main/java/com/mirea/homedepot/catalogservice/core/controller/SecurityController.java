package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.service.UserService;
import com.mirea.homedepot.catalogservice.dto.variable.basic.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SecurityController {

    private final UserService userService;

    @PostMapping("/registration")
    public void registerNewUser(@RequestBody UserDto userDto) {
        userService.insert(userDto);
    }
}
