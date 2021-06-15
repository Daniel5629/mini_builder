package com.mini_builder.mini_builder.config.security;

import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        List<UserDetailDto> userDetailDtoList = query.select(
                Projections.constructor(
                        UserDetailDto.class,
                        userEntity.userId,
                        userEntity.username,
                        userEntity.password,
                        roleEntity.roleName
                )
        )
                .from(userEntity)
                .leftJoin(userEntity.userRoleEntityList, userRoleEntity)
                .leftJoin(userRoleEntity.roleEntity, roleEntity)
                .where(userEntity.username.eq(email))
                .fetch();

        if (userDetailDtoList == null) throw new UsernameNotFoundException("해당 유저가 존재하지 않습니다.");

        List<SimpleGrantedAuthority> roleNameList = userDetailDtoList.stream()
                .map(list -> new SimpleGrantedAuthority(list.getRoleName()))
                .collect(toList());

        UserDetailDto user = userDetailDtoList.get(0);

        CustomUserDetail userDetail = CustomUserDetail.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
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
        private String roleName;

        @QueryProjection
        public UserDetailDto(Long userId, String username, String password, String roleName) {
            this.userId = userId;
            this.username = username;
            this.password = password;
            this.roleName = roleName;
        }
    }
}
