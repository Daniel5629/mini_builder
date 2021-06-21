package com.mini_builder.mini_builder.user.controller.dto;

import com.mini_builder.mini_builder.common.base.BaseDtoAbstract;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder
public class UserInfoDto extends BaseDtoAbstract {

    private String username;
    private String name;

    @QueryProjection
    public UserInfoDto(String username, String name) {
        this.username = username;
        this.name = name;
    }
}
