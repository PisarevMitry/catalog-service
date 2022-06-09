package com.mirea.homedepot.catalogservice.core.controller;

import com.mirea.homedepot.catalogservice.core.service.UserService;
import com.mirea.homedepot.commonmodule.dto.Dto;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<Dto> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Dto getById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/list")
    List<Dto> getByListId(@RequestBody List<Long> listId) {
        return userService.findByListId(listId);
    }
}

