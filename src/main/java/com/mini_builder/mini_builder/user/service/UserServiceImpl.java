package com.mini_builder.mini_builder.user.service;

import com.mini_builder.mini_builder.user.controller.dto.UserDto;
import com.mini_builder.mini_builder.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("userServiceImpl")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getUsers() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDto> getUser(Long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> createUser(UserDto userDto) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> updateUser(UserDto userDto) {
        return Optional.empty();
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
