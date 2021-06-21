package com.mini_builder.mini_builder.user.repository;

import com.mini_builder.mini_builder.user.controller.dto.UserInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserQdRepository {

    Page<UserInfoDto> getUserInfos(Pageable pageable);
}
