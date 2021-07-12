package com.mini_builder.mini_builder.user.repository;

import com.mini_builder.mini_builder.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
