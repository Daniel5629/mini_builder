package com.mini_builder.mini_builder.user.service;

import com.mini_builder.mini_builder.common.entity.UserEntity;
import com.mini_builder.mini_builder.user.controller.dto.UserDto;
import com.mini_builder.mini_builder.user.controller.dto.UserInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> getUsers();

    Optional<UserEntity> getUser(Long userId);

    Optional<UserEntity> createUser(UserDto userDto);

    Page<UserInfoDto> getUserInfos(Pageable pageable);

    void deleteUser(Long userId);

}
