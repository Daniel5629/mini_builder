package com.mini_builder.mini_builder.user.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class SignUpDto extends BaseDtoAbstract {

    private String username;

    private String password;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .username(username)
                .password(password)
                .build();
    }

    @JsonIgnore
    public void setEncodePassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
