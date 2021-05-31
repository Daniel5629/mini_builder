package com.mini_builder.mini_builder.user.service;

import com.mini_builder.mini_builder.user.controller.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getUsers();

    Optional<UserDto> getUser(Long userId);

    Optional<UserDto> createUser(UserDto userDto);

    Optional<UserDto> updateUser(UserDto userDto);

    void deleteUser(Long userId);

}
