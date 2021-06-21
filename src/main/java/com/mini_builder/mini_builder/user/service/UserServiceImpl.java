package com.mini_builder.mini_builder.user.service;

import com.mini_builder.mini_builder.common.entity.UserEntity;
import com.mini_builder.mini_builder.user.controller.dto.UserDto;
import com.mini_builder.mini_builder.user.controller.dto.UserInfoDto;
import com.mini_builder.mini_builder.user.repository.UserQdRepository;
import com.mini_builder.mini_builder.user.repository.UserRepository;
import com.mini_builder.mini_builder.user.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final UserQdRepository userQdRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    @Transactional
    public Optional<UserEntity> createUser(UserDto userDto) {

        userDto.setEncodePassword(passwordEncoder.encode(userDto.getPassword()));
        UserEntity userEntity = userRepository.save(userDto.toEntity());

        return Optional.of(userEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserInfoDto> getUserInfos(Pageable pageable) {
        return userQdRepository.getUserInfos(pageable);
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow();
        userRepository.deleteById(userEntity.getUserId());
    }

    protected void createUserRole(Long userId) {
    }
}
