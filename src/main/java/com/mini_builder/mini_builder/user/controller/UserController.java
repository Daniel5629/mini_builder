package com.mini_builder.mini_builder.user.controller;

import com.mini_builder.mini_builder.common.entity.UserEntity;
import com.mini_builder.mini_builder.config.security.CustomUserDetail;
import com.mini_builder.mini_builder.user.controller.dto.SignInDto;
import com.mini_builder.mini_builder.user.controller.dto.UserDto;
import com.mini_builder.mini_builder.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {



    private final UserService userService;

    @GetMapping("/v1/user/{userId}")
    public String getUser(@PathVariable("userId") Long userId,
                          @AuthenticationPrincipal CustomUserDetail userDetail) {
        return userDetail.getUsername();
    }

    @PostMapping("/v1/user/sign-up")
    public boolean signUp(@RequestBody UserDto userDto) {
        Optional<UserEntity> user = userService.createUser(userDto);
        return user.isPresent();
    }

    @PostMapping("/v1/user/sign-in")
    public boolean signIn(@RequestBody SignInDto signUpDto) {
        return false;
    }

}
