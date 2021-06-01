package com.mini_builder.mini_builder.config.security;

import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mini_builder.mini_builder.common.entity.QRoleEntity.roleEntity;
import static com.mini_builder.mini_builder.common.entity.QUserEntity.userEntity;
import static com.mini_builder.mini_builder.common.entity.QUserRoleEntity.userRoleEntity;
import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final JPAQueryFactory query;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDetailDto userDetailDto = query.select(
                Projections.constructor(
                        UserDetailDto.class,
                        userEntity.userId,
                        userEntity.username,
                        userEntity.password
                )
        )
                .from(userEntity)
                .where(userEntity.username.eq(email))
                .fetchOne();

        if (userDetailDto == null) throw new UsernameNotFoundException("해당 유저가 존재하지 않습니다.");

        List<String> roleNames = query.select(roleEntity.roleName)
                .from(roleEntity)
                .leftJoin(userRoleEntity)
                .leftJoin(userEntity)
                .fetch();

        List<SimpleGrantedAuthority> roleNameList = roleNames.stream().map(SimpleGrantedAuthority::new).collect(toList());

        CustomUserDetail userDetail = CustomUserDetail.builder()
                .userId(userDetailDto.getUserId())
                .username(userDetailDto.getUsername())
                .password(userDetailDto.getPassword())
                .authorities(roleNameList)
                .build();

        return userDetail;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    public static class UserDetailDto {
        private Long userId;
        private String username;
        private String password;

        @QueryProjection
        public UserDetailDto(Long userId, String username, String password) {
            this.userId = userId;
            this.username = username;
            this.password = password;
        }
    }
}
