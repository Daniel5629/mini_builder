package com.mini_builder.mini_builder.user.repository;

import com.mini_builder.mini_builder.common.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
