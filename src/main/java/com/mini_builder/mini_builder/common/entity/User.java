package com.mini_builder.mini_builder.common.entity;

import com.mini_builder.mini_builder.common.base.BaseEntity;
import com.mini_builder.mini_builder.common.status.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(name = "uk_username", columnNames = {"username"})})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "user_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column(name = "enabled", nullable = false, columnDefinition = "TINYINT", length = 4)
    private boolean enabled;

    @Column(name = "last_password_changed", nullable = false)
    private LocalDateTime lastPasswordChanged;

    @Column(name = "withdraw", nullable = false, columnDefinition = "TINYINT", length = 4)
    private boolean withdraw;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "password_expired", nullable = false, columnDefinition = "TINYINT", length = 4)
    private boolean passwordExpired;
}
