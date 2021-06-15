package com.mini_builder.mini_builder.user.service;

import com.mini_builder.mini_builder.common.entity.UserEntity;
import com.mini_builder.mini_builder.user.controller.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> getUsers();

    Optional<UserEntity> getUser(Long userId);

    Optional<UserEntity> createUser(UserDto userDto);

    void deleteUser(Long userId);

}
