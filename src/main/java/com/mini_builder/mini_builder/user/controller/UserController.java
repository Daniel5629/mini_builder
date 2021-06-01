package com.mini_builder.mini_builder.user.controller;

import com.mini_builder.mini_builder.config.security.CustomUserDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class UserController {

    @GetMapping("/v1/user/{userId}")
    public String getUser(@PathVariable("userId") Long userId,
                                    @ApiIgnore @AuthenticationPrincipal CustomUserDetail userDetail) {
        return userDetail.getUsername();
    }

}
