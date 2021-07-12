package com.mini_builder.mini_builder.common.entity;

import com.mini_builder.mini_builder.common.base.BaseEntity;
import com.mini_builder.mini_builder.common.status.MemberType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member", uniqueConstraints = {@UniqueConstraint(name = "uk_user_id", columnNames = "user_id")})
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "member_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;
}
