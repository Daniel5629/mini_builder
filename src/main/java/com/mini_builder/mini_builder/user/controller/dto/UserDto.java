package com.mini_builder.mini_builder.user.controller.dto;

import com.mini_builder.mini_builder.common.base.BaseDtoAbstract;
import com.mini_builder.mini_builder.common.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseDtoAbstract {

    private Long userId;

    private String userType;

    private boolean enabled;

    private LocalDateTime lastPasswordChanged;

    private boolean withdraw;

    private String username;

    private String password;

    private boolean passwordExpired;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userId(userId)
                .userType(userType)
                .enabled(enabled)
                .lastPasswordChanged(lastPasswordChanged)
                .withdraw(withdraw)
                .username(username)
                .password(password)
                .passwordExpired(passwordExpired)
                .build();
    }
}
