package com.mini_builder.mini_builder.common.entity;

import com.mini_builder.mini_builder.common.base.BaseEntityAbstract;
import com.mini_builder.mini_builder.user.controller.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntityAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "user_type", nullable = false)
    private String userType;

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT", length = 4)
    private boolean enabled = true;

    @Column(name = "last_password_changed", nullable = false)
    private LocalDateTime lastPasswordChanged;

    @Column(name = "withdraw", nullable = false, columnDefinition = "TINYINT", length = 4)
    private boolean withdraw;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "password_expired", nullable = false, columnDefinition = "TINYINT", length = 4)
    private boolean passwordExpired = false;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private List<UserRoleEntity> userRoleEntityList;

    public void updatePassword(String encodedPassword) {
        this.password = encodedPassword;
    }

}
