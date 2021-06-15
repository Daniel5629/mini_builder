package com.mini_builder.mini_builder.user.controller.dto;

import com.mini_builder.mini_builder.common.base.BaseDtoAbstract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SignInDto extends BaseDtoAbstract {
    private String username;
    private String password;
}
