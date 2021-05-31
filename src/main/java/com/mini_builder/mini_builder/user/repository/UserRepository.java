package com.mini_builder.mini_builder.user.repository;

import com.mini_builder.mini_builder.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
