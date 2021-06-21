package com.mini_builder.mini_builder.user.repository;

import com.mini_builder.mini_builder.user.controller.dto.UserInfoDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mini_builder.mini_builder.common.entity.QMemberEntity.memberEntity;
import static com.mini_builder.mini_builder.common.entity.QUserEntity.userEntity;

@RequiredArgsConstructor
@Repository
public class UserQdRepositoryImpl implements UserQdRepository {

    private final JPAQueryFactory query;

    @Override
    @Transactional(readOnly = true)
    public Page<UserInfoDto> getUserInfos(Pageable pageable) {
        List<UserInfoDto> userInfoDtos = query.select(
                Projections.constructor(
                        UserInfoDto.class,
                        userEntity.username,
                        memberEntity.name
                )
        ).from(userEntity)
                .innerJoin(memberEntity)
                .on(userEntity.memberId.eq(memberEntity.memberId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(userInfoDtos, pageable, pageable.getPageSize());
    }
}
