package com.mini_builder.mini_builder.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {


    @GetMapping("/v1/user/{userId}")
    public String getUser(@PathVariable("userId") Long userId) {
        return "hello";
    }

}
