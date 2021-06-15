package com.mini_builder.mini_builder.user.repository;

import com.mini_builder.mini_builder.common.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
}
